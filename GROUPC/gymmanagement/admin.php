<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>Free CSS template by ChocoTemplates.com</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body>
<!-- Header -->
<div id="header">
	<div class="shell">
		<!-- Logo + Top Nav -->
		<div id="top">
			<h1><a href="#">The Gym</a></h1>
			<div id="top-navigation">
				Welcome <a href="#"><strong>Administrator</strong></a>
				<span>|</span>
				<a href="#">Help</a>
				<span>|</span>
				<a href="#">Profile Settings</a>
				<span>|</span>
				<a href="start.html">Log out</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
		<div id="navigation">
			<ul>
			    <li><a href="#"><span>Dashboard</span></a></li>
			    <li><a href="addnewclass.html"><span>Add new class</span></a></li>
                            <li><a href="addnewinstructor.html"><span>Add new instructor</span></a></li>
			</ul>
		</div>
		<!-- End Main Nav -->
	</div>
</div>
<!-- End Header -->

<!-- Container -->
<div id="container">
	<div class="shell">
		
		<!-- Small Nav -->
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			All customers in the gym
		</div>
		<!-- End Small Nav -->
<!-- Footer -->
<div id="footer">
	<div class="shell">
		<span class="left">&copy; 2017 - THE GYM</span>
		<span class="right">
	
		</span>
	</div>
</div>
<!-- End Footer -->
	
</body>
</html>

<?php
     $db = mysqli_connect('localhost','root','samridhi','gymmanagement')
 	or die('Error connecting to MySQL server.');
 echo "</br>";
 echo "</br>";
echo "<table border='1'>
       <caption> Customer Details </caption>
	<tr>

	<th>First Name</th>

	<th>Last Name</th>

	<th>Age</th>

	<th>Gender</th>
	<th>Email</th>
        <th> Class ID </th>
	

	</tr>";
$query="select cfname, clname, age, gender, email, classid from customer";
 	mysqli_query($db, $query) or die('Error querying database.');
        $result  = $db->query($query);
         if($result->num_rows>0){
          while($row = $result ->fetch_assoc()) {

	 echo "<tr>";
	 echo "<td>" .$row['cfname']."</td>".
	  "<td>" .$row['clname']."</td>".
	  "<td>" .$row['age']."</td>".
	  "<td>" .$row['gender']."</td>".
	  "<td>" .$row['email']."</td>".
	   "<td>" .$row['classid']."</td>";
           
	}    
}
	echo "</table>";

echo "</br>";
echo "</br>";
echo "</br>";
echo "<table border='1'>
       <caption> Instructor Details </caption>
	<tr>

	<th>Instructor Name</th>

	<th>Specialization</th>

	<th>Salary</th>

	<th>Email</th>
	

	</tr>";

  echo "</br>";
echo "</br>";
echo "</br>";
echo "</br>";

$query="select instructorname, specialization,salary,email from instructor";
 	mysqli_query($db, $query) or die('Error querying database.');
        $result  = $db->query($query);
         if($result->num_rows>0){
          while($row = $result ->fetch_assoc()) {

	 echo "<tr>";
	 echo "<td>" .$row['instructorname']."</td>".
	  "<td>" .$row['specialization']."</td>".
	  "<td>" .$row['salary']."</td>".
	  "<td>" .$row['email']."</td>";
	}    
}
	echo "</table>";


	mysqli_close($db);
?>
