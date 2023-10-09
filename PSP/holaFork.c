#include <stdio.h>
#include<unistd.h>
#include<sys/types.h>

int esPrimo(int n){
    return 0;
}

int main(void){
    pid_t id;

    int n=42;
    double pi= 3.14;
    //clonacion
    id =fork();
    //ahora hay dos procesos
    if(id!=0){
        //¿?
        printf("soy tu padre %d y mi hijo es %d\n",getpid(),id);
        n=1000;
        //scanf("%lf", &pi );
        printf("n vale %d\n", n);
    }else{
        //¿?
        printf("soy el hijp %d y mi hijo es %d\n",getpid(),id);
    }
        return 0;

}