<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông Tin Người Dùng</title>
</head>
<body>
<h1>Thông tin người dùng</h1>
<jsp:useBean id="user" class="com.example.lab_5.User" scope="request"/>
<p>Tên: <jsp:getProperty name="user" property="name"/></p>
<p>Tuổi: <jsp:getProperty name="user" property="age"/></p>
<a href="user-form.html">Quay lại</a>
</body>
</html>
