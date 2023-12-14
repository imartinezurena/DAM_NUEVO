<!DOCTYPE html>
<html lang="en">

<?php
  include("header.php");
?>
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
  //var_dump($_POST["nombre"]);
  //var_dump($_POST["edad"]);
  

  echo "Hola mundo"."con un punto podemos concatenar"."<br>";
  echo "Las variables empiezan por $"."<br>";
  $edad=33;
  $altura=170.1;
  $nombre="Fausto";
  $colores=array("verde","azul","amarillo");

  echo "Soy ".$nombre." tengo ".$edad."años y mido ".$altura."<br>";
  print "Buenas tardes"."<br>";

  //Nos servirá para acceder y sacar los valores de las variables
  var_dump($colores);
  echo "<br>";

  if($edad<18){
    echo "Eres menor de edad"."<br>";
  }
  else if($edad==18){
    echo "Eres adulto recientemente"."<br>";
  }
  else{
    echo "Eres adulto"."<br>";
  }
    
  // Lo haremos con un ternario
  echo ($edad >18)? "Eres menor de edad":"eres adulto"."<br>";

  switch($edad){
    case(18):
      echo "acabas de cumplir la mayoróa de edad"."<br>";
      break;
    default;
      echo "No tines 18 juntos"."<br>";
  }


  //Para visualizar el número de elemenots que tiene un array
  echo count($colores)."<br>";

  for ($i=1;$i<count($colores);$i++){
    echo $colores[$i]."<br>";
  }
  echo "Ahora con un foreach"."<br>";
  foreach ($colores as $color) {
    echo $color."<br>";
  }

  $i=1;
  while ($i<4){
    echo("Estoy delntro del while ".$i)."<br>";
    $i=$i+1;
  }

  /*
  do{
    echo "Estanos dentro del wiles"

  }while ($j <= 4) {
    # code...
  }*/

?>