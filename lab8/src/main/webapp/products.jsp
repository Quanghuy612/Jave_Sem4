<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Sản Phâ ̉m</title>
</head>
<body>
<h1>Danh sách sản phâ ̉m</h1>
<p>Sô
    ́ phiên hoạt động: ${applicationScope.activeSessions}</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="product-form.html">Thêm sản phâ ̉m</a>
</body>
</html>