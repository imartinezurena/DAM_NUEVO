--ejercicio 1
create or replace type Tipo_direccion as object (
direccion varchar(50),
codigo_postal varchar(20)
);
--ejercicio 2
create or replace type tipo_contacto as object(
numero varchar2(20),
email varchar2(50));
--ejercicio 3
create or replace type tipo_persona as object(
iden varchar2(20),
nombre varchar2(50),
apellido varchar2(50),
direccion tipo_direccion,
contacto tipo_contacto)not final;

create or replace type tipo_cliente under tipo_persona(numero_pedidos number(7))not final;
--ejercicio 4
 describe tipo_direccion;
 describe tipo_contacto;
 describe tipo_persona;
 describe tipo_cliente;
 --ejercicio 5
 create type tipo_articulo as object(
iden varchar2(20),
nombre varchar2(20),
descripcion varchar2(100),
precio number(8, 2),
porcentaje_iva number(3)
);
--ejercicio 6
describe tipo_articulo;
--ejercicio 7
create or replace type tipo_lista_detalle as object (
numero number(7),
articulo tipo_articulo,
cantidad number(7));
create or replace type tab_lista_detalle as table  of tipo_lista_detalle;
create or replace type tipo_lista_compra as object(
identificador number(7),
cliente tipo_cliente,
detalle tab_lista_detalle,
member function calcular_total
return number
);
--ejercicio 8
CREATE OR REPLACE TYPE BODY tipo_lista_compra AS
    MEMBER FUNCTION calcular_total RETURN NUMBER IS
        total  NUMBER := 0;
        linea  tipo_lista_detalle;
        arti   tipo_articulo;
    BEGIN
        FOR i IN 1..detalle.count LOOP
            linea := detalle(i);
            SELECT
                linea.articulo
            INTO arti
            FROM
                dual;

            total := total + ( linea.cantidad + arti.precio );
        END LOOP;

        RETURN total;
    END;

END;
--ejer 9
create table clientes of tipo_cliente;
insert into clientes values(
1,'facu','campazzo',tipo_direccion('calle falsa 123',28047),
tipo_contacto('647373839', 'facu@facu.com'),
0
);
create table clientes of tipo_cliente;
insert into clientes values(
1,'goku','supersayan',tipo_direccion('calle falsa 456',28047),
tipo_contacto('647334567', 'goku@facu.com'),
0
);
--ejercicio 10
CREATE TABLE compras OF tipo_lista_compra
NESTED TABLE detalle STORE AS detalle_anidada;

INSERT INTO compras VALUES (
    1,
    (
        SELECT
            ref(c)
        FROM
            clientes c
        WHERE
            iden = 1
    ),
    tipo_lista_detalle(4, tipo_articulo(1, 'nachos', 'nachos con sabor a queso', 2, 21), 4)
);

INSERT INTO compras VALUES (
    1,
    (
        SELECT
            ref(c)
        FROM
            clientes c
        WHERE
            iden = 1
    ),
    tab_lista_detalle(tipo_lista_detalle(1, tipo_articulo(1, 'nachos', 'nachos con sabor a queso', 2, 21), 4),
                      tipo_lista_detalle(2, tipo_articulo(2, 'patatas', 'receta original con menos aceite', 1.9, 21), 3))
);
--ejercicio 11
select * from compras; 
--o
SELECT
    identificador,
    c.cliente.nombre,
    d.numero,
    d.articulo.nombre,
    d.numero,
    d.articulo.precio,
    d.numero,
    d.articulo.porcentaje_iva,
    d.cantidad
FROM
    compras                c,
    TABLE ( c.detalle )       d;
--ejercicio 12
DECLARE
    lista tipo_lista_compra := tipo_lista_compra(NULL, NULL, NULL);
BEGIN
    SELECT
        *
    INTO
        lista.identificador,
        lista.cliente,
        lista.detalle
    FROM
        compras c
    WHERE
        c.cliente.iden = 1;

    dbms_output.put_line(lista.calcular_total);
END;

