#RaspberryPi2 GPIO device control software#

*Author: Nakjung, Kim
*Published Date: 29-JUL-2015
*Version: 1.1


1. Operating System and Device Specification
	1. 1) Operating System: Rasbian 3.18.11-v7+
	1. 2) Device Specification: RaspberryPi2 Model B with 1GB RAM

2. Software Specification
	2. 1) Network Specification: TCP/IP Socket Communication
     	  It provides only 1 by 1 communication between Server and Client.
	2. 2) GPIO Information: See the pinInformation.h file.
	2. 3) Command Information: See the piManager.h file.

3. Socket properties
	3. 1) socket port: 63637 (It can be changed at piManager.c)

4. Motor control
	4. 1) Each stepper motor will running with independant worker threads.
	4. 2) Muiltiple command is not allowed.

5. Chip Specification
	5. 1) Temp/humidity Sensor: Sensirion SHT11
	5. 2) Stepper Motor Driver: DMOS A4998
    5. 3) Lux Sensor:           Rohm BH1750FVI

6. Logfile Specification
	6. 1) Log file must be saved into /log/<starttime.txt>
	6. 2) All of related messages saved into logfile.
    6. 3) LiveMessage must be saved into /liveMsg/<starttime.txt>
    6. 4) When the date changed, each logfile will be newly generated.

7. Compile and Debug
	7. 1) Makefile is supported.
	7. 2) Gcc compiler 4.6.3 was used. (arm-linux version)
	7. 3) Debugging option (-g) was used.
	7. 4) Compile option -lpthread -lwiringPi is necessary.

8. File Specification
	8. 1) piManager.h      : header of piManager.c
	8. 2) piManager.c      : main source file of piManager program.
	8. 3) tempManager.h    : header of tempManager.c
	8. 4) tempManager.c    : implemantation of temp/humidity functions.
	8. 5) doorManager.h    : header of doorManager.c
	8. 6) doorManager.c    : implemantation of door switch sensing functions.
	8. 7) motorManager.h   : header of motorManager.c
	8. 8) motorManager.c   : implemantation of motorl control functions.
	8. 9) powerManager.h   : header of powerManager.c
	8.10) powerManager.c   : implemantation of power relay control functions.
	8.11) pinInformation.h : GPIO information
	8.12) Makefile         : compile script
	8.13) piManager        : executable file (It must be executed with root permission)
	8.14) log              : directory of logfile.
    8.15) smbus.h          : header of smbus.c
    8.16) smbus.c          : Library of I2C Communication
    8.17) luxManager.h     : header of luxManager.c
    8.18) luxManager.c     : implemantation of lux functions.


<! Note !>
1. All of commands from client must be start with 'Command'.
2. Command message seperator must be used '#'.
3. Return Value must be start with 'Return'.
4. Return message seperator must be used '#'.

#Command format: for example, Command#605#100#237
#Return format: for example, Return#605#finished
