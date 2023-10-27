--ejercicio 1
Create or replace type Direccion as object (calle varchar (25), ciudad varchar (20), cpostal number (5));
--ejercicio 2
Create or replace type Persona as object
(codigo number,
nombre varchar2 (15),
direc Direccion,
fecha_nac date);
--ejercicio 3
DECLARE
    dir direccion := direccion(NULL, NULL, NULL);
    p persona:=persona(null,null,null,null);
BEGIN 
dir.calle := 'Berlanas, 19';
dir.ciudad := 'Madrid';
dir.cpostal:=28047;
p.codigo:=1;
p.nombre:='facu';
p.direc:= dir;
p.fecha_nac:=sysdate;
end;
--ejercicio 4
DECLARE
    dire direccion := direccion(NULL, NULL, NULL);
    pe persona:=persona(null,null,null,null);
BEGIN 
dire.calle := 'Embajadores';
dire.ciudad := 'Madrid';
dire.cpostal:=28087;
pe.codigo:=2;
pe.nombre:='fausto';
pe.direc:= dire;
pe.fecha_nac:= sysdate;
end;

create table alumnos of persona;




