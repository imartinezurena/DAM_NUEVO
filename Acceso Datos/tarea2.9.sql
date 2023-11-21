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


--ejercicio 8

