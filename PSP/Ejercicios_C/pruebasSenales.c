#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <stdbool.h>

void MySignalHandler(int senal)
{
    printf("señal es %d \n", senal);
}

int main(void)
{
    signal(SIGINT,MySignalHandler);
    while (true)
    {
        sleep(1);
    }
    return 0;
}
