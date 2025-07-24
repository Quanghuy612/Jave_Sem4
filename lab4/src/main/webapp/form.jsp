<%--
  Created by IntelliJ IDEA.
  User: Top G
  Date: 22/07/2025
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Sản Phâ ̉m</title>
</head>
<body>
<h1>Thêm sản phâ ̉m</h1>
<form action="add-product" method="post">
    <input type="hidden" name="sessionId" value="${param.sessionId}">
    <label>Tên sa ̉n phâ ̉m: </label>
    <input type="text" name="productName">
    <input type="submit" value="Thêm">
</form>
</body>
</html>
