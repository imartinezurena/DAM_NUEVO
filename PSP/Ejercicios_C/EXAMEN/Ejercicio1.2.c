#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <stdbool.h>
#include <math.h>
#define READ 0
#define WRITE 1

#define BUFFER 1024
int pipe2[2]; // pipe para la lectura final del padre
int numero;
bool senalRecibida = true;
void handlerSigusr(int senal)
{
    senalRecibida = false;
    printf("hola");
    read(pipe2[READ], &numero, sizeof(numero));
    printf(" la suma de los primos es %d", numero);
    close(pipe2[READ]);
    exit(0);
}
int esPrimo(int numero)
{
    if (numero <= 1)
    {
        return 0; // Los números menores o iguales a 1 no son primos
    }
    for (int i = 2; i * i <= numero; i++)
    {
        if (numero % i == 0)
        {
            return 0; // El número no es primo
        }
    }
    return 1; // El número es primo
}
int main(int argc, char *argv[])
{
    int pipe1[2];

    if (pipe(pipe1) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    pid_t hijo;

    hijo = fork();
    if (hijo == -1)
    {
        perror("fork");
        exit(EXIT_FAILURE);
    }
    if (hijo == 0)
    {
        int sumaPrimos;
        int numeroRecibido;
        close(pipe1[WRITE]);
        close(pipe2[READ]);

        while (read(pipe1[READ], &numeroRecibido, sizeof(numeroRecibido)) > 0)
        {

            printf("hijo: numero recibido es %d\n", numeroRecibido);
            if (numeroRecibido % 10 == 0)
            {
                pid_t padre = getppid();
                kill(padre, SIGUSR1); // Enviar señal al padre
                sleep(3);
                write(pipe2[WRITE], &sumaPrimos, sizeof(sumaPrimos));

                close(pipe2[WRITE]);

                exit(EXIT_SUCCESS);
            }
            if (esPrimo(numeroRecibido) == 1)
            {
                sumaPrimos = sumaPrimos + numeroRecibido;
            }
            sleep(2);
        }
        close(pipe1[READ]);
        exit(EXIT_SUCCESS);
    }
    else
    {

        signal(SIGUSR1, handlerSigusr);
        srand((unsigned int)time(NULL));

        int numeroEnviado;
        close(pipe2[WRITE]);
        close(pipe1[READ]); // en el primer pipe el padre escribe
        while (senalRecibida)
        {
            numeroEnviado = rand() % 900 + 100;
            write(pipe1[WRITE], &numeroEnviado, sizeof(numeroEnviado));
        }
    }
}