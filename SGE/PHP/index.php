<!DOCTYPE html>
<html lang="en">
<?php
echo "hola mundo";
print "hola mundo";
//la diferencia es que print devuelve un valor??
$contador = 1;
$nombre = "nacho";
//o el valor que sea, no se especfica

echo $contador;
//array


$dias2=array("lunes"=>"laborable", "martes"=>"laborable", "miercoles"=>"laborable", "jueves"=>"laborable");
var_dump($dias2);
echo $dias2["lunes"];

?>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action ="index.php" method="get" >
        nombre<input type="text" name="nombre" id="">
        <input type="submit"  value="enviar">
    
</form>
<form action ="index.php" method="post" >
        nombre<input type="text" name="numero" id="">
        <input type="submit"  value="enviar">
    
</form>

</body>
</html>
<?php
var_dump($_POST)
session_start();
if(count($_POST)==0){
    $_SESSION["intentos"]=5;
    $_SESSION["clave"]=srand(1,100);
    $_SESSION["reiniciar"]=0;
    echo <input type="submit" name="comprobar">
}
var_dump($_SESSION);
$_SESSION["clave"]=1234;
?>

