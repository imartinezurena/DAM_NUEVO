/*
1.Crear 2 hijos
2.crear pipes para mandar informacion
3.padre manda numero aleatorios en el rango recibido por parametro
4.hijos muestran si es primo o no
5.el que reciba el primo muere
6.el padre espera el pid
*/
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
#define CADENA_MUERTE " y he muerto"
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

    int longitud = atoll(argv[2]);
    int cantidad = atoll(argv[1]);
    int nProcesos = 2;
    bool muertePorPrimo = false;
    pid_t child1, child2;
    int fd1[2];
    int fd2[2];

    // misma formula de siempre para el pipe
    if (pipe(fd1) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    if (pipe(fd2) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    child1 = fork();
    if (child1 < 0)
    {
        perror("Error al crear el primer proceso hijo");
        return 1;
    }
    else if (child1 == 0) // codigo del primer hijo
    {
        int numeroRecibido;
        close(fd1[WRITE]);
        while (read(fd1[READ], &numeroRecibido, sizeof(numeroRecibido)) > 0)
        {
            read(fd1[READ], &numeroRecibido, sizeof(numeroRecibido));
            printf("el numero recibido es %d\n", numeroRecibido);

            if (esPrimo(numeroRecibido))
            {
                printf("y es primo\n");
            }
        }
        close(fd1[READ]);
    }
    else
    {
        child2 = fork();
        if (child2 < 0)
        {
            perror("Error al crear el segundo proceso hijo");
            return 1;
        }
        else if (child2 == 0)
        {

            int numeroRecibido;
            close(fd2[WRITE]);
            while (read(fd2[READ], &numeroRecibido, sizeof(numeroRecibido)) > 0)
            {
                read(fd2[READ], &numeroRecibido, sizeof(numeroRecibido));
                printf("el numero recibido es %d\n", numeroRecibido);
                if (esPrimo(numeroRecibido))
                {
                    printf("y es primo\n");
                }
            }
            close(fd2[READ]);
        }
        else // codigo del padre
        {
            int mensaje;
            int minimoAleatorio = pow(10, longitud - 1);
            int maximoAleatorio = pow(10, longitud) - 1;
            close(fd1[READ]);
            close(fd2[READ]);
            for (int i = 1; i <= cantidad; i++)
            {
                mensaje = rand() % (maximoAleatorio - minimoAleatorio + 1) + minimoAleatorio;
                if (i > cantidad / 2)
                {
                    // Escribimos los números en el pipe
                    write(fd1[WRITE], &mensaje, sizeof(mensaje));
                }
                else
                {
                    // Escribimos los números en el pipe
                    write(fd2[WRITE], &mensaje, sizeof(mensaje));
                }
            }

            write(fd1[WRITE], &mensaje, sizeof(mensaje));
            write(fd2[WRITE], &mensaje, sizeof(mensaje));
            close(fd1[WRITE]);
            close(fd2[WRITE]);
            waitpid(child1, NULL, 0); // Esperar a que los procesos hijos terminen
            waitpid(child2, NULL, 0);
        }
    }

    return 0;
}