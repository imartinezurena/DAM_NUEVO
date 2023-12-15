<?php
session_start();
session_destroy();
header("location:ev2e1_login.php");
?>