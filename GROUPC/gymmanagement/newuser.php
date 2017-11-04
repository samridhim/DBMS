<?php
$db = mysqli_connect('localhost','root','samridhi','gymmanagement')
 	or die('Error connecting to MySQL server.');
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$age=$_POST['age'];
$varGender = $_POST['formGender'];
$email=$_POST['email'];
$user=$_POST['user'];
$pwd=$_POST['pwd'];
$varClass =$_POST['formClass'];
$query="INSERT INTO customer(cfname, clname, age, gender, email,user) VALUES('$fname','$lname','$age','$varGender','$email', '$user')";
if(mysqli_query($db, $query)){

    echo "</br>";
   echo "<table border='1'>
	<tr>
	<th>First Name</th>

	<th>Last Name</th>

	<th>Age</th>

	<th>Gender</th>
	<th>Email</th>
	

	</tr>";

     echo "<td>" .$_POST['fname']."</td>".
	  "<td>" .$_POST['lname']."</td>".
	  "<td>" .$_POST['age']."</td>".
	  "<td>" .$_POST['formGender']."</td>".
	  "<td>" .$_POST['email']."</td>";

} else{

    echo "ERROR: Could not able to execute $query. " . mysqli_error($db);

}

$query="INSERT INTO login(uid, pwd) VALUES('$user','$pwd')";	
if(mysqli_query($db, $query)){

    echo "Records added successfully..";
} else{
    echo "ERROR: Could not able to execute $query. " . mysqli_error($db);

}
mysqli_close($db);
?>


