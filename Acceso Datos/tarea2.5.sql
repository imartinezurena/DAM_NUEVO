--ejercicio 1, 2
CREATE OR REPLACE TYPE cubo AS OBJECT (
    largo   INTEGER,
    ancho   INTEGER,
    alto    INTEGER,
    MEMBER FUNCTION superficie RETURN NUMBER,
    MEMBER FUNCTION volumen RETURN NUMBER,
    member  procedure mostrar,
    static PROCEDURE nuevocubo (
           v_largo  INTEGER,
           v_ancho  INTEGER,
           v_alto   INTEGER
       )
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

    STATIC PROCEDURE nuevocubo (
        v_largo  INTEGER,
        v_ancho  INTEGER,
        v_alto   INTEGER
    ) IS
    BEGIN
        INSERT INTO cubos VALUES (
            v_largo,
            v_ancho,
            v_alto
        );

    END;

END;
--ejercicio 3
declare
begin
cubo.nuevoCubo(1,8,1);
end;

