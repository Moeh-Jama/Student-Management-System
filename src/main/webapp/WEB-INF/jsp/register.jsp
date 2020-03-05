<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Register Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>

<body>



<div id="top_container">
    <h1>
        Welcome to this school.
    </h1>
    <h2>
        Register
    </h2>

</div>

<div id="item_container">
    <form action='register' method="post">
        <input type="number" placeholder="Student Number" name="student_id" value="<c:out value='${student.student_id}' />"/> <br>
        <input type="text" placeholder="firstname" name="firstname" value="<c:out value='${student.firstname}' />"/><br>
        <input type="text" placeholder="surname"   name="surname"   value="<c:out value='${student.surname}'   />"/><br>
        Password<input type="password" name="password" placeholder="password">"/><br>
        DOB<input name="DOB" type="date" value="<c:out value='${student.DOB}'   />"/><br>
        <input type="address" placeholder="Address" name="address" value="<c:out value='${student.address}' />"/><br>
        <input type="email" placeholder="email@domain.com" name="email" value="<c:out value='${student.email}' />"/><br>
        Phone Number<input type="text" placeholder="[prefix] number" name="phoneNumber" value="<c:out value='${student.phoneNumber}' />"/><br>
        <input type="number" placeholder="Stage" name="stage" value="<c:out value='${student.stage}' />"/><br>
        <input type="text" placeholder="Nationality" name="nationality" value="<c:out value='${student.nationality}' />"/><br>
        <input type="number" step="0.01" placeholder="Fees Left" name="fees" value="<c:out value='${student.fees}' />"/><br>
        <input type="gender" placeholder="Gender" name="gender" value="<c:out value='${student.gender}' />"/><br>

        <input type="submit">
    </form>

</div>

<div id="right_container">

</div>


</body>


</html>