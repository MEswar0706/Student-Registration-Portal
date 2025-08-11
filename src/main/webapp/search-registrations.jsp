<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find My Registered Courses</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background-color: #f8f9fa; 
            margin: 30px; 
        }
        .container { 
            width: 400px; 
            margin: auto; 
            padding: 20px; 
            background: white; 
            border-radius: 8px; 
            box-shadow: 0 0 8px rgba(0,0,0,0.1);
        }
        h1 { 
            text-align: center; 
        }
        label { 
            display: block; 
            margin-top: 10px; 
        }
        input { 
            width: 100%; 
            padding: 8px; 
            margin-top: 4px; 
            border: 1px solid #ccc; 
            border-radius: 4px;
        }
        button { 
            width: 100%; 
            margin-top: 15px; 
            padding: 10px; 
            background: #007BFF; 
            border: none; 
            color: white; 
            font-weight: bold; 
            border-radius: 4px; 
            cursor: pointer;
        }
        button:hover { 
            background: #0056b3; 
        }
        .error { 
            color: red; 
            text-align: center; 
            margin-top: 10px; 
        }
        /* Back to Home link */
        .links { 
            text-align: center; 
            margin-top: 15px; 
        }
        .links a { 
            display: inline-block; 
            padding: 8px 14px; 
            background: #6c757d; 
            background-color: #28a745;
            color: white; 
            text-decoration: none; 
            border-radius: 5px; 
            font-weight: bold; 
        }
       
        .links a:hover { 
            opacity: 0.9; 
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <form action="schedule" method="get">
        <label for="name">Name:</label>
        <input type="text" name="name" required>

        <label for="email">Email:</label>
        <input type="email" name="email" required>

        <button type="submit">Search</button>
    </form>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <!-- ✅ Back to Home link -->
    <div class="links">
        <a href="courses">Back to Home</a>
    </div>
</div>
</body>
</html>
