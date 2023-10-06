--Ejercicio 1
DROP TABLE temp;

CREATE TABLE temp (
    mensaje  VARCHAR2(30),
    codigo   NUMBER(12)
);

DECLARE
    salario    employee.salary%TYPE;
    resultado  VARCHAR(30);
    empleado   employee.employee_id%TYPE;
BEGIN
    empleado := '&empleado';
    SELECT
        salary
    INTO salario
    FROM
        employee
    WHERE
        employee_id = empleado;

    IF ( salario < 1000 ) THEN
        UPDATE employee
        SET
            salary = salary * 1.2
        WHERE
            employee.employee_id = empleado;

        resultado := 'sueldo actualizado';
        INSERT INTO temp (
            mensaje,
            codigo
        ) VALUES (
            resultado,
            empleado
        );

    ELSE
        resultado := 'no hace falta actualización';
        INSERT INTO temp (
            mensaje,
            codigo
        ) VALUES (
            resultado,
            empleado
        );

    END IF;

END;
/
--ejercicio2

DROP TABLE temp;

CREATE TABLE temp (
    tot_ped     NUMBER(8)NOT NULL,
    precio_tot  NUMBER(8) NOT NULL,
    cod_cli     NUMBER(8) NOT NULL,
    nombre_cli  VARCHAR2(30) NOT NULL
);

DECLARE
    codigo customer.customer_id%TYPE;
    precio sales_order.total%type;
    pedidos number;
    nombre customer.name%type;
    
BEGIN 
codigo := '&codigo'; 
SELECT
    sum(sales_order.total),
    count(*),
    customer.name
INTO
    precio,
    pedidos,
    nombre
FROM
    customer,
    sales_order
WHERE
    customer.customer_id = sales_order.customer_id
    and customer.customer_id=codigo
    group by customer.customer_id, customer.name;
    
    insert into temp values(pedidos,precio,codigo,nombre);
    
    END;
	--ejercicio 3
	
	 DROP TABLE temp;

CREATE TABLE temp (
    cod_emp number,
    nombre varchar2(30),
    trabajo varchar2(30)
);
 
 declare
 type t_reg_emple  is record(
 cod_emp employee.employee_id%type,
 nombre employee.first_name%type,
 trabajo job.function%type
 ); 
 tablaDatos t_reg_emple ;
 begin
 select employee.employee_id ,employee.first_name, job.function into tablaDatos
 from employee, job
 where employee.job_id=job.job_id and
 employee.employee_id='7782';
 insert INTO temp values tabladatos;
 
 end;
 /
 --ejercicio 4
 --ejercicio5
DROP TABLE temp;

CREATE TABLE temp (
   contador number(4),
   nombre varchar2(50)
);
DECLARE
    TYPE nombreclientes IS
        TABLE OF customer.name%TYPE INDEX BY BINARY_INTEGER;
    CURSOR c IS
    SELECT
        customer.name
    FROM
        customer;

    nombre         customer.name%TYPE;
    contador       BINARY_INTEGER := 1;
    tablaclientes  nombreclientes;
BEGIN
    OPEN c;
    FETCH c INTO nombre;
    WHILE c%found LOOP
        tablaclientes(contador) := nombre;
        dbms_output.put_line(tablaclientes(contador));
        insert into temp values (contador, nombre);
        contador := contador + 1;
        insert into temp values (contador, nombre);
        FETCH c INTO nombre;
    END LOOP;

    CLOSE c;
END;
/
--ejercicio6
DROP TABLE temploop;

DROP TABLE tempwhile;

DROP TABLE tempfor;

CREATE TABLE temploop (
    cod_cli  NUMBER(10),
    nom_cli  VARCHAR2(50),
    cod_emp  NUMBER(10)
);

CREATE TABLE tempwhile (
    cod_cli  NUMBER(10),
    nom_cli  VARCHAR2(50),
    cod_emp  NUMBER(10)
);

CREATE TABLE tempfor (
    cod_cli  NUMBER(10),
    nom_cli  VARCHAR2(50),
    cod_emp  NUMBER(10)
);

DECLARE
    CURSOR c IS
    SELECT
        customer.customer_id,
        customer.name,
        employee.employee_id
    FROM
        customer,
        employee
    WHERE
        employee.employee_id = customer.salesperson_id;

    cliente   customer.customer_id%TYPE;
    nombre    customer.name%TYPE;
    empleado  employee.employee_id%TYPE;
BEGIN
    OPEN c;
    LOOP
        FETCH c INTO
            cliente,
            nombre,
            empleado;
        EXIT WHEN c%notfound;
        insert into temploop values (cliente, nombre, empleado);
    END LOOP;
    CLOSE c;
    
    open c;
    fetch c into cliente, nombre, empleado;
    while c%found loop
     insert into tempWhile values (cliente, nombre, empleado);
    fetch c into cliente, nombre, empleado;
    end loop;
    close c;
    
    open c;
    fetch c into cliente, nombre, empleado;
    for i IN 1..1000 LOOP
    EXIT WHEN c%notfound;
    insert into tempFor values (cliente, nombre, empleado);
    fetch c into cliente, nombre, empleado;
      END LOOP;
    close c;
END;
/




