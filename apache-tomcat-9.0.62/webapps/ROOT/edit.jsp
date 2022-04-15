<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/4/2022
  Time: 9:16 AM
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
    <label>Name Product</label>
    <input type="text" name="name"><br>
    <p style="color:red;">${error.get("name")}</p>
    <label>Price Product</label>
    <input type="number" name="price"><br>
    <label>Describe:</label>
    <input type="text" name="describe"><br>
    <label>Produce:</label>
    <input type="text" name="produce"><br>
    <button type="submit">Edit</button>
</form>
</body>
</html>
