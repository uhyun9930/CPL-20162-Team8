*RaspberryPi3 GPIO device control software*

*Author: _JungHun, Kim_
*Published Date: 09-OCT-2016
*Version: 1.1


1. Operating System and Device Specification
	1. 1) Operating System: Rasbian 3.18.11-v7+
.	1. 2) Device Specification: RaspberryPi3 Model B with 1GB RAM

2. Software Specification
	2. 1) Network Specification: CoAP Communication
     	2. 2) GPIO Information: See the pinInformation.h file.
	2. 3) Command Information: See the piManager.h file.

3. Socket properties
	3. 1) socket port: 63637 (It can be changed at piManager.c)

4. Chip Specification
	5. 1) Temp/humidity Sensor: DHT11
	5. 2) Soil humidity Sensor :  Gravity: Analog Capacitive Soil Moisture Sensor- Corrosion Resistant [SEN0193]
	  5.2.1) Vin : 3.3 ~ 4.4 VDC
	  5.2.2) Vout : 0 ~ 3.0VDC
	  5.2.3) Interface : PH2.0~3
	  5.2.4) 98mm * 23mm(3.86in X 0.905in)
	  5.2.5) 15g
	5. 3) Lux Sensor :           Rohm BH1750FVI

5. Logfile Specification
	6. 1) Log file must be saved into /log/<starttime.txt>
	6. 2) All of related messages saved into logfile.
    	6. 3) LiveMessage must be saved into /liveMsg/<starttime.txt>
    	6. 4) When the date changed, each logfile will be newly generated.

6. Compile and Debug
	7. 1) Makefile is supported.
	7. 2) Gcc compiler 4.6.3 was used. (arm-linux version)
	7. 3) Debugging option (-g) was used.
	7. 4) Compile option -lpthread -lwiringPi is necessary.

8. File Specification
	8. 1) piManager.h      : header of piManager.c
	8. 2) piManager.c      : main source file of piManager program.
	8. 3) tempManager.h    : header of tempManager.c
	8. 4) tempManager.c    : implemantation of temp/humidity functions.
	8. 5) pinInformation.h : GPIO information
	8. 6) Makefile         : compile script
	8. 7) piManager        : executable file (It must be executed with root permission)
	8. 8) log              : directory of logfile.
    	8. 9) smbus.h          : header of smbus.c
    	8.10) smbus.c          : Library of I2C Communication
    	8.11) luxManager.h     : header of luxManager.c
 	8.12) luxManager.c     : implemantation of lux functions.
 