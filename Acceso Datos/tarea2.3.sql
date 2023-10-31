create or replace type cubo as object(
largo INTEGER,
ancho INTEGER,
alto INTEGER,
member function superficie  (largo number, ancho number, alto number)return number,
member function volumen(largo number,ancho number,alto number)return number,
member procedure mostrar
);
create or replace type body cubo as
member function superficie (largo in number, ancho in number, alto in number) is
resultadoSuper number;
begin
self.largo:=largo;
self.ancho:=ancho;
self.alto:=alto;
resultado:=(largo*ancho+largo*alto+ancho*alto)*2;
return resultadoSuper;
end;
member function volumen (largo in number, ancho in number, alto in number) is
resultadoV number;
begin
self.largo:=largo;
self.ancho:=ancho;
self.alto:=alto;
resultadoVol:=largo*ancho*alto;
return resultadoVol;
end;
member procedure mostrar () is
begin
DBMS_OUTPUT.PUT_LINE('largo:'||largo||' ancho:'||ancho||' alto:'||alto);
DBMS_OUTPUT.PUT_LINE('volumen'||resultadoVol||' Superficie:'||resultadoSuper);
end;
end;