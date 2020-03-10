<html>

<head>
    <title>Enrolled Page</title>
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
       Enroll
    </h2>

</div>

<div id="item_container">
    <div id="item_title">
        <h2>  Module Table </h2>
    </div>
    <div id="module_table">
        <form action="/enroll/${module.getModuleId()}" method="post">
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
                <td><c:out value="${module.getModuleId()}" /></td>
                <td><c:out value="${module.getModuleName()}" /></td>
                <td><c:out value="${module.getModuleDescription()}" /></td>
                <td><c:out value="${module.getStartDate()}" /></td>
                <td><c:out value="${module.getEndDate()}" /></td>
                <td><c:out value="${module.getNum_of_students()}" /></td>
                <td><c:out value="${module.getCapacity()}" /></td>
            </tr>
        </table>
            <input type="submit" name="submit">
        </form>
    </div>



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