<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Your Results</title></head>
<body>
<h1>Your Results</h1>
<table border="1">
    <tr><th>Course Code</th><th>Course Name</th><th>Grade</th></tr>
    <c:forEach var="reg" items="${registrations}">
        <tr>
            <td>${reg.course.code}</td>
            <td>${reg.course.name}</td>
            <td><c:out value="${reg.grade != null ? reg.grade : 'N/A'}"/></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="schedule?studentId=${studentId}">Back to Schedule</a><br/>
<a href="courses">Back to Courses</a>
</body>
</html>
