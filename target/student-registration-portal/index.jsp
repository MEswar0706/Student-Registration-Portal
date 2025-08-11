<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Available Courses</title></head>
<body>
<h1>Courses</h1>
<table border="1">
<tr><th>Code</th><th>Name</th><th>Schedule</th></tr>
<c:forEach var="c" items="${courses}">
<tr>
<td>${c.code}</td>
<td>${c.name}</td>
<td>${c.schedule}</td>
</tr>
</c:forEach>
</table>
<a href="register.jsp">Register</a>
</body>
</html>
