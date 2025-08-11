<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Register Student</title></head>
<body>
<h1>Student Registration</h1>
<form action="register" method="post">
    Name: <input type="text" name="name" required /><br/><br/>
    Email: <input type="email" name="email" required /><br/><br/>
    Course:
    <select name="courseId" required>
        <c:forEach var="course" items="${courses}">
            <option value="${course.id}">${course.name}</option>
        </c:forEach>
    </select><br/><br/>
    <button type="submit">Register</button>
</form>
</body>
</html>
