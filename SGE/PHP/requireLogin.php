<?php
session_start();
if ($_SESSION["login"] != "ok") {

    header("Location: ev2e1_login.php");

}
?>