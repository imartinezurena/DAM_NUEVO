--ejercicio 1 
CREATE OR REPLACE TYPE empleado AS OBJECT(
RUT varchar(10),
nombre varchar(10),
cargo varchar(9),
fechaing date,
sueldo number(9),
comision number(9),
anticipo number(9),
member function sueldo_liquido return number,
member procedure aumento_sueldo (aumento number)
);
--ejercicio 2
CREATE OR REPLACE TYPE BODY empleado AS
member function sueldo_liquido return number is 
begin
return(sueldo+comision)-anticipo;
end;
member procedure aumento_sueldo(aumento number) is
sueldoFinal number;
begin
sueldoFinal:=sueldo+aumento;
end;
end;
--ejercicio 3
alter type empleado replace as object(
RUT varchar(10),
nombre varchar(10),
cargo varchar(9),
fechaing date,
sueldo number(9),
comision number(9),
anticipo number(9),
member function sueldo_liquido return number,
member procedure aumento_sueldo (aumento number),
member procedure setAnticipo(anticipado number)
);
--ejercicio 4
CREATE OR REPLACE TYPE BODY empleado AS
member function sueldo_liquido return number is 
begin
return(sueldo+comision)-anticipo;
end;
member procedure aumento_sueldo(aumento number) is
sueldoFinal number;
begin
sueldoFinal:=sueldo+aumento;
end;
member procedure setAnticipo(anticipado number) is begin
anticipo:=anticipado;
end;
end;
--ejercicio 5
create table empleados of empleado;
--ejercicio 6
insert into empleados values('1','pepe','director',sysdate,2000,500,0);
insert into empleados values('2','juan','vendedor',sysdate,1000,300,0);
insert into empleados values('3','elena','vendedor',sysdate,1000,400,0);
--ejercicio 7
DECLARE
    person empleado:=empleado(null,null,null,null,null,null,null);
    CURSOR c1 IS
    SELECT
        *
    FROM
        empleados e
    WHERE
        rut = '1';

BEGIN 
OPEN c1;
    FETCH c1 INTO 
    person.rut,
    person.nombre,
    person.cargo,
    person.fechaing,
    person.sueldo,
    person.comision,
    person.anticipo;
    dbms_output.put_line(person.nombre
                         || ' '
                         || person.cargo
                         || ' sueldo '
                         || person.sueldo
                         || ' sueldo liquido '
                         || person.sueldo);
    person.aumento_sueldo(400);
       dbms_output.put_line(person.nombre
                         || ' '
                         || person.cargo
                         || ' sueldo '
                         || person.sueldo
                         || ' sueldo liquido '
                         || person.sueldo);

    CLOSE c1;
END;
--ejercicio 8
CREATE OR REPLACE TYPE BODY empleado AS
member function sueldo_liquido return number is 
begin
return(sueldo+comision)-anticipo;
end;
member procedure aumento_sueldo(aumento number) is
sueldoFinal number;
begin
sueldoFinal:=sueldo+aumento;
update empleados set sueldo=sueldofinal where nombre=self.nombre;
end;
member procedure setAnticipo(anticipado number) is begin
anticipo:=anticipado;
end;
end;
--ejercicio 9
DECLARE
    salario         NUMBER;
    salarioliquido  NUMBER;
    CURSOR c1 IS
    SELECT
        e.sueldo,
        e.sueldo_liquido()
    FROM
        empleados e;

BEGIN
    OPEN c1;
    FETCH c1 INTO
        salario,
        salarioliquido;
    WHILE c1%found LOOP
        dbms_output.put_line(salario
                             || ' y el sueldo liquido'
                             || salarioliquido);
        FETCH c1 INTO
            salario,
            salarioliquido;
    END LOOP;

    CLOSE c1;
END;





