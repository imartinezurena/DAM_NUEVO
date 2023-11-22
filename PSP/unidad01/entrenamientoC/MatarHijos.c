/*Crea un programa que reciba un número n por parámetro.
El programa creará n hijos y les enviará una señal a cada uno de ellos para matarlos.*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#define ARGUMENTO_SELECCIONADO 1
void handler(int signum)
{
    printf("Proceso hijo con PID: %d finalizado\n", getpid());
    exit(0);
}

int main(int argc, char *argv[])
{
    /* if (argc != 2)
     {
         printf("Uso: %s <numero_de_hijos>\n", argv[ARGUMENTO_SELECCIONADO]);
         return 1;
     }*/
    int n_procesos = atoi(argv[ARGUMENTO_SELECCIONADO]);
    pid_t conjuntoHijos[n_procesos];
    for (int i = 0; i < n_procesos; i++)
    {
        pid_t hijo = fork();
        if (hijo < 0)
        {
            perror("Error al crear el proceso hijo");
        }

        else if (hijo == 0)
        {
            signal(SIGTERM, handler);
            while (1)
            {
                sleep(1);
            }
        }

        else
        {
            conjuntoHijos[i] = hijo;
        }
        
    }
    for (int i = 0; i < n_procesos; i++)
        {
            printf("Hijo muerto: %d\n", conjuntoHijos[i]);
            kill(conjuntoHijos[i], SIGTERM); // Enviar señal SIGTERM a cada hijo
                                             // Esperar a que cada hijo termine
        }
        for (int i = 0; i < n_procesos; i++)
        {
            wait(NULL);
        }

    return 0;
}