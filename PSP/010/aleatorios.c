#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(int argc, char *argv[])
{
    int fd[2];

    pipe(fd);

    int numeroHijos = atoi(argv[1]);
    pid_t hijos[numeroHijos];
    int i = 0;
    for (i; i < numeroHijos; i++)
    {
        hijos[i] = fork();
        if (hijos[i] == 0)
        {
            break;
        }
    }
    if (i == numeroHijos)
    {
        wait(NULL);
    }
    else
    {
    }

    return 0;
}