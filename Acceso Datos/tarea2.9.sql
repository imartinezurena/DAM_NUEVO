--ejercicio 1
--create or replace type tabla_hijos as object(nombre varchar(30)); 
create type t_anidada as table of varchar2(30);
--ejercicio 2
create table empleado30 (
idemp number ,
nombre varchar(30),
apellidos varchar(30),
hijos t_anidada) nested table hijos store as hijos_anidada;
--ejercicio 3
--a 
select * from user_objects;
--b
select * from user_segments;
select * from user_stored_settings;
--ejercicio 4
insert into empleado30 values(
1,'Fernando', 'Moreno',t_anidada('Elena','Pablo')
);
insert into empleado30 values(
2,'David', 'Sanchez',t_anidada('Carmen','Candela')
);
--ejercicio 5
select * from empleado30;
--ejercicio 6
select hijo.column_value from empleado30 e, table(e.hijos) hijo
where idemp=1;
--ejercicio 7
declare
 hijosNuevos empleado30.hijos%type :=t_anidada('Carmen','Candela','Cayetana');
 begin
 update empleado30
 set hijos=hijosNuevos
 where idemp=1;
 end;

--ejercicio 8
 declare 
hijosEmpleado empleado30.hijos%type;
iden empleado30.idemp%type;
nombre empleado30.nombre%type;
surname empleado30.apellidos%type;
cont number;
cursor c1 is select * from empleado30;
begin
open c1;
fetch c1 into iden, nombre, surname,hijosEmpleado;
while c1%found loop
dbms_output.put_line('el empleado'
||' '||iden
||' '||nombre||' '||surname||' tiene por hijos: ' );
cont:=hijosEmpleado.first;
while cont<= hijosEmpleado.last loop
dbms_output.put_line('  ·'||hijosEmpleado(cont));
cont:=cont+1;
end loop;
fetch c1 into iden, nombre, surname,hijosEmpleado;
end loop;
close c1;
end;

