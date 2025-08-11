<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Your Schedule</title></head>
<body>
<h1>Your Schedule</h1>
<table border="1">
    <tr><th>Course Code</th><th>Course Name</th><th>Schedule</th></tr>
    <c:forEach var="reg" items="${registrations}">
        <tr>
            <td>${reg.course.code}</td>
            <td>${reg.course.name}</td>
            <td>${reg.course.schedule}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="results?studentId=${studentId}">View Results</a><br/>
<a href="courses">Back to Courses</a>
</body>
</html>
