<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Available Courses</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            background-color: #f8f9fa;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 70%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 8px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
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
            margin-top: 20px;
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
        .links a.secondary {
            background-color: #17a2b8;
        }
        .links a:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
<h1>Courses</h1>
<table>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Schedule</th>
    </tr>
    <c:forEach var="c" items="${courses}">
        <tr>
            <td>${c.code}</td>
            <td>${c.name}</td>
            <td>${c.schedule}</td>
        </tr>
    </c:forEach>
</table>

<!-- ✅ Navigation links -->
<div class="links">
    <a href="register" class="secondary">Register for a Course</a>
    <a href="search-registrations.jsp">Login</a>
</div>

</body>
</html>
