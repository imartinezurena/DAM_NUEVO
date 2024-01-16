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
#define INTERVALOS 100
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
    int staus;
    int cantidadProcesosHijos = atoi(argv[1]);
    pid_t conjuntoHijos[cantidadProcesosHijos];
    for (int i = 0; i < cantidadProcesosHijos; i++)
    {

        conjuntoHijos[i] = fork();

        if (conjuntoHijos[i] == 0)
        {
            int comienzoBusqueda = INTERVALOS * (i + 1);
            int contadorRecorrido = 0;

            while (esPrimo(comienzoBusqueda) == 0)
            {
                comienzoBusqueda++;
                contadorRecorrido++;
            }
            fprintf("he recorrido %d numero hasta llegar a un primo", contadorRecorrido);
            exit(contadorRecorrido);
        }
    }
    int sumaRecorrido = 0;
    for (int i = 0; i < cantidadProcesosHijos; i++)
    {

        conjuntoHijos[i] = wait(&staus);
        sumaRecorrido = sumaRecorrido + WEXITSTATUS(staus);
        printf("padre pid= %d\n hijo pid= %d ha recorrido %d numeros\n", getpid(), conjuntoHijos[i], WEXITSTATUS(staus));
    }

    printf("la suma recorrida es %d", sumaRecorrido);
}