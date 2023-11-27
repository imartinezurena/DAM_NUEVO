/*Modifica el anterior programa para que el hijo devuelva el resultado a través de un pipe. NOTA: debes crear dos pipes.*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#define READ 0
#define WRITE 1
#define BUFFER 1024


int main(){
    int fd1[2];
    int fd2[2];
    pid_t pid;

    //misma formula de siempre para el pipe
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
     pid = fork();
    if (pid == -1)
    {
        perror("fork");
        exit(EXIT_FAILURE);
    }
    if(pid==0){
        //codigo del hijo
        int numero1;//en estas variables se guardan los valores que vamos a recibir y mandar al padre
        int numero2;
        char operando[BUFFER];
        int resultado=0;
        close(fd1[WRITE]);
        read(fd1[READ], &numero1, sizeof(numero1));
        read(fd1[READ], &numero2, sizeof(numero2));
        read(fd1[READ], &operando, sizeof(operando));

        if (strcmp(operando, "+") == 0)
        {
            resultado = numero1 + numero2;
        }
        if (strcmp(operando, "-") == 0)
        {
            resultado = numero1 - numero2;
        }
         printf("Proceso hijo recibió la cadena: %d %s %d\n", numero1, operando, numero2);
        close(fd1[READ]);
        //como el hijo va a mandar y a recibir hemos creado dos pipes, con
        //fd1 lo ha usado para leer, ahora fd2 para mandar los valores de vuelta al padre;
        close(fd2[READ]); // En este pipe el hijo escribe asi que cerramos lectura
        write(fd2[WRITE], &resultado, sizeof(resultado));
        close(fd2[WRITE]); // Cerramos el descriptor de escritura
        exit(0);
    }
    else
    {
        int n1;
        int n2;
        char operando[BUFFER];
        int resultado;

        printf("Introduce el primer numero: \n");
        scanf("%d", &n1);
        printf("Introduce el operando: \n");
        scanf("%s", operando);
        printf("Introduce el segundo numero: \n");
        scanf("%d", &n2);

         close(fd1[READ]); //en el primer pipe el padre escribe
         write(fd1[WRITE], &n1, sizeof(n1));
        write(fd1[WRITE], &n2, sizeof(n2));
        write(fd1[WRITE], &operando, sizeof(operando));
        close(fd1[WRITE]);//ya hemos terminado de escribir


        close(fd2[WRITE]);//en el segundo pipe el padre reciba
        read(fd2[READ],&resultado, sizeof(resultado));
        close(fd2[READ]);//ya hemos terminado de leer
        printf("PADRE: El resultado de la operación es: %d\n", resultado);
        // Esperar a que el proceso hijo termine
        wait(NULL);
    }
    return 0;


}