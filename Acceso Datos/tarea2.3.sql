--ejercicio 1 a
CREATE OR REPLACE TYPE cubo AS OBJECT (
    largo   INTEGER,
    ancho   INTEGER,
    alto    INTEGER,
    MEMBER FUNCTION superficie RETURN NUMBER,
    MEMBER FUNCTION volumen RETURN NUMBER,
    member  procedure mostrar
);

CREATE OR REPLACE TYPE BODY cubo AS
    MEMBER FUNCTION superficie RETURN NUMBER IS
    BEGIN
        RETURN ( largo * ancho + largo * alto + ancho * alto ) * 2;
    END;

    MEMBER FUNCTION volumen RETURN NUMBER IS
    BEGIN
        RETURN largo * ancho * alto;
    END;

    MEMBER PROCEDURE mostrar IS
    BEGIN
        dbms_output.put_line('largo:'
                             || largo
                             || ' ancho:'
                             || ancho
                             || ' alto:'
                             || alto);

        dbms_output.put_line('volumen'
                             || self.volumen
                             || ' Superficie:'
                             || self.superficie);

    END;

END;
--ejercicio b
create table cubos of cubo;
--ejercicio c
insert into cubos values(10,10,10);
insert into cubos values(3,4,5);
--ejercicio d
select * from cubos;
--ejercicio e
DECLARE
    kubo cubo := cubo(NULL, NULL, NULL);
BEGIN SELECT
    *
INTO
    kubo.largo,
    kubo.ancho,
    kubo.alto
FROM
    cubos
WHERE
    largo = 10;
    dbms_output.put_line('superficie: ' || kubo.superficie());
    dbms_output.put_line('volumen: ' || kubo.volumen());
END;
--ejercicio f
DECLARE
    kubo cubo := cubo(NULL, NULL, NULL);
BEGIN
    SELECT
        *
    INTO
        kubo.largo,
        kubo.ancho,
        kubo.alto
    FROM
        cubos
    WHERE
        largo = 10;

    kubo.mostrar;
END;
