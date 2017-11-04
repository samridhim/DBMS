<?php
 $db = mysqli_connect('localhost','root','samridhi','gymmanagement')
 	or die('Error connecting to MySQL server.');
$classname = $_POST['classname'];
$classid = $_POST['classid'];
$classtime = $_POST['classtime'];
$query="INSERT INTO class(classid, classname, classtime) VALUES('$classid','$classname','$classtime')";
if(mysqli_query($db, $query)){
  echo "Added new class";
}
else
{
echo "Class cannot be added";
}
mysqli_close($db);
?>
