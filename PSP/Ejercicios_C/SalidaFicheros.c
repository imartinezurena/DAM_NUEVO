/*
Crea un proceso que cree un proceso hijo,
el envíe 3 números enteros aleatorios a través de un pipe.
El proceso hijo los ordenará y
los escribirá en el fichero salida.txt.*/
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
int main()
{
    int fd[2];
    pid_t child;

    if (pipe(fd) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }
    child = fork();
    if (child == 0)
    {

        int nRecibido1;
        int nRecibido2;
        int nRecibido3;
        close(fd[WRITE]);
        read(fd[READ], &nRecibido1, sizeof(nRecibido1));
        read(fd[READ], &nRecibido2, sizeof(nRecibido2));
        read(fd[READ], &nRecibido3, sizeof(nRecibido3));

        printf("Proceso hijo recibió los números: %d,%d,%d\n", nRecibido1, nRecibido2, nRecibido3);
        close(fd[READ]);
        if (nRecibido1 > nRecibido2)
        {
            int temp = nRecibido1;
            nRecibido1 = nRecibido2;
            nRecibido2 = temp;
        }

        if (nRecibido2 > nRecibido3)
        {
            int temp = nRecibido2;
            nRecibido2 = nRecibido3;
            nRecibido3 = temp;
        }

        if (nRecibido1 > nRecibido2)
        {
            int temp = nRecibido1;
            nRecibido1 = nRecibido2;
            nRecibido2 = temp;
        }
        // Abrir el archivo en modo escritura de texto
        FILE *archivo = fopen("salida.txt", "w");

        // Comprobar si se pudo abrir el archivo
        if (archivo == NULL)
        {
            perror("No se pudo abrir el archivo");
            return 1;
        }
        // Escribir líneas de texto en el archivo
        fprintf(archivo, "Los numeros aleatorios ordenados de mayor a menor son:\n Numero 1: %d\n Numero 2: %d\n Numero 3: %d\n", nRecibido3, nRecibido2, nRecibido1);
        printf("Los numeros aleatorios ordenados de mayor a menor son:\n Numero 1: %d\n Numero 2: %d\n Numero 3: %d\n", nRecibido3, nRecibido2, nRecibido1);
        // Cerrar el archivo
        fclose(archivo);
        exit(EXIT_SUCCESS);
    }
    else
    {
        srand(time(NULL));
        // Código del proceso padre
        int n1; // Este es el número que el padre enviará al hijo
        int n2;
        int n3;
        n1 = rand() % 100;
        n2 = rand() % 100;
        n3 = rand() % 100;
        close(fd[READ]); // El padre no leerá del pipe, así que cerramos el descriptor de lectura
        printf("el primero %d segundo %d tercer %d\n", n1, n2, n3);
        // Escribimos los números en el pipe
        write(fd[WRITE], &n1, sizeof(n1));
        write(fd[WRITE], &n2, sizeof(n2));
        write(fd[WRITE], &n3, sizeof(n3));
        close(fd[WRITE]); // Cerrar el descriptor de escritura después de escribir

        // Esperar a que el proceso hijo termine
        int status;
        waitpid(child, &status, 0);

        exit(EXIT_SUCCESS);
        printf("Proceso padre terminó\n");
    }

    return 0;
}