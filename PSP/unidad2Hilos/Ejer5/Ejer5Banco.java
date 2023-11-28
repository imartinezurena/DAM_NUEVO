package unidad2Hilos.Ejer5;

/*Imagina un sistema de banco en línea que maneja las cuentas de los usuarios.
 Dos usuarios, Alice y Bob, intentan transferir dinero de sus cuentas a una tercera cuenta al mismo tiempo. 
Necesitas asegurarte de que las operaciones se realicen de manera segura y sin conflictos, utilizando sincronización.
Crea dos threads, uno para cada usuario.
 Cada thread intentará realizar 1000 transferencia de dinero de 10 euros.
Usa un método synchronized para asegurar que las operaciones en las cuentas no se realicen simultáneamente, evitando así condiciones de carrera.

Ejecuciones:

Haz una ejcución sin sincronización
Haz una ejecución sincronizada
Posible ejecución sincronizada:

Alice inicia la transferencia.
El thread de Alice adquiere el bloqueo del objeto cuenta.
Bob intenta iniciar su transferencia pero debe esperar.
Alice completa su transferencia y libera el bloqueo.
Bob adquiere el bloqueo y realiza su transferencia. */
public class Ejer5Banco {

}
