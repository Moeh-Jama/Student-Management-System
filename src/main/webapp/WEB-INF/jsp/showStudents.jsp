<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>


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
            Students
        </h2>



    </div>

    <div id="item_container">
    <div id="item_title">
        <h2>  Student Table  </h2>
    </div>

    <div id="ss_table">
        <table>
            <tr>
                <th>Full Name</th>
                <th>Current Stage</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Nationality</th>
            </tr>
            <c:forEach  var="student" items="${students}">
                <tr>
                    <td><c:out value="${student.getFullName()}" /></td>
                    <td><c:out value="${student.getStage()}"/></td>
                    <td><c:out value="${student.getDateOfBirth()}"/></td>
                    <td><c:out value="${student.getGender()}"/></td>
                    <td><c:out value="${student.getNationality()}"/></td>
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
    </div>



    </body>
</html>