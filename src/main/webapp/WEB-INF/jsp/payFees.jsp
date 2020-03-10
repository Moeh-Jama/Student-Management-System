<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Pay Fees</title>

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
        Fees
    </h2>



</div>

<div id="item_container">
    <div id="item_title">
        <h2>  Pay Fees </h2>
    </div>

    <div id="fee_box">

        <form action="/studentDetails/${student.getStudentID()}/Fee" method="post">
            <h3>Payment</h3>
            Student Name:  <c:out value="${student.getFullName()}"/><br><br>
            Money owed: €<c:out value="${student.getFees()}"/> <br><br>
<%--            Enter: <br> <input type="number" step="0.01" placeholder="Payment Fee" name="fees"/><br><br>--%>
<%--            <br>--%>

            <input name="Pay" type="submit" value="  Pay  " >

        </form>
    </div>

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