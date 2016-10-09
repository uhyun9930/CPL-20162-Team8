*RaspberryPi3 GPIO device control software*

Author: _JungHun, Kim_ 
Published Date: 09-OCT-2016 
Version: 1.1


1. Operating System and Device Specification
	1. Operating System: Rasbian 3.18.11-v7+
	2. Device Specification: RaspberryPi3 Model B with 1GB RAM

2. Software Specification
	1. Network Specification: CoAP Communication
	2. GPIO Information: See the pinInformation.h file.
	3. Command Information: See the piManager.h file.

3. Socket properties
	1. socket port: 63637 (It can be changed at piManager.c)

4. Chip Specification
	1. Temp/humidity Sensor: DHT11
	2. Soil humidity Sensor :  Gravity: Analog Capacitive Soil Moisture Sensor- Corrosion Resistant [SEN0193]
	  1. Vin : 3.3 ~ 4.4 VDC
	  2. Vout : 0 ~ 3.0VDC
	  3. Interface : PH2.0~3
	  4. 98mm * 23mm(3.86in X 0.905in)
	  5. 15g
	3. Lux Sensor :           Rohm BH1750FVI

5. Logfile Specification
	1. Log file must be saved into /log/<starttime.txt>
	2. All of related messages saved into logfile.
	3. LiveMessage must be saved into /liveMsg/<starttime.txt>
	4. When the date changed, each logfile will be newly generated.

6. Compile and Debug
	1. Makefile is supported.
	2. Gcc compiler 4.6.3 was used. (arm-linux version)
	3. Debugging option (-g) was used.
	4. Compile option -lpthread -lwiringPi is necessary.

7. File Specification
	1. piManager.h      : header of piManager.c
	2. piManager.c      : main source file of piManager program.
	3. tempManager.h    : header of tempManager.c
	4. tempManager.c    : implemantation of temp/humidity functions.
	5. pinInformation.h : GPIO information
	6. Makefile         : compile script
	7. piManager        : executable file (It must be executed with root permission)
	8. log              : directory of logfile.
	9. smbus.h          : header of smbus.c
	10. smbus.c          : Library of I2C Communication
	11. luxManager.h     : header of luxManager.c
	12. luxManager.c     : implemantation of lux functions.
 