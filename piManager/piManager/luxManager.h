#ifndef __LUXMANAGER_H
#define __LUXMANAGER_H

/* include necessary headers */
#include <stdio.h>
#include <stdint.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <math.h>
#include <linux/i2c-dev.h>
#include <linux/i2c.h>
#include <sys/ioctl.h>
#include <pthread.h>
#include "smbus.h"

/* define constant variables */
#define DEBUG           0
#define POWER_DOWN      0x00
#define POWER_ON        0x01
#define RESET           0x07
#define CONTINUE_HIGH   0x10
#define CONTINUE_LOW    0x13
#define ONE_TIME_HIGH   0x20
#define ONE_TIME_LOW    0x23

#ifndef _SERVERFLAG
#define SERVER_ON       101
#define SERVER_OFF      102
#endif

/* define device address
   if ADDR > 0.7 VCC: 0x23
   if ADDR < 0.3 VCC: 0x53 */
#define BH1750_I2C_ADDR 0x23

/* Declare External Global Variables */
extern unsigned int globalLux;
extern int server_flag;

/* Function Declaration */
void* lux_readSensor();

#endif
