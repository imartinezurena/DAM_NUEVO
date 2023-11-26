/*Crea un proceso que sea capaz de gestionar un señal definida por el usuario. Luego hará fork y el padre le enviará la señas al hijo.
Al gestionar la señal el hijo escribirá "Recibido y terminará el proceso."*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
void manejador_senales(int senal)
{
    pid_t hijo = fork();
    pid_t pid_hijo;
    if (hijo < 0)
    { // este if es la manera standar de comprobar la creacion de hijos
        perror("error añ crear el hijo");
        return 1;
    }
    else if (hijo == 0)
    {                        // este sería el codigo del hijo ya que la función fork devuelve el id del proceso hijo
        pid_hijo = getpid(); // en esta variable guardamos el id del proceso hijo con la funcion getpid;
        printf("pid hijo muerto : %d , señal recibida %d", pid_hijo, senal);
        exit(0);
    }
}
int main()
{
    signal(SIGUSR1, manejador_senales);
    while (1)
    {
        sleep(1);
    }
    return 0;
}