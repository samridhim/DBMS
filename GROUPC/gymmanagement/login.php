<?php
session_start();

$db = mysqli_connect('localhost','root','samridhi','gymmanagement')
 	or die('Error connecting to MySQL server.');
$user=$_POST['user'];
$pwd=$_POST['pwd'];
 $query="select uid, pwd from login where uid = '$user' and pwd = '$pwd';";
 	mysqli_query($db, $query) or die('Error querying database.');

  $result  = $db->query($query);
         if($result->num_rows>0){
      $_SESSION['user']= $user;
      $_SESSION['pwd']= $pwd;
      header("Location:userinfo.php");
      }
?>
