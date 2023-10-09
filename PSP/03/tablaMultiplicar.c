#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int i, j;
    
    for (i = 1; i <= 10; i++) {
        pid_t pid ;
        pid = fork();  // Crea un nuevo proceso
        
        
        if (pid == 0) {
            // Este es el proceso hijo
            printf("Tabla de multiplicar del %d:\n", i);
            for (j = 1; j <= 10; j++) {
                printf("%d x %d = %d\n", i, j, i * j);
            }
            exit(0); // Termina el proceso hijo
        }
    }
    
    // Espera a que todos los procesos hijos terminen
    for (i = 0; i < 10; i++) {
        wait(NULL);
    }
    
    return 0;
}
