<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Cơ Bản</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 50px auto;
            max-width: 500px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h1 {
            color: #333;
        }

        p {
            font-size: 16px;
            margin-bottom: 20px;
        }

        form {
            background: #fff;
            padding: 15px;
            border-radius: 8px;
            border: 1px solid #ddd;
        }

        label {
            display: inline-block;
            width: 80px;
        }

        input[type="text"] {
            padding: 5px;
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 6px 12px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%! int visitCount = 0; %>

<h1>Xin chào, <%= request.getParameter("name") != null ?
        request.getParameter("name") : "Khách" %></h1>

<p>Lượt truy cập: <% out.println(++visitCount); %></p>

<form action="index.jsp" method="get">
    <label>Nhập tên:</label>
    <input type="text" name="name">
    <br><br>
    <input type="submit" value="Gửi">
</form>
</body>
</html>
