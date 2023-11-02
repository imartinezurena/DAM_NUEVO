#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

// Función de controlador de señal para SIGINT
void sigint_handler() {
    printf("Se recibió la señal SIGINT (Ctrl + C)\n");
    // Aquí puedes realizar acciones adicionales antes de salir si lo deseas
    exit(0);
}
void manejador_senal(int senal) {
    if (senal==10){
printf("Se recibió la señal SIgusr1\n");
    }else if(senal==12){
        printf("Se recibió la señal SIgusr2\n");

    }
    
    // Aquí puedes realizar acciones adicionales antes de salir si lo deseas
    
}
int main() {
    // Registrar un manejador de señales para SIGINT usando la función signal
    signal(SIGINT, sigint_handler);
    signal(SIGUSR1, manejador_senal);
    signal(SIGUSR2, manejador_senal);

    printf("Ejecuta este programa y presiona Ctrl + C para generar una señal SIGINT.\n");

    // Mantén el programa en ejecución para recibir la señal
    while (1) {
        sleep(10);
        printf(".");
    }

    return 0;
}