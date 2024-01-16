
#include <sys/types.h>
#include <stdlib.h> //Para poder poner EXIT_FAILURE
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> //Para incluir wait(NULL)
#include <signal.h>   //Para trabajar con señales
#include <stdbool.h>
#include <math.h>

#define NUMERO_PARAMETROS 3
#define READ 0
#define WRITE 1

int obtenerLongitud(int numero) // funcion para obtener longitud
{
    int longitud = 0;
    while (numero != 0)
    {
        numero = numero / 10;
        longitud++;
    }
    return longitud;
}

int esPrimo(int numero)
{
    if (numero < 2)
    {
        return 0; // Los números menores que 2 no son primos
    }

    for (int i = 2; i <= sqrt(numero); i++)
    {
        if (numero % i == 0)
        {
            return 0; // No es primo
        }
    }

    return 1; // Es primo
}

int main(int argc, char *argv[])
{

    if (argc != NUMERO_PARAMETROS)
    {
        printf("Debes ingresar tres parámetros.\n1. Nombre Archivo\n2. Longitud numero\n3. Número de procesos\n");
        printf("Parámetros ingresados: %d", argc);
    }

    int pipe1[2], pipe2[2];

    if (pipe(pipe1) == -1)
    {
        perror("Error al crear el pipe 1."); // simplemente se comprueban los pipes
    }

    if (pipe(pipe2) == -1)
    {
        perror("Error al crear el pipe 2.");
    }

    int longitudNumero = atoi(argv[1]); // guarda los argumentos recibidos
    int cantidadNumeros = atoi(argv[2]);

    pid_t hijo1, hijo2;

    hijo1 = fork();
    // crea el primer hijo y lo ejecuta
    if (hijo1 == 0)
    { // Soy el hijo1
        int numerosRecibidos;
        bool primoEncontrado = false;

        close(pipe2[READ]);
        close(pipe2[WRITE]);
        close(pipe1[WRITE]);

        while (read(pipe1[READ], &numerosRecibidos, sizeof(int)) > 0)
        {
            if (esPrimo(numerosRecibidos) == 1)
            {
                printf("Soy el hijo 1, he recibido: %d ¡ES PRIMO!\n", numerosRecibidos);
                primoEncontrado = true;
            }

            if (esPrimo(numerosRecibidos) == 0)
            {
                printf("Soy el hijo 1, he recibido: %d ¡NO ES PRIMO!\n", numerosRecibidos);
            }
        }

        close(pipe1[READ]);
        exit(primoEncontrado);
    }
    // el padre sigue por aqui, crea el segundo hijo y lo ejecuta tambien
    hijo2 = fork();

    if (hijo2 == 0)
    { // Soy el hijo2
        int numerosRecibidos;
        bool primoEncontrado = false;

        close(pipe1[READ]);
        close(pipe2[WRITE]);
        close(pipe2[WRITE]);

        while (read(pipe2[READ], &numerosRecibidos, sizeof(int)) > 0)
        {
            if (esPrimo(numerosRecibidos) == 1)
            {
                printf("Soy el hijo 2, he recibido: %d ¡ES PRIMO!\n", numerosRecibidos);
                primoEncontrado = true;
            }

            if (esPrimo(numerosRecibidos) == 0)
            {
                printf("Soy el hijo 2, he recibido: %d ¡NO ES PRIMO!\n", numerosRecibidos);
            }
        }

        close(pipe2[READ]);
        exit(primoEncontrado);
    }

    close(pipe1[READ]);
    close(pipe2[READ]);

    srand(time(NULL));

    for (int i = 0; i < cantidadNumeros; i++)
    {
        int numeroHijo1 = (rand() % 10 ^ longitudNumero) + 1;
        int numeroHijo2 = (rand() % 10 ^ longitudNumero) + 1;

        write(pipe1[WRITE], &numeroHijo1, sizeof(int));
        write(pipe2[WRITE], &numeroHijo2, sizeof(int));
    }

    close(pipe1[WRITE]);
    close(pipe2[WRITE]);

    // Variables en los que esta el estado
    int encontradoPrimo1;
    int encontradoPrimo2;

    waitpid(hijo1, &encontradoPrimo1, NULL);
    waitpid(hijo2, &encontradoPrimo2, NULL);

    if (WEXITSTATUS(encontradoPrimo1) == true)
    {
        printf("El hijo 1 ha encontrado un numero primo. ¡MUERE!\n");
    }
    else
    {
        printf("El hijo 1 NO encontró numero primo. ¡SE SALVO!\n");
    }

    if (WEXITSTATUS(encontradoPrimo2) == true)
    {
        printf("El hijo 2 ha encontrado un numero primo. ¡MUERE!\n");
    }
    else
    {
        printf("El hijo 2 NO encontró numero primo. ¡SE SALVO!\n");
    }

    return 0;
}