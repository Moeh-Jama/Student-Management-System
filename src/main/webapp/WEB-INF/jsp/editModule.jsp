<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Module Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>

<body>



<div id="top_container">
    <h1>
        University of Springfield
    </h1>
    <h2>
        Modules
    </h2>

</div>

<div id="item_container">
    <div id="item_title">
        <h2>  Edit Modules </h2>
    </div>


    <form th:action="@{edit/{module_id}}" method="post">
        Module ID <input type="text" name="module_id" value="${module.getModuleId()}" readonly><br>
        Title <input type="text" name="module_name" value="${module.getModuleName()}"/><br>
        Description <input type="textarea" name="module_description" value="${module.moduleDescription}"/><br>
        Start Sate <input type="date" name="start_date" value="${module.getStartDate()}"/><br>
        End Date<input type="text" name="end_date" value="${module.getEndDate()}"/><br>
        Number of Enrolled Students<input type="number" name="num_of_students" value="${module.getNum_of_students()}"/><br>
        Student Capacity<input type="number" name="capacity" value="${module.getCapacity()}"/><br>
        Module Coordinator<input type="text" name="staff_coordinator_ID" value="${module.getStaff_coordinator_ID()}"/><br>

        <input type="submit" value="update module details"/>
    </form>


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
    <ul>
        <li><a href="/module">Modules</a></li>
        <li><a href="/available_modules/">Enroll</a></li>
        <li><a href="/showStudents">Students</a></li>
    </ul>

    <div id="logout">
        <a href="/logout">LOG OUT</a>
    </div>
</div>


</body>


</html>