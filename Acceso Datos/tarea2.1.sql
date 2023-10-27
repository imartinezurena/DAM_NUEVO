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
insert into alumnos values(p);
end;
--ejercicio 4
create table alumnos of persona;
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
insert into alumnos values(pe);
end;
--ejercicio4b
select * from alumnos ta where ta.direc.ciudad in ('Madrid');
--ejercicio 4c
select codigo, ta.direc.ciudad, ta.direc.calle from alumnos ta;
--ejercicio4d
update alumnos ta  set ta.direc.ciudad=lower('GUADALAJARA') where ta.direc.ciudad='Madrid'  ;
--ejercicio 4e
declare cursor s is SELECT
    nombre,
    direc
FROM alumnos;
    v_nom  alumnos.nombre%TYPE;
    v_dir  alumnos.direc%TYPE;
BEGIN
    OPEN s;
    FETCH s INTO
        v_nom,
        v_dir;
    WHILE s%found LOOP
        dbms_output.put_line('nombre: '
                             || v_nom
                             || ' direccion: '
                             || v_dir.calle);
        FETCH s INTO
            v_nom,
            v_dir;
    END LOOP;
    CLOSE s;
END;
--ejercicio 4f
delete from alumnos ta where upper(ta.direc.ciudad)='GUADALAJARA' ;

















