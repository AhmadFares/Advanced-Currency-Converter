<?php

include("database_connection.php");


$value = $_GET["value"];

$query = $mysqli->prepare("INSERT INTO transactions (value) VALUES (?)");
$query->bind_param("s", $value);
$query->execute();

    
?>