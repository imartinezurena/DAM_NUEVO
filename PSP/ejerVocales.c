#include <stdio.h>
#include <string.h>
#define BUFFER 1024

int main(void)
{
    char inputCadena[BUFFER];
    char mayusVocales[] = {'A', 'E', 'I', 'O', 'U'};
    char minuVocales[] = {'a', 'e', 'i', 'o', 'u'};
    int contVocales = 5;
    int mayusculas = 0;
    int minusculas = 0;

    printf("introduce una cadena");
    fgets(inputCadena, BUFFER, stdin);

    for (int i = 0; i < strlen(inputCadena); i++)
    {
        for (int j = 0; j < contVocales; j++)
        {
            if (inputCadena[i] == mayusVocales[j])
            {
                mayusculas++;
            }
            if (inputCadena[i] == minuVocales[j])
            {
                minusculas++;
            }
        }
    }
    printf("la cadena contiene %d mayusculas y %d minusculas", mayusculas, minusculas);

    return 0;
}