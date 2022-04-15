<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/4/2022
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td><label>Enter Id:</label></td>
            <td><input type="text" name="id"></td>
        </tr>
    </table>
    <button type="submit">Serch</button>
    <table class="table table-striped">
        <tr class="row">
            <th class="col-1">ID</th>
            <th class="col-2">Name Product</th>
            <th class="col-2">Price</th>
            <th class="col-3">Describe</th>
            <th class="col-2">Produce</th>
        </tr>
        <c:forEach var="product" items="${productfind}" varStatus="tinbq">
            <tr class="row">
                <td class="col-1">${product.id}</td>
                <td class="col-2">${product.name}</td>
                <td class="col-2">${product.price}</td>
                <td class="col-3">${product.describe}</td>
                <td class="col-2">${product.produce}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>

</html>
