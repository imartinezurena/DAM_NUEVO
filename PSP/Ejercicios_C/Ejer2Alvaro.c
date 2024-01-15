#include <sys/types.h>
#include <stdlib.h> //Para poder poner EXIT_FAILURE
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> //Para incluir wait(NULL)
#include <signal.h>
#include <math.h>
#include <stdbool.h>

#define NUMERO_PARAMETROS 2
#define NUMERO_HIJOS 3

int contadorSeñal = 0;

void mandarSignal(int signo)
{
    if (signo == SIGUSR1)
    {
        if (contadorSeñal <= 0)
        {
            printf("Soy el hijo %d. He sido eliminado.\n", getpid());
            contadorSeñal++;
        }
        else
        {
            printf("Soy el hijo %d. He vuelto a ser eliminado.\n", getpid());
            contadorSeñal++;
        }
    }
}

void manejadorFinSeñal(int signo)
{
    if (signo == SIGINT)
    {
        if (contadorSeñal <= 0)
        {
            printf("Soy el hijo %d. Nunca fui eliminado.\n", getpid());
            exit(EXIT_SUCCESS);
        }
        else
        {
            printf("Soy el hijo %d. Si fui eliminado.\n", getpid());
            exit(EXIT_SUCCESS);
        }
    }
}

int main(int argc, char *argv[])
{

    if (argc != NUMERO_PARAMETROS)
    {
        printf("Debes ingresar %d parametros.\nParámetros ingresados %d.\n", NUMERO_PARAMETROS, argc);
    }

    int numeroSeñales = atoi(argv[1]);
    pid_t idHijos[NUMERO_HIJOS];

    for (int i = 0; i < NUMERO_HIJOS; i++)
    {
        idHijos[i] = fork();

        if (idHijos[i] == 0)
        {
            // Les indico a los hijos lo que deben hacer si reciben la señal
            signal(SIGUSR1, mandarSignal);
            signal(SIGINT, manejadorFinSeñal);

            // Entra en bucle y no hace nada
            while (1)
            {
                sleep(1);
            }

            // Sale del proceso hijo
            exit(EXIT_SUCCESS);
        }
    }

    for (int i = 0; i < NUMERO_HIJOS; i++)
    {
        printf("%d\n", idHijos[i]);
    }

    for (int i = 0; i < numeroSeñales; i++)
    {
        int numeroAleatorio = rand() % NUMERO_HIJOS;
        kill(idHijos[numeroAleatorio], SIGUSR1);
    }

    for (int i = 0; i < NUMERO_HIJOS; i++)
    {
        kill(idHijos[i], SIGINT);
    }

    for (int i = 0; i < NUMERO_HIJOS; i++)
    {
        wait(NULL);
    }

    return 0;
}