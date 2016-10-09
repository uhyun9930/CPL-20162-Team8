# ifndef __PIMANAGER_H
#define __PIMANAGER_H

/* include headers */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <pthread.h>
#include <wiringPi.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include "tempManager.h"
#include "pinInformation.h"
#include "luxManager.h"

/* Disable C4996 warning */
#pragma warning(disable:4996)

/* Define constant variables*/
#define SERVER_ON               101
#define SERVER_OFF              102
#define SERVER_WAIT             103
#define SERVER_WORKING          104
#define COMMAND_SERVER_DESTROY  600
#define COMMAND_GET_TEMP		601
#define COMMAND_GET_DOOR		602
#define COMMAND_STANDBY			603
#define COMMAND_EXIT			608
#define COMMAND_WRONG_CONNECT	609
#define COMMAND_NO_OPTION		610
#define COMMAND_GET_LUX         611
#define GET_TIME_FOR_LOG		800
#define GET_TIME_FOR_FILE		801
#define GET_TIME_FOR_LIVE       802
#define BUF_SIZE				100

/* Define overall commmand structure */
typedef struct __COMMAND
{
	int command;
	int ret_val;
} command;

/* Declare Functions */
void gpio_initialize(FILE *fp_log);
void gpio_terminate(FILE *fp_log);
command* command_initialize();
void getCurrentTime(int option, char *currentTime);
FILE* log_initialize(char *f_name);
void log_putMessage(FILE* fp_log, char* message);
void log_destroy(FILE* fp_log);
void command_parsing(command* c, char *clientMsg);
void* log_liveMessage(void *f_name);

#endif
