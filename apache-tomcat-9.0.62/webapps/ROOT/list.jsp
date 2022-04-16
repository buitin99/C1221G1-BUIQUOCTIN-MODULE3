<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/4/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button class="btn btn-primary" style="color: white"><a href="/product?action=create">Add new</a></button>
<form action="/product">
    <input type="hidden" name="action" value="search">
    <label>Name Product</label>
    <input type="text" name="name">
    <button type="submit">Search</button>
</form>
<table class="table table-striped">
    <tr class="row">
        <th class="col-1">ID</th>
        <th class="col-2">Name Product</th>
        <th class="col-2">Price</th>
        <th class="col-3">Describe</th>
        <th class="col-2">Produce</th>
        <th class="col-1">Edit</th>
        <th class="col-1">Delete</th>
    </tr>
    <c:forEach var="product" items="${products}" varStatus="tinbq">
        <tr class="row">
            <td class="col-1">${product.id}</td>
            <td class="col-2">${product.name}</td>
            <td class="col-2">${product.price}</td>
            <td class="col-3">${product.describe}</td>
            <td class="col-2">${product.produce}</td>
            <td class="col-1"><a href="/edit.jsp">edit</a></td>
            <td class="col-2"><a href="#">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
