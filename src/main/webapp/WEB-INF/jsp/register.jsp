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
    <div id="top_login_box">
        <ul>
            <li><a href="/login">Log in</a></li>
            <li><a href="/register">Register</a></li>
        </ul>

    </div>

    <h1>
        Welcome to this school.
    </h1>
    <h2>
        Register
    </h2>

</div>

<div id="item_container">
    <div id="item_title">
        <h2>Register</h2>
    </div>


    <form id="reg_css" action='register' method="post">
        <div id="reg_student">
            <h3>Register Student</h3><br>
            Email:<br> <input type="email" placeholder="email@domain.com" name="email" value="<c:out value='${student.email}' />"/><br><br>
            Student Number :<br> <input type="number" placeholder="Student Number" name="student_id" value="<c:out value='${student.student_id}' />"/> <br><br>
            Password:<br> <input type="password" name="password" placeholder="password"><br><br>
            Stage:<br> <input type="number" placeholder="Stage" name="stage" min="1" max="4" value="<c:out value='${student.stage}' />"/><br><br>
            Fees:<br> <input type="number" step="0.01" placeholder="Fees Left" name="fees" value="<c:out value='${student.fees}' />"/><br><br>
        </div>

        <div id="reg_details">
            <h3>Personal Details</h3><br>
            First Name:<br> <input type="text" placeholder="firstname" name="firstname" value="<c:out value='${student.firstname}' />"/><br><br>
            Surname:<br> <input type="text" placeholder="surname"   name="surname"   value="<c:out value='${student.surname}'   />"/><br><br>
            Date of Birth:<br> <input name="DOB" type="date" value="<c:out value='${student.DOB}'   />"/><br><br>
            Nationality:<br> <input type="text" placeholder="Nationality" name="nationality" value="<c:out value='${student.nationality}' />"/><br><br>
            Gender:<br> <input type="gender" placeholder="Gender" name="gender" value="<c:out value='${student.gender}' />"/><br><br>


        </div>

        <div id="reg_contact">
            <h3>Contact Details</h3><br>
            Address:<br> <input type="address" size="50" placeholder="Address" name="address" value="<c:out value='${student.address}' />"/><br><br>
            Phone Number:<br> <input type="text" placeholder="[prefix] number" name="phoneNumber" value="<c:out value='${student.phoneNumber}' />"/><br><br>
            <br>
            <input type="submit">
        </div>



    </form>

</div>

<div id="right_container">
    <ul>
        <li><a href="/module">Modules</a></li>
        <li><a href="/enroll">Enroll</a></li>
        <li><a href="/showStudents">Students</a></li>
    </ul>
</div>


</body>


</html>