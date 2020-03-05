<html>

<head>
<title>Log in Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>

<body>



<div id="top_container">
	<h1>
		Welcome to this school.
	</h1>
	<h2>
		Enjoy
	</h2>

</div>

<div id="item_container">

	<font color="red">${errorMessage}</font>
	<form method="post">
		Name : <input type="text" name="name" />
		Password : <input type="password" name="password" />
		<input type="submit" />
	</form>

</div>

<div id="right_container"></div>


</body>


</html>