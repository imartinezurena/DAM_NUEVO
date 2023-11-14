--ejercicio 1
create type colec_tipo_nombres_dept as varray(7) of varchar(30);
--ejercicio 2
create table departamentos values(
region varchar2(25),
nombre_dept colec_tipo_nombres_dept
);
--ejercicio 3
insert into departamentos values('europa', colec_tipo_nombres_dept('shipping','sales','finances'));
insert into departamentos values('america', colec_tipo_nombres_dept('ales','finances','shipping'));
insert into departamentos values('asia', colec_tipo_nombres_dept('finances','payroll','shipping','sales'));
--ejercicio 4
select * from departamentos;
--ejercicio 5
DECLARE
    depts  departamentos.nombre_dept%TYPE;
    cont   NUMBER;
BEGIN
    SELECT
        nombre_dept
    INTO depts
    FROM
        departamentos
    WHERE
        region = 'europa';

    cont := depts.first;
    WHILE cont <= depts.last LOOP
        dbms_output.put_line('departamentos ' || depts(cont));
        cont := cont + 1;
    END LOOP;

    dbms_output.put_line('actualizar');
    depts := colec_tipo_nombres_dept('benefits', 'advertising', 'contracting', 'executive', 'marketing');
    UPDATE departamentos
    SET
        nombre_dept = depts
    WHERE
        region = 'europa';

    SELECT
        nombre_dept
    INTO depts
    FROM
        departamentos
    WHERE
        region = 'europa';

    cont := depts.first;
    WHILE cont <= depts.last LOOP
        dbms_output.put_line('departamentos ' || depts(cont));
        cont := cont + 1;
    END LOOP;

END;
--ejercicio 6
DECLARE
    depts  departamentos.nombre_dept%TYPE;
    cont   NUMBER;
    reg    departamentos.region%TYPE;
    CURSOR c1 IS
    SELECT
        region,
        nombre_dept
    FROM
        departamentos;

BEGIN
    OPEN c1;
    FETCH c1 INTO
        reg,
        depts;
    WHILE c1%found LOOP
        dbms_output.put_line('region: ' || reg);
        cont := depts.first;
        WHILE cont <= depts.last LOOP
            dbms_output.put_line('departamentos '||'('||cont||')' || depts(cont));
            cont := cont + 1;
        END LOOP;

        FETCH c1 INTO
            reg,
            depts;
    END LOOP;

END;

