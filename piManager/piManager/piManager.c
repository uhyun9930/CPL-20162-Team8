#include <stdlib.h>
#include "piManager.h"

int doorState;
int waitFlag;
int server_flag;
unsigned int globalLux;
volatile float G_sht11_temp_f_data;
volatile float G_sht11_humi_f_data;
const int server_portNumber = 63637;

int main()
{
    printf( "piManager Start... : compiled on %s at time %s\n", __DATE__, __TIME__);

	pthread_t tid[8];
	pthread_attr_t attr;
	FILE *fp_log = NULL;
	command *c = NULL;
	char tempRet[100];
	char client_command[BUF_SIZE + 1];
	char f_name[30];
	char message[BUF_SIZE + 1];
	int serv_sock, clnt_sock;
	int str_len;
	struct sockaddr_in serv_adr, clnt_adr;
	socklen_t clnt_adr_sz;
    char clientAddr[100];
    char ipAddr[20];

	/* server initialize */
	serv_sock = socket(PF_INET, SOCK_STREAM, 0);
	if (serv_sock == -1)
	{
		fprintf(stderr, "socket() error\n");
		return -1;
	}

	memset(&serv_adr, 0, sizeof(serv_adr));
	serv_adr.sin_family = AF_INET;
	serv_adr.sin_addr.s_addr = htonl(INADDR_ANY);
	serv_adr.sin_port = htons(server_portNumber);

	if (bind(serv_sock, (struct sockaddr *)&serv_adr, sizeof(serv_adr)) == -1)
	{
		fprintf(stderr, "bind() error\n");
		return -1;
	}

	if (listen(serv_sock, 1) == -1)
	{
		fprintf(stderr, "listen() error\n");
		return -1;
	}

	/* log initialize */
	getCurrentTime(GET_TIME_FOR_FILE, f_name);
	fp_log = log_initialize(f_name);

	gpio_initialize(fp_log);

	/* Thread initialize */
	pthread_attr_init(&attr);

	/* Create temp/door/lux sensing thread */
	pthread_create(&tid[0], &attr, readSwitch, NULL);
	pthread_create(&tid[1], &attr, getTempValue, NULL);
    pthread_create(&tid[6], &attr, log_liveMessage, f_name);
    pthread_create(&tid[7], &attr, lux_readSensor, NULL);

	while (1)
	{
		/* Wait for Client connecting */
        memset(clientAddr, '\0', sizeof(clientAddr));
        memset(ipAddr, '\0', sizeof(ipAddr));
		clnt_adr_sz = sizeof(clnt_adr);
		log_putMessage(fp_log, "Wait for connecting");
		fclose(fp_log);
        waitFlag = SERVER_WAIT;
		clnt_sock = accept(serv_sock, (struct sockaddr *)&clnt_adr, &clnt_adr_sz);
		fp_log = fopen(f_name, "a");
		if (fp_log == NULL)
		{
			fprintf(stderr, "Log file creation failed.\n");
			return -2;
		}
		if (clnt_sock == -1)
		{
			log_putMessage(fp_log, "accept() error");
			return -1;
		}
		else
		{
            inet_ntop(AF_INET, &clnt_adr.sin_addr.s_addr, ipAddr, sizeof(ipAddr));
            sprintf(clientAddr, "Client %s Connected", ipAddr);
			log_putMessage(fp_log, clientAddr);
		}
		fclose(fp_log);

		while (1)
		{
			/* Prepare Log file */
			fp_log = fopen(f_name, "a");
			if (fp_log == NULL)
			{
				fprintf(stderr, "Log file creation failed.\n");
				return -2;
			}

			/* Prepare client message buffer */
			memset(message, '\0', sizeof(message));

			/* Check Client Connection */
			if ((str_len = read(clnt_sock, message, BUF_SIZE)) == 0)
			{
				log_putMessage(fp_log, "Client disconnected.");
				break;
			}
            else
            {
			    //printf("str_len == %d\n", str_len);
                waitFlag = SERVER_WORKING;
            }

			sprintf(client_command, "Message from client=> %s", message);
			log_putMessage(fp_log, client_command);

			/* command initialize */
			c = command_initialize();

			/* Parsing command from client */
			command_parsing(c, message);

			switch (c->command)
			{
                case COMMAND_SERVER_DESTROY:
                    log_putMessage(fp_log, "Command Server Context destroy is arrived.");
                    log_putMessage(fp_log, "Server Context destroy is started.");
                    server_flag = SERVER_OFF;
                    break;
				case COMMAND_EXIT:
					log_putMessage(fp_log, "Client disconnected.");
					break;
				case COMMAND_GET_DOOR:
					log_putMessage(fp_log, "Command getDoorState is arrived.");
					c->ret_val = getDoorState();
					break;
				case COMMAND_GET_TEMP:
					log_putMessage(fp_log, "Command getTempState is arrived.");
					break;
				case COMMAND_POWER:
					log_putMessage(fp_log, "Command setPowerRelay is arrived.");
					pthread_create(&tid[2], &attr, power_control, c->powerP);
					c->ret_val = pthread_join(tid[2], NULL);
					break;
				case COMMAND_IRIS_MOTOR:
					log_putMessage(fp_log, "Command Iris Motor control is arrived.");
					pthread_create(&tid[3], &attr, iris_motor_runner, c->motorP);
					c->ret_val = pthread_join(tid[3], NULL);
					break;
				case COMMAND_FOCUS_MOTOR:
					log_putMessage(fp_log, "Command Focus Motor control is arrived.");
					pthread_create(&tid[4], &attr, focus_motor_runner, c->motorP);
					c->ret_val = pthread_join(tid[4], NULL);
					break;
				case COMMAND_ZOOM_MOTOR:
					log_putMessage(fp_log, "Command Zoom Motor control is arrived.");
					pthread_create(&tid[5], &attr, zoom_motor_runner, c->motorP);
					c->ret_val = pthread_join(tid[5], NULL);
					break;
				case COMMAND_WRONG_CONNECT:
					log_putMessage(fp_log, "Illegal Connection detected.");
					break;
                case COMMAND_GET_LUX:
                    log_putMessage(fp_log, "Command getLux is arrived.");
                    break;
				default:
					log_putMessage(fp_log, "Command option error");
					break;
			}

            if (server_flag == SERVER_OFF)
            {
                sprintf(tempRet, "Return#piManager Server will be terminated.");
                write(clnt_sock, tempRet, strlen(tempRet));
                log_putMessage(fp_log, "Wait for switchSensor thread termination.");
                pthread_join(tid[0], NULL);
                log_putMessage(fp_log, "switchSensor thread was terminated.");
                log_putMessage(fp_log, "Wait for tempSensor thread termination.");
                pthread_join(tid[1], NULL);
                log_putMessage(fp_log, "tempSensor thread was terminated.");
                log_putMessage(fp_log, "Wait for luxSensor thread termination.");
                pthread_join(tid[7], NULL);
                log_putMessage(fp_log, "luxSensor thread was terminated.");
                log_putMessage(fp_log, "Wait for liveMessage thread termination.");
                pthread_join(tid[6], NULL);
                log_putMessage(fp_log, "liveMessage thread was terminated.");
                break;
            }

			/* Push Return to client */
			switch (c->command)
			{
				case COMMAND_GET_DOOR:
					if (c->ret_val == OPENED)
					{
						sprintf(tempRet, "Return#%d#opened#", COMMAND_GET_DOOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					else
					{
						sprintf(tempRet, "Return#%d#closed#", COMMAND_GET_DOOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					break;
				case COMMAND_GET_TEMP:
					sprintf(tempRet, "Return#%d#%2.2f#%2.2f#", COMMAND_GET_TEMP, G_sht11_temp_f_data, G_sht11_humi_f_data);
					log_putMessage(fp_log, tempRet);
					write(clnt_sock, tempRet, strlen(tempRet));
					break;
				case COMMAND_POWER:
					if (c->ret_val == 0 && c->powerP->result == TRUE)
					{
						sprintf(tempRet, "Return#%d#finished#", COMMAND_POWER);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					else
					{
						sprintf(tempRet, "Return#%d#failed#", COMMAND_POWER);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					break;
				case COMMAND_IRIS_MOTOR:
					if (c->ret_val == 0 && c->motorP->result == TRUE)
					{
						sprintf(tempRet, "Return#%d#finished#", COMMAND_IRIS_MOTOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					else
					{
						sprintf(tempRet, "Return#%d#failed#", COMMAND_IRIS_MOTOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					break;
				case COMMAND_FOCUS_MOTOR:
					if (c->ret_val == 0 && c->motorP->result == TRUE)
					{
						sprintf(tempRet, "Return#%d#finished#", COMMAND_FOCUS_MOTOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					else
					{
						sprintf(tempRet, "Return#%d#failed#", COMMAND_FOCUS_MOTOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					break;
				case COMMAND_ZOOM_MOTOR:
					if (c->ret_val == 0 && c->motorP->result == TRUE)
					{
						sprintf(tempRet, "Return#%d#finished#", COMMAND_ZOOM_MOTOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					else
					{
						sprintf(tempRet, "Return#%d#failed#", COMMAND_ZOOM_MOTOR);
						log_putMessage(fp_log, tempRet);
						write(clnt_sock, tempRet, strlen(tempRet));
					}
					break;
				case COMMAND_WRONG_CONNECT:
					close(clnt_sock);
					break;
                case COMMAND_GET_LUX:
                    sprintf(tempRet, "Return#%d#%d#", COMMAND_GET_LUX, globalLux);
                    log_putMessage(fp_log, tempRet);
                    write(clnt_sock, tempRet, strlen(tempRet));
                    break;
				default:
					sprintf(tempRet, "Return#%d#Command option error#", c->command);
					log_putMessage(fp_log, tempRet);
					write(clnt_sock, tempRet, strlen(tempRet));
					break;
				}
		
			/* Free for finished command */
			if (c->motorP != NULL)
			{
				free(c->motorP);
			}
			if (c->powerP != NULL)
			{
				free(c->powerP);
			}
			if (c->command == COMMAND_WRONG_CONNECT)
			{
				free(c);
				break;
			}
			else
			{
				free(c);
			}

			/* fclose for preserve current log items */
			fclose(fp_log);

            /* Turn off waitFlag */
            waitFlag = SERVER_WAIT;
		}

        if (server_flag == SERVER_OFF)
        {
            if (c->motorP != NULL)
            {
                free(c->motorP);
            }
            if (c->powerP != NULL)
            {
                free(c->powerP);
            }
            free(c);
            break;
        }
	}
	
	close(clnt_sock);
	close(serv_sock);
	gpio_terminate(fp_log);
	log_destroy(fp_log);

	return 0;
}

void gpio_initialize(FILE *fp_log)
{
	if (wiringPiSetup() == -1)
	{
		log_putMessage(fp_log, "GPIO wiringPiSetup() was failed.");
		return ;
	}

	/* temp sensor */
	pinMode(SCK, OUTPUT);

	/* door switch */
	pinMode(INPUT_PIN, INPUT);
	pinMode(OUTPUT_PIN, OUTPUT);

	digitalWrite(OUTPUT_PIN, HIGH);

	/* power relay */
	pinMode(PWR_RELAY, OUTPUT);

	/* motor */
	pinMode(ENABLE_MOT1, OUTPUT);
	pinMode(ENABLE_MOT2, OUTPUT);
	pinMode(ENABLE_MOT3, OUTPUT);
	pinMode(DIRECTION_MOT1, OUTPUT);
	pinMode(DIRECTION_MOT2, OUTPUT);
	pinMode(DIRECTION_MOT3, OUTPUT);
	pinMode(STEP_MOT1, OUTPUT);
	pinMode(STEP_MOT2, OUTPUT);
	pinMode(STEP_MOT3, OUTPUT);

	digitalWrite(ENABLE_MOT1, HIGH);
	digitalWrite(ENABLE_MOT2, HIGH);
	digitalWrite(ENABLE_MOT3, HIGH);

	log_putMessage(fp_log, "GPIO on RaspberryPi is now Ready.");
}

void gpio_terminate(FILE *fp_log)
{
	/* temp sensor */
	pinMode(SCK, INPUT);

	/* door switch */
	pinMode(INPUT_PIN, INPUT);
	pinMode(OUTPUT_PIN, INPUT);

	digitalWrite(OUTPUT_PIN, LOW);

	/* power relay */
	pinMode(PWR_RELAY, INPUT);

	/* motor */
	digitalWrite(ENABLE_MOT1, HIGH);
	digitalWrite(ENABLE_MOT2, HIGH);
	digitalWrite(ENABLE_MOT3, HIGH);

	log_putMessage(fp_log, "GPIO on RaspberryPi is now closed.");
}

command* command_initialize()
{
	command *c = (command *) malloc(sizeof(command));
	if (c == NULL)
	{
		fprintf(stderr, "Memory allocation error: command_initialize()\n");
		return NULL;
	}

	c->command = COMMAND_STANDBY;
	c->ret_val = FALSE;
	c->motorP = NULL;
	c->powerP = NULL;

	return c;
}

void command_parsing(command* c, char *msg)
{
	char *ptr;
	int command;
	int motor_step = -1;
	int motor_direction = -1;
	int power_order = -1;

	/* Check Command signal */
	ptr = strtok(msg, "#");
	if(ptr == NULL)
	{
		perror("NULL");
		c->command = COMMAND_WRONG_CONNECT;
		return ;
	}

	if (strncmp(ptr, "Command", 7) != 0)
	{
		c->command = COMMAND_NO_OPTION;
		return ;
	}

	/* Get command order */
	ptr = strtok(NULL, "#");
    if (ptr == NULL)
    {
        c->command = COMMAND_NO_OPTION;
        return ;
    }
	command = atoi(ptr);
	c->command = command;

	if (command == COMMAND_IRIS_MOTOR || command == COMMAND_FOCUS_MOTOR || command == COMMAND_ZOOM_MOTOR)
	{
		/* Get motor steps */
		ptr = strtok(NULL, "#");
        if (ptr == NULL)
        {
            c->command = COMMAND_NO_OPTION;
            return ;
        }
        motor_step = atoi(ptr);

		/* Get motor direction */
		ptr = strtok(NULL, "#");
        if (ptr == NULL)
        {
            c->command = COMMAND_NO_OPTION;
            return ;
        }
        motor_direction = atoi(ptr);

		/* Create motor parameters */
		c->motorP = command_createMotorParams(motor_step, motor_direction);

		return ;
	}
	else if (command == COMMAND_POWER)
	{
		/* Get power order */
		ptr = strtok(NULL, "#");
        if (ptr == NULL)
        {
            c->command = COMMAND_NO_OPTION;
            return ;
        }
        power_order = atoi(ptr);

		/* Create powerRelay parameters */
		c->powerP = command_createPowerParams(power_order);

		return ;
	}
	else
	{
		return ;
	}

}

motorParams* command_createMotorParams(int steps, int direction)
{
	motorParams *m = (motorParams *) malloc(sizeof(motorParams));
	if (m == NULL)
	{
		fprintf(stderr, "Memory allocation error: command_createMotorParams()\n");
		return NULL;
	}

	m->direction = direction;
	m->steps = steps;
	m->result = FALSE;

	return m;
}

powerParams* command_createPowerParams(int order)
{
	powerParams *p = (powerParams *) malloc(sizeof(powerParams));
	if (p == NULL)
	{
		fprintf(stderr, "Memory allocation error: command_createPowerParams()\n");
		return NULL;
	}

	p->order = order;
	p->result = FALSE;

	return p;
}

void getCurrentTime(int option, char* buf)
{
	time_t timer;
	struct tm *t;
	char currentTime[40];

	timer = time(NULL);
	t = localtime(&timer);

	if (option == GET_TIME_FOR_LOG)
	{
		sprintf(currentTime, "%04d-%02d-%02d-%02d-%02d-%02d: ", t->tm_year + 1900, t->tm_mon + 1, t->tm_mday, t->tm_hour, t->tm_min, t->tm_sec);
	}
	else if (option == GET_TIME_FOR_FILE)
	{
		sprintf(currentTime, "log/%04d-%02d-%02d-%02d-%02d-%02d.txt", t->tm_year + 1900, t->tm_mon + 1, t->tm_mday, t->tm_hour, t->tm_min, t->tm_sec);
	}
    else if (option == GET_TIME_FOR_LIVE)
    {
        sprintf(currentTime, "liveMsg/%04d-%02d-%02d-%02d-%02d-%02d.txt", t->tm_year + 1900, t->tm_mon + 1, t->tm_mday, t->tm_hour, t->tm_min, t->tm_sec);
    }
	else
	{
		sprintf(currentTime, "Error at create time data\n");
	}
	
	strcpy(buf, currentTime);
}

FILE* log_initialize(char *f_name)
{
	FILE *fp_log;

	fp_log = fopen(f_name, "wt");
	if (fp_log == NULL)
	{
		fprintf(stderr, "File <%s> open error.\n", f_name);
		return NULL;
	}

	log_putMessage(fp_log, "PiManager initialized");

	return fp_log;

}

void log_putMessage(FILE* fp_log, char* message)
{
	char time[30];
	char buffer[100];

	getCurrentTime(GET_TIME_FOR_LOG, time);

	strcpy(buffer, time);
	strncat(buffer, message, 70);
	puts(buffer);

	fprintf(fp_log, "%s\n", buffer);
}

void log_destroy(FILE* fp_log)
{
	log_putMessage(fp_log, "PiManager context destroyed");

	fclose(fp_log);
}

void* log_liveMessage(void* f_name)
{
    FILE *fp_liveMsg;
    char logBuffer[100];
    char liveMsgName[40];
    time_t timer;
    struct tm *t;

    getCurrentTime(GET_TIME_FOR_LIVE, liveMsgName);
    fp_liveMsg = fopen(liveMsgName, "w");
    if (fp_liveMsg == NULL)
    {
        fprintf(stderr, "File <%s> open error.\n", liveMsgName);
        pthread_exit(0);
    }
    fclose(fp_liveMsg);

    while (1)
    {
        timer = time(NULL);
        t = localtime(&timer);
        fp_liveMsg = fopen(liveMsgName, "a");
        if (fp_liveMsg == NULL)
        {
            fprintf(stderr, "File <%s> open error.\n", liveMsgName);
            break;
        }

        if (t->tm_hour == 0 && t->tm_min == 0)
        {
	        while (1)
	        {
		        if (waitFlag == SERVER_WAIT)
    		    {
                    log_putMessage(fp_liveMsg, "Day Changed. New log file will be generated.");
    	    	    fclose(fp_liveMsg);
                    getCurrentTime(GET_TIME_FOR_FILE, f_name);
                    getCurrentTime(GET_TIME_FOR_LIVE, liveMsgName);
                    fp_liveMsg = fopen(liveMsgName, "w");
                    if (fp_liveMsg == NULL)
                    {
                        fprintf(stderr, "File <%s> open error.\n", liveMsgName);
                        break;
                    }
    
                    log_putMessage(fp_liveMsg, "New log file was generated.");
                    sleep(30);
                    break;
                }
            }
        }
        else
        {
            log_putMessage(fp_liveMsg, "Server Still alive.");
        }

        fclose(fp_liveMsg);

        if (server_flag == SERVER_OFF)
        {
            break;
        }

        sleep(30);
    }

    pthread_exit(0);
}
