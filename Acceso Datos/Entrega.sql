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
--ejercicio7
DROP TABLE unitSold;

CREATE TABLE unitSold (
   producto number (10),
   cantidad number (20)
);
declare
pedidos sales_order.order_id%type;
codigo sales_order.customer_id%type;
cursor c1 is
select product_id , (quantity+10) from item where order_id in(
select order_id from sales_order where customer_id=208);

begin
open c1;
fetch c1 into codigo, pedidos;
while c1%found loop
insert into unitSold values (codigo, pedidos);
fetch c1 into codigo, pedidos;
end loop;
close c1;

end;
/
--ejercicio 8
CREATE OR REPLACE PROCEDURE anadepedidos (
    idart      NUMBER,
    cantidad   NUMBER,
    codcli     NUMBER
) IS
    cod_ped item.order_id%TYPE;
BEGIN
    SELECT
        MAX(item.order_id) + 1
    INTO cod_ped
    FROM
        item;

    INSERT INTO sales_order VALUES (
        cod_ped,
        sysdate,
        codcli,
        sysdate,
        cantidad
    );

END anadepedidos;
/
-- ejercicio 9
CREATE OR REPLACE PROCEDURE delpedidos (
    codcli sales_order.customer_id%TYPE
) IS
BEGIN
    DELETE FROM item
    WHERE
        order_id IN (
            SELECT
                order_id
            FROM
                sales_order
            WHERE
                customer_id = codcli
        );
    DELETE FROM sales_order
    WHERE
        customer_id = codcli;

END delpedidos;
/
--ejercicio 10
DROP TABLE temp;

CREATE TABLE temp (
    jobv    NUMBER(3, 0),
    jobn    NUMBER(3, 0),
    codemp  NUMBER(8, 0)
);

CREATE OR REPLACE PROCEDURE cambioempleo (
    empleado  employee.employee_id%TYPE,
    jobn      job.job_id%TYPE
) IS
    antiguo job.job_id%TYPE;
BEGIN
    SELECT
        job_id
    INTO antiguo
    FROM
        employee
    WHERE
        employee.employee_id = empleado;

    UPDATE employee
    SET
        job_id = jobn
    WHERE
        employee_id = empleado;

    INSERT INTO temp VALUES (
        antiguo,
        jobn,
        empleado
    );

END cambioempleo;
--ejercicio 11
CREATE OR REPLACE FUNCTION anual (
    mensualidad  employee.salary%TYPE,
    comision     employee.commission%TYPE
) RETURN NUMBER IS
    anualidad NUMBER;
BEGIN
    anualidad := nvl(mensualidad, 0) * 12 + nvl(comision, 0) * 12;

    RETURN anualidad;
END anual;
--ejercicio 12

CREATE OR REPLACE PACKAGE actualiza AS
    PROCEDURE altapedidos (
        cantidad sales_order.total%TYPE
    );

    PROCEDURE bajapedidos (
        codcli sales_order.customer_id%TYPE
    );
   /* Procedure tablaPedidos(
    
    
    );
    Procedure listar(
    codigo_cli sales_order.customer_id,);*/
    
END actualiza;


CREATE OR REPLACE PACKAGE BODY actualiza AS

    PROCEDURE bajapedidos (
        codcli sales_order.customer_id
    ) IS
    BEGIN
        DELETE FROM sales_order
        WHERE
            order_id IN (
                SELECT
                    sales_order.order_id
                FROM
                    sales_order
                WHERE
                    sales_order.customer_id = codcli
            );

    END bajapedidos;

    PROCEDURE altapedidos (
        cantidad sales_order.total%TYPE
    ) IS
        cliente  sales_order.customer_id;
        pedido   sales_order.order_id;
    BEGIN
        SELECT
            MAX(sales_order.order_id) + 1,
            MAX(sales_order.customer_id) + 1
        INTO
            pedido,
            cliente
        FROM
            sales_order;

        INSERT INTO sales_order VALUES (
            pedido,
            sysdate,
            cliente,
            sysdate,
            cantidad
        );

    END altapedidos;

END actualiza;
--ejercicio 13 no se adaptarlo a esta BD
--ejercicio 14
DROP TABLE temp;

CREATE TABLE temp (
    usuario      VARCHAR(50),
    fecha        DATE,
    descripcion  VARCHAR2(50),
    mensaje      VARCHAR2(50)
);

CREATE OR REPLACE TRIGGER del_product BEFORE
    DELETE ON product
    FOR EACH ROW
BEGIN
    INSERT INTO temp VALUES (
        user,
        sysdate,
        :new.description,
        'producto borrado'
    );

END del_product;

CREATE OR REPLACE TRIGGER mod_product BEFORE
    UPDATE ON product
    FOR EACH ROW
BEGIN
    INSERT INTO temp VALUES (
        user,
        sysdate,
        :new.description,
        'producto actualizado'
    );

END mod_product;

CREATE OR REPLACE TRIGGER in_product BEFORE
    INSERT ON product
    FOR EACH ROW
BEGIN
    INSERT INTO temp VALUES (
        user,
        sysdate,
        :new.description,
        'producto añadido'
    );

END in_product;
--ejercicio 15
DROP TABLE temp;

CREATE TABLE temp (
    empleado  NUMBER,
    mensaje   VARCHAR2(20)
);

CREATE OR REPLACE TRIGGER subidasalario AFTER
    UPDATE OF salary ON employee
    FOR EACH ROW
BEGIN
    IF (
        updating('SALARY')
        AND :new.salary > :old.salary
    ) THEN
        INSERT INTO temp VALUES (
            :old.employee_id,
            'salario subido'
        );

    END IF;
END subidasalario;
--ejercicio 16
drop table temp;
create table temp(
empleado number,
apellido varchar2(30),
departamento number
);

create or replace trigger del_emp after delete on employee
for each row 
begin
insert into temp values (
:old.employee_id, :old.last_name, :old.department_id
);
end del_emp;
--ejercicio 17 no se adaptarlo a esta BD
--ejercicio 18
drop table temp;
create table temp(
mensaje varchar (50)
);
create or replace procedure existencias
is
codigo customer.customer_id%type;
begin
codigo:='&cod';
select * from customer where customer_id=codigo;
insert into temp values('EXISTE');
EXCEPTION
when others then insert into temp values('NO EXISTE');
end existencias;
--ejercicio 19
DROP TABLE temp;

CREATE TABLE temp (
    precio       NUMBER,
    descripcion  VARCHAR2(50)
);

DECLARE
    codigo    product.product_id%TYPE;
    v_precio  temp.precio%TYPE;
    v_des     temp.descripcion%TYPE;
BEGIN
    codigo := '&codigo';
    SELECT
        item.actual_price,
        product.description
    INTO
        v_precio,
        v_des
    FROM
        item,
        product
    WHERE
        item.product_id = product.product_id
        and item.product_id=codigo;

    INSERT INTO temp VALUES (
        v_precio,
        v_des
    );

EXCEPTION
    WHEN no_data_found THEN
        raise_application_error(-20001, 'el producto de codigo '
                                        || codigo
                                        || ' no se ha pedido');
END;
--ejercicio 20
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
    exception 
    when no_data_found then DBMS_OUTPUT.PUT_LINE('no existe el cliente');
    
    END;
	--ejercicio 21
	drop table temp;
create table temp(
id number,
nombre varchar2(50)
);
create or replace trigger del_emp after delete on employee
for each row
begin
insert into temp values(:old.employee_id, :old.first_name);
end del_emp;











