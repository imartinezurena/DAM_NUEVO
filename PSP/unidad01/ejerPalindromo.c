#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#define BUFFER 1024
int main(void)
{
    char inputPalabra[BUFFER];
    printf("introduce una palabra");
    scanf("%s", inputPalabra);
    int longitud = strlen(inputPalabra);
    bool palindromo = true;

    for (int i = 0; i < longitud / 2 && palindromo; i++)
    {
        if (inputPalabra[i] == inputPalabra[longitud - i - 1])
        {
            continue;
        }
        else
        {
            palindromo = false;
        }
    }
    if (palindromo)
    {
        printf("es palindromo");
    }
    else
    {
        printf("no lo es");
    }

    return 0;
}