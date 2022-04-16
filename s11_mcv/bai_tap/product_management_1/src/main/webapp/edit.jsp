<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/14/2022
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/">Back to Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name Product: </td>
                <td><input type="text" name="name" id="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price Product: </td>
                <td><input type="number" name="price" id="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="describe" id="describe" value="${product.describe}"></td>
            </tr>
            <tr>
                <td>Manufacturer: </td>
                <td><input type="text" name="produce" id="produce" value="${product.produce}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 15/4/2022--%>
<%--  Time: 9:16 AM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Edit product</h1>--%>
<%--<p>--%>
<%--    <c:if test='${requestScope["message"] != null}'>--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<%--<p>--%>
<%--    <a href="/">Back to customer list</a>--%>
<%--</p>--%>
<%--<form method="post">--%>
<%--    <label>ID Product</label>--%>
<%--    <input type="number" name="id" id="id"><br>--%>
<%--    <label>Name Product</label>--%>
<%--    <input type="text" name="name" id="name"><br>--%>
<%--    <p style="color:red;">${error.get("name")}</p>--%>
<%--    <label>Price Product</label>--%>
<%--    <input type="number" name="price" id="price"><br>--%>
<%--    <label>Describe:</label>--%>
<%--    <input type="text" name="describe" id="describe"><br>--%>
<%--    <label>Produce:</label>--%>
<%--    <input type="text" name="produce" id="produce"><br>--%>
<%--    <button type="submit">Edit</button>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%--a?--%>
