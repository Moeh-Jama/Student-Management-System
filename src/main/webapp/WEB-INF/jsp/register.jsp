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
        University of Springfield
    </h1>
    <h2>
        Register
    </h2>

</div>

<div id="item_container">
    <div id="item_title">
        <h2>Register</h2>
    </div>


    <form action='register' method="post">
        <div id="reg_student">
            <h3>Register Student</h3><br>
            Email:<br> <input required type="email" placeholder="email@domain.com" name="email" value="<c:out value='${student.email}' />"/><br><br>
            Student Number :<br> <input required type="number" placeholder="Student Number" name="student_id" value="<c:out value='${student.student_id}' />"/> <br><br>
            Password:<br> <input required onchange="confirm_pass()" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="pass_input" type="password" name="password" placeholder="Password"><br>
            Re-Type Password:<br> <input required onchange="confirm_pass()" id="retype_pass" type="password" name="retype" placeholder="Re-Type Password"> <span id="match">✖</span><br>

            <div id="password_validate">
                <b>Password Requirements</b><br><br>
                Lower Case Letters: <b><span id="lower">False</span></b> <br><br>
                Capital Letters: <b><span id="upper">False</span></b><br><br>
                Number: <b><span id="number">False</span></b> <br><br>
                Password length > 10: <b><span id="length">False</span></b> <br>
            </div>

            <br>
            Stage:<br> <input required type="number" placeholder="Stage" name="stage" min="1" max="4" value="<c:out value='${student.stage}' />"/><br><br>
            Fees:<br> <input required type="number" step="0.01" placeholder="Fees Left" name="fees" value="<c:out value='${student.fees}' />"/><br><br>
        </div>

        <div id="reg_details">
            <h3>Personal Details</h3><br>
            First Name:<br> <input required type="text" placeholder="firstname" name="firstname" value="<c:out value='${student.firstname}' />"/><br><br>
            Surname:<br> <input required type="text" placeholder="surname"   name="surname"   value="<c:out value='${student.surname}'   />"/><br><br>
            Date of Birth:<br> <input required name="DOB" type="date" value="<c:out value='${student.DOB}'   />"/><br><br>
            Nationality:<br> <input required type="text" placeholder="Nationality" name="nationality" value="<c:out value='${student.nationality}' />"/><br><br>
            Gender:<br> <input required type="gender" placeholder="Gender" name="gender" value="<c:out value='${student.gender}' />"/><br><br>

        </div>

        <div id="reg_contact">
            <h3>Contact Details</h3><br>
            Address:<br> <input required type="address" size="50" placeholder="Address" name="address" value="<c:out value='${student.address}' />"/><br><br>
            Phone Number:<br> <input required type="text" placeholder="[prefix] number" name="phoneNumber" value="<c:out value='${student.phoneNumber}' />"/><br><br>
            <br>
            <input type="submit" value="REGISTER" id="submit" disabled>
        </div>



    </form>

</div>

<div id="right_container">
    <ul>
        <li><a href="/module">Modules</a></li>
        <li><a href="/available_modules/">Enroll</a></li>
        <li><a href="/showStudents">Students</a></li>
    </ul>
</div>


<script src="js/password_validate.js"></script>

</body>


</html>