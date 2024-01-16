/*Crea un programa c que describa las ips que tiene en ordenador en linux*/

#include <sys/types.h>
#include <stdlib.h> //Para poder poner EXIT_FAILURE
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> //Para incluir wait(NULL)
#include <signal.h>   //Para trabajar con señales

int main()
{
    char *program = "ps";
    char *arguments[] = {"ps", "aux", NULL};

    execvp(program, arguments);

    perror("execvp");
    return 1;
}