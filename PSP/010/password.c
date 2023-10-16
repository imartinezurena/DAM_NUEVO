#include <stdio.h>

int main (void){
  int i; //variable contador para el bucle
  int j;
  int a;
  int b;
    for(i=97; i<123; i++)
    {
      for(a=97; a<123; a++)
      {
        for(b=97; b<123; b++)
        {
          for(j=97; j<123; j++)//bucle for que recorre los caracteres ASCII
          {
          printf("%c%c%c%c " ,i ,a,b,j);//imprimimos el caracter
          }
        }
      } 
    }

    return 0;
}
 