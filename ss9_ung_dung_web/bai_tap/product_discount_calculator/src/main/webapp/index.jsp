<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/4/2022
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/display_discount" method="post">
  Products Description <input type="text" name="PD">
  List Price <input type="number" name="LP">
  Discount Percent <input type="number" name="DP">
  <br>
  <button type="submit">Callculate Discount</button>
  </form>
  </body>
</html>
