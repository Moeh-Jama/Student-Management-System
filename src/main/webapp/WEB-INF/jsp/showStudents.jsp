<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>

    </head>
    <body>
    <table border="1">
        <tr>
            <th>Student Name</th>
            <th>Student Stage</th>
            <th>Student DOB</th>
            <th>Student Gender</th>
            <th>Student Nationality</th>
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
    </body>
</html>