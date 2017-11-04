<?php

$db = mysqli_connect('localhost','root','samridhi','gymmanagement')
 	or die('Error connecting to MySQL server.');
$name=$_POST['name'];
$email=$_POST['email'];
$uid=$_POST['uid'];
$salary = (int)$_POST['salary'];
$pwd=$_POST['pwd'];
$special = $_POST['special'];
$query="INSERT INTO instructor(instructorid, instructorname,specialization, salary,email,pwd) VALUES('$uid','$name','$special', '$salary','$email','$pwd')";
if(mysqli_query($db, $query))
{

    echo "Records added successfully.";

}
else
{

    echo "ERROR: Could not able to execute $query. " . mysqli_error($db);

}
?>
