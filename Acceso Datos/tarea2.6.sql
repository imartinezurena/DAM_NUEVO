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
member procedure setAnticipo
);


