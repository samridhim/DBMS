<?php
session_start();
$user = $_SESSION['user'];
$classid = $_POST['formClass'];
$db = mysqli_connect('localhost','root','samridhi','gymmanagement')
 	or die('Error connecting to MySQL server.');
      $query="insert into membership(user, classid, start, end) values ('$user', '$classid', curdate(), DATE_ADD(curdate(), INTERVAL 90 DAY))";
 	if(mysqli_query($db, $query)){
 echo "Records added successfully.";  
 $query="update customer set classid = '$classid' where user = '$user'";  
if(mysqli_query($db, $query)){
 echo "Records updated successfully."; 
}
 }
else{

    echo "ERROR: Could not able to add more than one class at a time";

}
	mysqli_close($db);
?>

<html>
<a href = "userinfo.php"> Click here to go back </a>
