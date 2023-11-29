#include <stdio.h>
void suma_dos(int *x, int *y, int *z)
{
    *x = *x + 2;
    *y = *y + 2;
    *z = *z + 2;
}
int main(void)
{
    int n = 42;
    int *pn;
    pn = &n;
    fprintf(stdout, "valor %d y puntero %x\n", n, pn);

    int x;
    int y;
    int z;
    printf("Introduzca tres numeros:");
    scanf("%d %d %d", &x, &y, &z);
    suma_dos(&x, &y, &z);
    printf("%d %d %d", x, y, z); // qué imprimirá??
}
