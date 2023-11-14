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

 