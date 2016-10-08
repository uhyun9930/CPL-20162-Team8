#include "tempManager.h"

volatile unsigned char	TEMP_cksum;
volatile unsigned char	HUMI_cksum;
volatile unsigned int	TEMP_val;
volatile unsigned int	HUMI_val;
volatile float			dew_point;

const float C1 = -4.0;
const float C2 = +0.0405;
const float C3 = +0.0000028;
const float T1 = +0.01;
const float T2 = +0.00008;

uint8 SHT11_ByteWR(uint8 value)
{
	uint8 mask_i, error = 0;

	for (mask_i = 0x80; mask_i > 0; mask_i >>= 1)
	{
		if (mask_i & value)
		{
			DATA_DDR_0;
		}
		else
		{
			DATA_DDR_1;
		}

		delayMicroseconds(2);
		SHT_SCK_1;
		delayMicroseconds(6);
		SHT_SCK_0;
		delayMicroseconds(3);
	}

	DATA_DDR_0;
	SHT_SCK_1;
	delayMicroseconds(3);
	error = DATA_IN;
	delayMicroseconds(2);

	SHT_SCK_0;

	return error;
}

uint8 SHT11_ByteRD(uint8 ack)
{
	uint8 mask_i, val = 0;

	DATA_DDR_0;

	for (mask_i = 0x80; mask_i > 0; mask_i >>= 1)
	{
		SHT_SCK_1;
		delayMicroseconds(3);

		if (DATA_IN)
		{
			val |= mask_i;
		}

		SHT_SCK_0;
		delayMicroseconds(3);
	}

	if (ack)
	{
		DATA_DDR_1;
	}
	else
	{
		DATA_DDR_0;
	}

	SHT_SCK_1;
	delayMicroseconds(6);
	SHT_SCK_0;
	delayMicroseconds(3);
	DATA_DDR_0;

	return val;
}

void SHT11_Start(void)
{
	DATA_DDR_0;
	SHT_SCK_0;
	delayMicroseconds(3);
	SHT_SCK_1;
	delayMicroseconds(3);

	DATA_DDR_1;
	delayMicroseconds(3);
	SHT_SCK_0;
	delayMicroseconds(6);
	SHT_SCK_1;
	delayMicroseconds(3);
	DATA_DDR_0;
	delayMicroseconds(3);
	SHT_SCK_0;
}

void SHT11_Reset(void)
{
	uint8 clock_i;
	
	DATA_DDR_0;
	SHT_SCK_0;
	delayMicroseconds(3);

	for (clock_i = 0; clock_i < 9; clock_i++)
	{
		SHT_SCK_1;
		delayMicroseconds(3);
		SHT_SCK_0;
		delayMicroseconds(3);
	}

	SHT11_Start();
}

uint8 SHT11_HUMI(void)
{
	uint8 error = 0;

	error += SHT11_ByteWR(SHT_MEASURE_HUMI);

	while (1)
	{
		if (!DATA_IN)
		{
			break;
		}
	}

	HUMI_val = SHT11_ByteRD(ACK);
	HUMI_val <<= 8;
	HUMI_val += SHT11_ByteRD(ACK);
	HUMI_cksum = SHT11_ByteRD(noACK);

	return error;
}

uint8 SHT11_TEMP(void)
{
	uint8 error = 0;

	SHT11_Start();
	error+=SHT11_ByteWR(SHT_MEASURE_TEMP);

	while(1)
	{
		if(!DATA_IN)
		{
			break; 
		}
	}

	if(DATA_IN)
	{
		error++;
	}
	
	TEMP_val=SHT11_ByteRD(ACK);
	TEMP_val<<=8;
	TEMP_val+=SHT11_ByteRD(ACK);
	TEMP_cksum=SHT11_ByteRD(noACK);

	return error;
}

void calc_sth11(void)
{
	double rh_lin, rh_true, t_C, TEMP_f, HUMI_f; // logEx;
	TEMP_f = (float) TEMP_val;
	HUMI_f = (float) HUMI_val;
	t_C = (TEMP_f * 0.01) - 40;
	rh_lin = C3*HUMI_f*HUMI_f + C2*HUMI_f + C1;
	rh_true = (t_C - 25) * (T1 + T2 * HUMI_f) + rh_lin;

	if(rh_true > 100)
	{
		rh_true = 100;
	}

	if(rh_true < 0.1)
	{
		rh_true = 0.1;
	}

	if (t_C != 0.0 && t_C != 615.35)
	{
		G_sht11_temp_f_data = (float) t_C;	
		TEMP_val = (uint16) t_C;
	}

	if (rh_true > 0.10 && rh_true < 100.00)
	{
		G_sht11_humi_f_data = (float) rh_true;	
		HUMI_val = (uint16) rh_true;
	}
}

void sht11_sensor_run(void)
{
	uint8 error;

	SHT11_Reset();	

	delay(1);

	error=0;
	error+=SHT11_HUMI();		
	error+=SHT11_TEMP();	
	
	if(error != 0)
	{
		SHT11_Reset();
	}
	else
	{
		calc_sth11(); 
	}
}

void* getTempValue()
{
	while (1)
	{
        if (server_flag == SERVER_OFF)
        {
            break;
        }

		sht11_sensor_run();

		delay(1000);
	}

	pthread_exit(0);
}
