#include<stdio.h>
#include<string.h>
#include<stdbool.h>
#define BUFFER 1024

int main (void) 
/*
Crea un programa que pida al usuario las notas que ha sacado en 5 exámenes. 
Almacena la información en un array. 
Después mostrá una lista con la nota de los exámenes y si ha aprobado o no. 
La nota media, la nota más alta y la nota más baja.*/
{
    /* code */
    int notas[BUFFER];
    //int minimo 5;
    notas[5]=11;
    //int maximo 6; 
    notas[6]=0 ;
    //int media 7;
    int numeroExamenes = 5;
    for(int i=0;i<numeroExamenes;i++)
    {
        printf("introduce tu nota del examen %d del uno al 10  ", i);
        scanf("%d",&notas[i]);
        if (i==0){notas[5]=notas[i];}
        else if(notas[5]>notas[i]){notas[5]=notas[i];}
        if (notas[6]<notas[i]){notas[6]=notas[i];}
        notas[7]+=notas[i];
    }
printf("la nota minima es: %d, la maxima es: %d y la media es: %d",notas[5],notas[6],notas[7]/numeroExamenes);
     



    return 0;
}
