#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>

void MySignalHandler(int sig)
{
    printf("señal es %d \n", sig)
}

int main(void)
{
    return 0;
}
