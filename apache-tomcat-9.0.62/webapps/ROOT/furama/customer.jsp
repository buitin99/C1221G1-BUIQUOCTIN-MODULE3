<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/4/2022
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped">
    <tr>
        <td class="col-1">Id</td>
        <td class="col-1">Customer type</td>
        <td class="col-2">Name</td>
        <td class="col-1">Date Of Birth</td>
        <td class="col-1">Gender</td>
        <td class="col-2">Phone</td>
        <td class="col-1">Email</td>
        <td class="col-2">Address</td>
        <td class="col-1">Id Card</td>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td class="col-1">${customer.id}</td>
            <td class="col-1">${customer.customerTypeId}</td>
            <td class="col-2">${customer.name}</td>
            <td class="col-1">${customer.dateOfBirth}</td>
            <td class="col-1">${customer.gender}</td>
            <td class="col-2">${customer.phone}</td>
            <td class="col-1">${customer.email}</td>
            <td class="col-2">${customer.address}</td>
            <td class="col-1">${customer.id_card}</td>
        </tr>
    </c:forEach>
    </tr>
</table>


</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
