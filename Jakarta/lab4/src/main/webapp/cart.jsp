<%--
  Created by IntelliJ IDEA.
  User: Top G
  Date: 22/07/2025
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gio
        ̉ Hàng</title>
</head>
<body>
<h1>Gio
    ̉ hàng của bạn</h1>
<ul>
    <c:forEach items="${sessionScope.cart}" var="product">
        <li>${product}</li>
    </c:forEach>
</ul>
<a href="cart.html">Thêm sản phâ ̉m</a>
<a href="logout">Đăng xuâ ́t</a>
</body>
</html>
