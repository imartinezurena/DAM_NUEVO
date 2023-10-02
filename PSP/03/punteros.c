#include <stdio.h>

int main (void){
    int n=42;
    int *pn;
    pn = &n;
    fprint(stdout, "valor %d y puntero %x\n",n ,pn);
}