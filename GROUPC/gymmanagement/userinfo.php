<?php
session_start();

echo session_id();
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>THE GYM</title>
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
				<a href="logout.php">Log out</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
		<div id="navigation">
			<ul>
			    <li><a href="userinfo.php" class="active"><span>Dashboard</span></a></li>
			    <li><a href="membershipinfo.php"><span>Membership information</span></a></li>
   			     <li><a href="addnewclass.php"><span>Add new class</span></a></li>
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
			Your Information
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
   session_start();
       $db = mysqli_connect('localhost','root','samridhi','gymmanagement')
 	or die('Error connecting to MySQL server.');
 	$user=$_SESSION['user'];
  echo "</br>";
         echo "</br>";
echo "</br>";
       echo "Your Details";
	echo "<table border='1'>
	<tr>
	<th>First Name</th>

	<th>Last Name</th>

	<th>Age</th>

	<th>Gender</th>
	<th>Email</th>
	

	</tr>";
      $query="select cfname, clname, age, gender, email, classid from customer where user = '$user'";
 	mysqli_query($db, $query) or die('Error querying database.');
        $result  = $db->query($query);
         if($result->num_rows>0){
          while($row = $result ->fetch_assoc()) {

	 echo "<tr>";
	 echo "<td>" .$row['cfname']."</td>".
	  "<td>" .$row['clname']."</td>".
	  "<td>" .$row['age']."</td>".
	  "<td>" .$row['gender']."</td>".
	  "<td>" .$row['email']."</td>";
	}  
}
	echo "</table>";
        echo "</br>";
         echo "</br>";
echo "</br>";

 echo "Instructor Details";
	echo "<table border='1'>
	<tr>
	<th>Instructor Name</th>

	<th>Specialization</th>

	<th>Email</th>

	</tr>";
      $query="select instructorname, specialization, email  from instructor where LEFT(specialization,1) = (select classid from membership where user = '$user');";
 	mysqli_query($db, $query) or die('Error querying database.');
        $result  = $db->query($query);
         if($result->num_rows>0){
          while($row = $result ->fetch_assoc()) {

	 echo "<tr>";
	 echo "<td>" .$row['instructorname']."</td>".
	  "<td>" .$row['specialization']."</td>".
	  "<td>" .$row['email']."</td>";
	}  
}
	echo "</table>";

  echo "</br>";
         echo "</br>";
echo "</br>";
echo "Class Details";
	echo "<table border='1'>
	<tr>
	<th>Class ID</th>

	<th>Class Name</th>

	<th>Class Time</th>

	</tr>";
      $query="select classid,classname,classtime  from class where classid = (select classid from membership where user = '$user');";
 	mysqli_query($db, $query) or die('Error querying database.');
        $result  = $db->query($query);
         if($result->num_rows>0){
          while($row = $result ->fetch_assoc()) {

	 echo "<tr>";
	 echo "<td>" .$row['classid']."</td>".
	  "<td>" .$row['classname']."</td>".
	  "<td>" .$row['classtime']."</td>";
	}  
}
	echo "</table>";
	mysqli_close($db);
?>
