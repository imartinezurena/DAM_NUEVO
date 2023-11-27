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
SELECT
        lista.tipo,
        lista.numero
    FROM
        cliente210            cli,
        TABLE ( cli.telf )       lista
    WHERE
        cli.id_cli = 3;
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
DECLARE
    identificador  cliente210.id_cli%TYPE;
    nom            cliente210.nombre%TYPE;
    tele           telefono := telefono(NULL, NULL);
    cont           NUMBER;
    CURSOR c1 IS
    SELECT
        id_cli,
        nombre
    FROM
        cliente210;

    CURSOR c2 (
        identificador cliente210.id_cli%TYPE
    ) IS
    SELECT
        lista.tipo,
        lista.numero
    FROM
        cliente210            cli,
        TABLE ( cli.telf )       lista
    WHERE
        cli.id_cli = identificador;

BEGIN
    OPEN c1;
    FETCH c1 INTO
        identificador,
        nom;
WHILE c1%found LOOP
    dbms_output.put_line(
    'El cliente '||nom||'tiene el id:'||identificador);
    open c2(identificador);
    fetch c2 into
    tele.tipo,
    tele.numero;
    while c2%found loop
    dbms_output.put_line(
    '· '|| tele.tipo|| ' :' || tele.numero
    );FETCH c2 INTO
    tele.tipo,
    tele.numero;
END
    loop;
    CLOSE c2;
    FETCH c1 INTO
        identificador,
        nom;
END LOOP;
    close c1;
END;
    
    
