<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
    integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
    crossorigin="anonymous"></script>
</head>

<body>
  <form action="ev2e1_login.php" method="post">
    Nombre <input etype="text" name="nombre" id="nombre_id">
    Password <input etype="pass" name="password" id="pass_id">
    <input type="submit" value="Enviar">
  </form>
</body>

</html>
<?php


session_start();
if (count($_POST) == 0) {
  $_SESSION["intentos"] = 5;
  //$_SESSION["clave"]=rand(1,100);

}


$pw = "Goku";
// isset() sirve para preguntar si existe
if (isset($_POST["password"])) {
  // Verificamos si la contrasseña es correcta
  if ($pw == $_POST["password"]) {
    // Lanzamos otra página
    $_SESSION ["login"]="ok";
    header("Location: ejer.php");
    // Matamos la principal
    die();
  }
}


//session_destroy();
?>