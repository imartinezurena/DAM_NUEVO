#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <stdbool.h>
#include <math.h>
#define NUM_CHILD 5
int doSomething(void)
{
    int ret;
    srand(getpid());
    ret = rand() % 256;
    printf("valor aleatorio calculado %d\n", ret);
    return ret;
}
int main(void)
{
    pid_t pidC;
    int staus;
    for (int i = 0; i < NUM_CHILD; i++)
    {
        pidC = fork();
        if (pidC > 0)
        {
            continue;
        }
        else if (pidC == 0)
        {
            exit(doSomething());
        }
        else
        {
            /* error*/
        }
    }
    for (int i = 0; i < NUM_CHILD; i++)
    {
        pidC = wait(&staus);
        printf("padre pid= %d\n hijo pid= %d y estado %d", getpid(), pidC, WEXITSTATUS(staus));
    }

    while (1)
    {
        sleep(10);
    }

    return 0;
}