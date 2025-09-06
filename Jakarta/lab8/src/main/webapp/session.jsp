<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông Tin Phiên</title>
</head>
<body>
<h1>Thông tin phiên</h1>
<p>Sô
    ́ phiên hoạt động: ${applicationScope.activeSessions}</p>
<p>ID phiên hiện tại: <%= session.getId() %></p>
<a href="index.html">Quay lại</a>
</body>
</html> 