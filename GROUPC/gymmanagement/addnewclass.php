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
			    <li><a href="userinfo.php"><span>Dashboard</span></a></li>
			    <li><a href="membershipinfo.php"><span>Membership information</span></a></li>
		             <li><a href="addnewclass.php" class = "active"><span>Add new class</span></a></li>

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
			Your Membership details
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
<form action = "addmembership.php" method = "POST">
   <fieldset>
    <legend> Join new class </legend>
  <p>
<p>
<select name="formClass">
  <option value="">Select Class</option>
  <option value="Z">Zumba</option>
  <option value="A">Aerobics</option>
  <option value="W">Weight Lifting</option>
<option value="C">Cross</option>

</select> 
</p>
<p>
<input type="submit" name = "submit" value = "Add">
</p>
    </fieldset>
     </form>
</body>
</html>	
