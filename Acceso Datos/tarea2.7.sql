--ejercicio 1
create type colec_hijos as varray(10) of varchar(30);
--ejercicio 2
create table hijos_empleados  (
iden number primary KEY,
nombre varchar(30),
apellido varchar(30),
hijos colec_hijos
);
--ejercicio 3
INSERT INTO hijos_empleados VALUES (
    1,
    'francisco',
    'perez',
    colec_hijos('luis', 'ursula')
);
INSERT INTO hijos_empleados VALUES (
    2,
    'Esperanza',
    'Jimenez',
    colec_hijos('Jose', 'Carlos','Pedro' )
);
--ejercicio 4
selec * from hijos_empleados;
--ejercicio 5
select hijos from hijos_empleados where iden=1;
--ejer 6
select hijos from hijos_empleados;
--ejer 7
declare 
hijo colec_hijos
BEGIN
select hijos into hijo from hijos_empleados where iden =1;
dbms_output.put_line('el empleado 1 tiene '||hijo.last);
end;
--ejercicio 8
declare
hijo hijos_empleados.hijos%type;
nombre hijos_empleados.nombre%type;
iden hijos_empleados.iden%type;
apellido hijos_empleados.apellido%type;
cont number;
cursor cur is
select hijos, nombre, apellido, iden from hijos_empleados;
begin 
open cur;
fetch cur into hijo, nombre, apellido, iden;
while cur%found loop
dbms_output.put_line('iden '||iden||
' nombre '||nombre||
' apellidos '||apellido
);
cont:= hijo.first;
while cont<= hijo.last loop
dbms_output.put_line('el hijo'|| cont||' se llama '||hijo(cont));
cont:=cont+1;
end loop;
fetch cur into hijo, nombre, apellido, iden;
end loop;

end;
--ejercicio 9
DECLARE
    hijo      hijos_empleados.hijos%TYPE;
    nombre    hijos_empleados.nombre%TYPE;
    iden      hijos_empleados.iden%TYPE;
    apellido  hijos_empleados.apellido%TYPE;
    CURSOR cur IS
    SELECT
        hijos,
        nombre,
        apellido,
        iden
    FROM
        hijos_empleados;

BEGIN
    OPEN cur;
    FETCH cur INTO
        hijo,
        nombre,
        apellido,
        iden;
    WHILE cur%found LOOP
        dbms_output.put_line('iden '
                             || iden
                             || ' nombre '
                             || nombre
                             || ' apellidos '
                             || apellido);

        dbms_output.put_line('total de hijos es ' || hijo.last);
        FETCH cur INTO
            hijo,
            nombre,
            apellido,
            iden;
    END LOOP;

END;
--ejercicio 10
DECLARE
    hijo  hijos_empleados.hijos%TYPE;
    cont  NUMBER;
BEGIN
    SELECT
        hijos
    INTO hijo
    FROM
        hijos_empleados
    WHERE
        iden = 1;

    cont := hijo.first;
    WHILE cont <= hijo.last LOOP
        dbms_output.put_line('el hijo'
                             || cont
                             || ' se llama '
                             || hijo(cont));

        cont := cont + 1;
    END LOOP;

    dbms_output.put_line('el hijos despues de añadir');
    hijo.extend;
    hijo(hijo.last) := 'Antonio';
    cont := hijo.first;
    WHILE cont <= hijo.last LOOP
        dbms_output.put_line('el hijo'
                             || cont
                             || ' se llama '
                             || hijo(cont));

        cont := cont + 1;
    END LOOP;

    UPDATE hijos_empleados
    SET
        hijos = hijo
    WHERE
        iden = 1;

END;
--ejercicio 11
DECLARE
    hijo  hijos_empleados.hijos%TYPE;
    cont  NUMBER;
BEGIN
    SELECT
        hijos
    INTO hijo
    FROM
        hijos_empleados
    WHERE
        iden = 1;

    cont := hijo.first;
    WHILE cont < hijo.last LOOP
        dbms_output.put_line('el hijo'
                             || cont
                             || ' se llama '
                             || hijo(cont));

        cont := cont + 1;
    END LOOP;

    dbms_output.put_line('el hijos despues de añadir');
    hijo.extend(3);
    hijo(hijo.last) := 'Luis';
    cont := hijo.first;
    WHILE cont <= hijo.last LOOP
        dbms_output.put_line('el hijo'
                             || cont
                             || ' se llama '
                             || hijo(cont));

        cont := cont + 1;
    END LOOP;

    UPDATE hijos_empleados
    SET
        hijos = hijo
    WHERE
        iden = 1;

END;

select * from hijos_empleados;

--ejercicio 12
select * from user_varrays;
--ejercicio 13
describe colec_hijos;




 