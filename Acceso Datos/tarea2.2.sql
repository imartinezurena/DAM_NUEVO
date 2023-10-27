create or replace type veterinario as object (
id number,
nombre varchar2(50),
direccion varchar2(50)
);
 create or replace type mascota as object(
iden number,
raza varchar2(50),
nombre varchar2(50),
vet ref veterinario
);

--ejercicio a
create table veterinarios of veterinario;
insert into veterinarios values(1,'jesus perez','C/El mareo,29');
--ejercicio b
create table mascotas of mascota;
insert into macostas values(1, 'perro' ,'sproket', (select ref(v) from veterinarios v where v.id=1));
--ejercicio c
select * from mascotas;
--ejercicio d
select iden, raza, nombre, deref(vet).id, deref(vet).nombre, deref(vet).direccion from mascotas;
--ejercicio e
select raza, nombre, deref(vet).nombre from mascotas;
--ejercicio f
drop table macostas;
drop table veterinarios;
drop type mascota;
drop type veterinario;

