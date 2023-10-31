--ejercicio 1 y 2
CREATE OR REPLACE TYPE type_triangulo AS OBJECT (
    base   number,
    altura   number,
    MEMBER FUNCTION area RETURN NUMBER
);
CREATE OR REPLACE TYPE BODY type_triangulo AS
    MEMBER FUNCTION area RETURN NUMBER IS
    BEGIN
        RETURN ( base * altura) / 2;
    END;
    end;
--ejercicio 3
Create table triangulos
(id number (10),
triangulo type_triangulo
);

--ejercicio 4
insert into triangulos values(1,type_triangulo(5,5));
insert into triangulos values(1,type_triangulo(10,10));
--ejercicio 5
select * from triangulos;
--ejercicio 6
DECLARE
    triana type_triangulo := type_triangulo(NULL,NULL);
    id number;
    cursor c1 is select * from triangulos;
BEGIN
open c1;
    fetch c1 into id, triana;
    while c1%found loop
    dbms_output.put_line('el triangulo con id: '||id);
    dbms_output.put_line('con base: ' ||triana.base);
    dbms_output.put_line('y altura: ' || triana.altura);
    dbms_output.put_line('tiene un area de : '||triana.area());
    fetch c1 into id, triana;
    end loop;
    close c1;
END;
