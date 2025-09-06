<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Người Dùng</title>
</head>
<body>
<h1>Danh sách người dùng</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuô
            ̉i</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="index.html">Quay lại</a>
</body>
</html> 