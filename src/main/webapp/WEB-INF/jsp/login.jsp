<html>

<head>
<title>Log in Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>

<body>



<div id="top_container">
	<div id="top_login_box">
		<ul>
			<li><a href="/login">Log in</a></li>
			<li><a href="/register">Register</a></li>
		</ul>

	</div>
	<h1>
		University of Springfield
	</h1>
	<h2>
		Welcome
	</h2>

</div>

<div id="item_container">
	<div id="item_title">
		<h2>  Log In  </h2>
	</div>

	<div id="login_box">
		<span style="color: red; ">${errorMessage}</span>
		<form method="post">
			<input required type="text" name="name" placeholder="Student ID" /> <br>
			<br>
			<input required type="password" name="password" placeholder="Password"/> <br>
			<br>
			<input type="submit" value=" LOG IN " />
		</form>
	</div>


</div>

<div id="right_container">
	<ul>
		<li><a href="/module">Modules</a></li>
		<li><a href="/available_modules/">Enroll</a></li>
		<li><a href="/showStudents">Students</a></li>
	</ul>
</div>


</body>



</html>