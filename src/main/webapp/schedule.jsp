<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your Schedule</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            background-color: #f8f9fa;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 25px;
        }
        table {
            border-collapse: collapse;
            width: 70%;
            margin: 0 auto 25px auto;
            background-color: #fff;
            box-shadow: 0 0 8px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e6f7ff;
        }
        .links {
            text-align: center;
        }
        .links a {
            display: inline-block;
            padding: 10px 18px;
            margin: 5px;
            background-color: #28a745;
            color: white;
            font-weight: bold;
            text-decoration: none;
            border-radius: 5px;
        }
        .links a:hover {
            background-color: #218838;
        }
        .links a.secondary {
            background-color: #17a2b8;
        }
        .links a.secondary:hover {
            background-color: #117a8b;
        }
    </style>
</head>
<body>

<h1>Your Schedule</h1>

<table>
    <tr>
        <th>Course Code</th>
        <th>Course Name</th>
        <th>Schedule</th>
    </tr>
    <c:forEach var="reg" items="${registrations}">
        <tr>
            <td>${reg.course.code}</td>
            <td>${reg.course.name}</td>
            <td>${reg.course.schedule}</td>
        </tr>
    </c:forEach>
</table>

<div class="links">
    <a class="secondary" href="results?studentId=${studentId}">View Results</a>
    <a href="courses">Back to Courses</a>
</div>

</body>
</html>
