<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <title>Document</title>
</head>
<body>
  <form action="index.php" method="post">
    Nombre <input type="text" name="nombre" id="nombre_id">
    Edad <input type="text" name="edad" id="edad_id">
    <input type="submit" value="Enviar">
  </form>
</body>
</html>


<?php
  //Vamos a mostrar los datos que tenemos en el input
  if(count($_POST)!=0){
    echo("Mi nombre es ".$_POST["nombre"]." y tengo ".$_POST["edad"]);
  }
  
  // Para ver los datos que tenemos en el array POST
  var_dump($_POST["nombre"]);
  var_dump($_POST["edad"]);

?>