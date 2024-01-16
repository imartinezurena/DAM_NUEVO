/*Crea un programa que reciba por parámetro un número entero positivo n.
Este número indicará el número de hijos.
Cada hijo generará un fichero con la posibles combinación de caracteres de esa longitud.
El hijo 1 una letra, el hijo 2 dos letras 'aa' a la 'zz', etc.
Los nombres serán datos1.txt, datos2.txt, etc.*/
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
// usar la i para montar el nombre del archivo
void generarCombinaciones(int longitud, FILE *archivo)
{
    char combinacion[longitud + 1];
    combinacion[longitud] = '\0'; // Asegurarse de que la cadena esté terminada correctamente

    for (int i = 0; i < longitud; ++i)
    {

        for (char c = 'a'; c <= 'z'; ++c)

        {
            combinacion[i] = c;
            fprintf(archivo, "%s\n", combinacion);
            // queda purificar el bucle
        }
    }
}

int main(int argc, char *argv[])
{
    int cantidadProcesos;
    cantidadProcesos = atoi(argv[1]);
    pid_t hijos[cantidadProcesos];
    printf("%d", cantidadProcesos);
    for (int i = 0; i < cantidadProcesos; i++)
    {
        hijos[i] = fork();
        if (hijos[i] == 0)
        {
            char nombreArchivo[BUFFER];
            snprintf(nombreArchivo, sizeof(nombreArchivo), "datos%d.txt", i + 1);

            FILE *archivo = fopen(nombreArchivo, "w");
            printf("fichero creado %s", nombreArchivo);
            if (archivo == NULL)
            {
                perror("fopen");
                exit(EXIT_FAILURE);
            }

            generarCombinaciones(i + 1, archivo);

            fclose(archivo);
            exit(EXIT_SUCCESS);
        }
    }
    for (int i = 0; i < cantidadProcesos; i++)
    {
        wait(NULL);
    }

    return 0;
}