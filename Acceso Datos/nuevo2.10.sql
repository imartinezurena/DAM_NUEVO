--ejercicio 1
 create type telefono as object(
tipo varchar2(30),
numero number
);
--ejercicio 2
create type listin as table of telefono;
--ejercicio 3
create table cliente210(
id_cli number primary key,
nombre varchar(30),
apellido varchar(30),
direccion varchar(30),
poblacion varchar(30),
provincia varchar(30),
telf listin)
nested table telf store as tel_lab;
--ejercicio 4
insert into cliente210 values(
1,
'facundo',
'jeronimo',
'calle falsa 123',
'madrid',
'madrid',
listin(telefono('movil',654564345),telefono('fijo',916545678),telefono('movil',654564345)))

insert into cliente210 values(
2,
'laura',
'jeronimo',
'calle falsa 321',
'madrid',
'madrid',
listin(telefono('movil',63456784903),telefono('fijo',916545678),telefono('movil',63456784903)))

insert into cliente210 values(
3,
'pipas',
'facundo',
'calle falsa 4321',
'madrid',
'madrid',
listin(telefono('movil',65862453),telefono('fijo',916545678),telefono('movil',65862453)))
--ejercicio 5
select * from cliente210;
--ejercicio 6
select * from dba_segments;
--ejercicio 7
select * from user_objects;
--ejercicio 8
select * from user_nested_tables;
--ejercicio 9

--ejercicio 10
DECLARE 
telefono_nuevos cliente210.telf%type;
begin
telefono_nuevos := listin(telefono('fijo',93444444),telefono('movil personal',6555555),
telefono('movilempresa',6444444));
update cliente210
set telf=telefono_nuevos
where id_cli=1;
end;

--ejercicio 11
select 
lista.tipo,
lista.numero
from cliente210 cli, 
table (cli.telf)   lista 
--ejercicio 12

