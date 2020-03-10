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
        University of Springfield
    </h1>
    <h2>
       Module Details
    </h2>

</div>

<div id="item_container">
    <div id="item_title">
        <h2>  Module Table </h2>
    </div>
    <div id="module_table">
        <table>
            <tr>
                <th>Module ID</th>
                <th>Module Title</th>
                <th>Module Description</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Number of Students Enrolled</th>
                <th>Maximum Student Capacity</th>

            </tr>

            <tr>
                <td><a href="/module/<c:out value="${module.getModuleId()}" />"><c:out value="${module.getModuleId()}" /></a></td>
                <td><c:out value="${module.getModuleName()}" /></td>
                <td><c:out value="${module.getModuleDescription()}" /></td>
                <td><c:out value="${module.getStartDate()}" /></td>
                <td><c:out value="${module.getEndDate()}" /></td>
                <td><c:out value="${module.getNum_of_students()}" /></td>
                <td><c:out value="${module.getCapacity()}" /></td>
            </tr>
        </table>
    </div>


</div>

<div id="right_container">
    <ul>
        <li><a href="/module">Modules</a></li>
        <li><a href="/edit/<c:out value="${module.getModuleId()}" />">Edit Module</a></li>
        <li><a href="/enroll">Enroll</a></li>
        <li><a href="/showStudents">Students</a></li>

    </ul>

    <div id="logout">
        <a href="/logout">LOG OUT</a>
    </div>
</div>


</body>


</html>