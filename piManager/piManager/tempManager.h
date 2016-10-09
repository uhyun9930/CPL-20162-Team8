#ifndef __TEMPMANAGER_H
#define __TEMPMANAGER_H

/* include necessary headers */
#include "pinInformation.h"

/* Set GPIO Pin Modes */
#define DATA_DDR_0			(pinMode(SDA, INPUT))
#define DATA_DDR_1			(pinMode(SDA, OUTPUT))
#define DATA_IN				(digitalRead(SDA))
#define SHT_SCK_0			(digitalWrite(SCK, 0))
#define SHT_SCK_1			(digitalWrite(SCK, 1))

/* Declare constant number */
#define noACK				0
#define ACK					1

/* Define Sensor Command */
#define SHT_STATUS_REG_W	0x06
#define SHT_STATUS_REG_R	0x07
#define SHT_MEASURE_TEMP	0x03
#define SHT_MEASURE_HUMI	0x05
#define SHT_RESET			0x1E

#ifndef _SERVERFLAG
#define SERVER_ON           101
#define SERVER_OFF          102
#endif

typedef unsigned char 		uint8;
typedef unsigned int 		uint16;

/* Declare External Global variables */
extern volatile float		G_sht11_temp_f_data;
extern volatile float		G_sht11_humi_f_data;
extern int server_flag;

/* Define Functions */
uint8 SHT11_ByteWR(uint8 value);
uint8 SHT11_ByteRD(uint8 ack);
void SHT11_Start(void);
void SHT11_Reset(void);
uint8 SHT11_HUMI(void);
uint8 SHT11_TEMP(void);
void calc_sht11(void);
void sht11_sensor_run(void);
void* getTempValue();

#endif
