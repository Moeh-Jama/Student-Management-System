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
    <h1>
        Welcome to this school.
    </h1>
    <h2>
       Module Details
    </h2>

</div>

<div id="item_container">
    <table>
        <tr>
            <th>Module ID</th>
            <th>Module_name</th>
            <th>module description</th>
            <th>start data</th>
            <th>end date</th>
            <th>number of students enrolled</th>
            <th>Maximum Student Capacity</th>
            <th></th>
        </tr>
        <tr>
            <td><c:out value="${module.getModuleId()}" /></td>
            <td><c:out value="${module.getModuleName()}" /></td>
            <td><c:out value="${module.getModuleDescription()}" /></td>
            <td><c:out value="${module.getStartDate()}" /></td>
            <td><c:out value="${module.getEndDate()}" /></td>
            <td><c:out value="${module.getNum_of_students()}" /></td>
            <td><c:out value="${module.getCapacity()}" /></td>
        </tr>
    </table>

</div>

<div id="right_container">

</div>


</body>


</html>