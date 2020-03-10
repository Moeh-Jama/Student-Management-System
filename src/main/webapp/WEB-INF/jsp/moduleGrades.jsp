<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Module Page</title>
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
        Module Details
    </h2>

</div>

<div id="item_container">
    <div id="item_title">
        <h2>  Grades for Module ${moduleID} </h2>
    </div>
    <div id="module_table">
        <table>
            <tr>
                <th>Student ID</th>
                <th>Grade</th>

            </tr>
            <c:forEach  var="moduleGrade" items="${moduleGrades}">
            <tr>
                <td><a href="/module/${moduleID}/grades/<c:out value="${moduleGrade.getEms_student_id()}" />"><c:out value="${moduleGrade.getEms_student_id()}" /></a></td>
                <td><c:out value="${moduleGrade.getGrade()}" /></td>

            </tr>
            </c:forEach>
        </table>
    </div>


</div>

<div id="right_container">
    <ul>
        <li><a href="/module">Modules</a></li>
        <li><a href="/enroll">Enroll</a></li>
        <li><a href="/showStudents">Students</a></li>
    </ul>

    <div id="logout">
        <a href="/logout">LOG OUT</a>
    </div>
</div>


</body>


</html>