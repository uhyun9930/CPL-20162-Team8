#include "luxManager.h"

void* lux_readSensor()
{
    int fd;
    char *fileName = "/dev/i2c-1";
    int retCode;
    int readSize;
    unsigned int res;
    unsigned int lux;
    char buf[5];

    /* Open port for reading and writing */
    if ((fd = open(fileName, O_RDWR)) < 0)
    {
        fprintf(stderr, "File <%s> open error.\n", fileName);
        pthread_exit(0);
    }

    /* Set the port options and set the address of the device */
    if (ioctl(fd, I2C_SLAVE, BH1750_I2C_ADDR) < 0)
    {
        fprintf(stderr, "ioctl error\n");
        close(fd);
        pthread_exit(0);
    }

    retCode = i2c_smbus_write_byte(fd, POWER_ON);

    if (DEBUG)
    {
        fprintf(stderr, "Power On retCode = %d\n", retCode);
    }

    if (retCode < 0)
    {
        fprintf(stderr, "Power On Error\n");
        close(fd);
        pthread_exit(0);
    }

    retCode = i2c_smbus_write_byte(fd, CONTINUE_HIGH);

    if (DEBUG)
    {
        fprintf(stderr, "CONTINUE_HIGH retCode = %d\n", retCode);
    }

    if (retCode < 0)
    {
        fprintf(stderr, "CONTINUE_HIGH Error\n");
        close(fd);
        pthread_exit(0);
    }

    while (1)
    {
        if (server_flag == SERVER_OFF)
        {
            break;
        }

        readSize = read(fd, buf, 2);

        if (DEBUG)
        {
            fprintf(stderr, "Readsize = %d %x %x\n", readSize, buf[0], buf[1]);
        }

        res = (buf[0] * 256) + buf[1];

        if (DEBUG)
        {
            fprintf(stderr, "res = %x\n", res);
        }

        lux = res / 1.2;

        globalLux = lux;

        sleep(1);
    }

    retCode = i2c_smbus_write_byte(fd, POWER_DOWN);
    close(fd);

    pthread_exit(0);
}
