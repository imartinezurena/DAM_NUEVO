/*Crea un proceso que cree dos procesos hijos, luego generará N (20) números aleatorios. Enviará los pares al primer hijo, los impares al segundo.
Los hijos escribirán por pantalla "Soy el hijo 1|2, he recibido ". Por cada número que mande el padre.*/
// bonus:los hijos suman los numeros recibidos y le mandan resultado al padre
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <stdbool.h>

#define READ 0
#define WRITE 1
#define BUFFER 1024
#define NTOTALES 20

int main()
{
    // Hay que utilizar una semilla para generar numeros aleatorios cada vez que se ejecuta el programa, esta utiliza la hora actual
    srand(time(NULL));
    int pipe1[2];
    int pipe2[2];
    int pipe3[2];
    pid_t child1, child2;

    int numero;
    int resultadoOperacion = 0;
    char cadenita[BUFFER];
    char frase2[BUFFER];
    char frase1[BUFFER];
    char cadenaResultadoPares[BUFFER] = "el resultado de la suma de los pares es ";
    char cadenaResultadoImpares[BUFFER] = "el resultado de la suma de los impares es ";

    // Crear un pipe
    if (pipe(pipe1) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }
    if (pipe(pipe2) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }
    if (pipe(pipe3) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Crear el primer proceso hijo
    child1 = fork();

    if (child1 < 0)
    {
        perror("Error al crear el primer proceso hijo");
        return 1;
    }
    else if (child1 == 0)
    {

        close(pipe1[WRITE]);
        close(pipe2[WRITE]);
        close(pipe2[READ]);
        close(pipe3[READ]); // El hijo no escribirá en el pipe, así que cerramos el descriptor de escritura

        while (read(pipe1[READ], &numero, sizeof(numero)) > 0)
        {
            printf("Soy el hijo 1 he recibido el numero: %d\n", numero);
            resultadoOperacion += numero;
        }
        close(pipe1[READ]); // Cerrar el descriptor de lectura después de leer
        sprintf(cadenita, " %d", resultadoOperacion);
        strcat(cadenaResultadoPares, cadenita);
        write(pipe3[WRITE], &cadenaResultadoPares, sizeof(cadenaResultadoPares));
        close(pipe3[WRITE]);
        exit(0);
    }
    else
    {
        // El proceso padre continúa aquí

        // Crear el segundo proceso hijo
        child2 = fork();

        if (child2 < 0)
        {
            perror("Error al crear el segundo proceso hijo");
            return 1;
        }
        else if (child2 == 0)
        {

            close(pipe1[WRITE]);
            close(pipe1[READ]);
            close(pipe3[READ]);
            close(pipe2[WRITE]); // El hijo no escribirá en el pipe, así que cerramos el descriptor de escritura

            while (read(pipe2[READ], &numero, sizeof(numero)) > 0)
            {
                printf("Soy el hijo 2 he recibido el numero: %d\n", numero);
                resultadoOperacion += numero;
            }
            close(pipe2[READ]); // Cerrar el descriptor de lectura después de leer
            sprintf(cadenita, "%d", resultadoOperacion);
            strcat(cadenaResultadoImpares, cadenita);
            write(pipe3[WRITE], &cadenaResultadoImpares, sizeof(cadenaResultadoImpares));
            close(pipe3[WRITE]);
            exit(0);
        }
        else
        {
            close(pipe1[READ]); // El padre no leerá del pipe, así que cerramos el descriptor de lectura
            close(pipe2[READ]); // El padre no leerá del pipe, así que cerramos el descriptor de lectura
            close(pipe3[WRITE]);
            for (int i = 1; i <= NTOTALES; i++)
            {
                numero = rand() % 100;
                if (numero % 2 == 0)
                {
                    // Escribimos los números en el pipe
                    write(pipe1[WRITE], &numero, sizeof(numero));
                }
                else
                {
                    // Escribimos los números en el pipe
                    write(pipe2[WRITE], &numero, sizeof(numero));
                }
            }

            close(pipe1[WRITE]); // Cerrar el descriptor de escritura después de escribir
            close(pipe2[WRITE]); // Cerrar el descriptor de escritura después de escribir

            read(pipe3[READ], &frase1, sizeof(frase1));
            read(pipe3[READ], &frase2, sizeof(frase2));

            close(pipe3[READ]);

            fprintf(stdout, "%s\n", frase1);

            fprintf(stdout, "%s\n", frase2);
            waitpid(child1, NULL, 0); // Esperar a que los procesos hijos terminen
            waitpid(child2, NULL, 0);
        }
    }

    return 0;
}