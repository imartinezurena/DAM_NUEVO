#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <stdbool.h>
#include <math.h>

#define BUFFER 1024
int contadorSenales = 0;
void handlerSigusr(int senal)
{

    if (contadorSenales == 0)
    {
        contadorSenales++;
        printf("soy el hijo %d  y llevo %d señales\n", getpid(), contadorSenales);
    }
    else
    {
        contadorSenales++;
        printf("soy el hijo %d  y he sido eliminado otra vez, llevo %d\n", getpid(), contadorSenales);
    }
}
void handlerSigint(int senal)
{

    printf("soy el hijo %d  y termino\n", getpid());
}
int main(int argc, char *argv[])
{
    int hijoDestino;
    int cantidadProcesosHijos = atoll(argv[1]);
    int numeroSenales = atoll(argv[2]);
    pid_t conjuntoHijos[cantidadProcesosHijos];
    printf("%d\n", numeroSenales);

    for (int i = 0; i < cantidadProcesosHijos; i++)
    {

        conjuntoHijos[i] = fork();

        if (conjuntoHijos[i] == 0)
        {
            signal(SIGUSR1, handlerSigusr);
            signal(SIGINT, handlerSigint);
            while (1)
            {

                sleep(1);
            }
            exit(EXIT_SUCCESS);
        }
    }
    for (int i = 0; i < cantidadProcesosHijos; i++)
    {
        printf("%d\n", conjuntoHijos[i]);
    }

    for (int i = 0; i < numeroSenales; i++)
    {
        // srand((unsigned int)time(NULL));
        hijoDestino = rand() % cantidadProcesosHijos;
        // printf("Hijo muerto: %d\n", conjuntoHijos[i]);
        kill(conjuntoHijos[hijoDestino], SIGUSR1); // Enviar señal a cada hijo
        //  Esperar a que cada hijo termine
    }
    /*for (int i = 0; i < cantidadProcesosHijos; i++)
    {
        kill(conjuntoHijos[i], SIGINT);
    }*/
    for (int i = 0; i < cantidadProcesosHijos; i++)
    {
        wait(NULL);
    }
    return 0;
}