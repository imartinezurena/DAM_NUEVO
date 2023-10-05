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




