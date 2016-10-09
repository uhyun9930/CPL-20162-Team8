#ifndef __PININFORMATION_H
#define __PININFORMATION_H

/* include wiringPi headers */
#include <wiringPi.h>

/* Declare Raspberry Pi GPIO Pin number */
/* For Motor */
#define DIRECTION_MOT1		 7
#define DIRECTION_MOT2		 3
#define STEP_MOT1			 0
#define STEP_MOT2			22
#define ENABLE_MOT1			 2
#define ENABLE_MOT2			 26
/* For Temperature */
//#define SDA					24
//#define SCK					25
#define SDA					28
#define SCK					29

/* For Door */
#define INPUT_PIN			 1
#define OUTPUT_PIN			 4

/* For Power Relay */
#define PWR_RELAY			26
#define PWR_RELAY2			27
#define PWR_RELAY3			23

#endif
