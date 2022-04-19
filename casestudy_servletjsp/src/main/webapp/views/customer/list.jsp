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
<form action="/customer">
    <input type="hidden" name="action" value="search" placeholder="name">
    <input type="text" name="nameSearch" placeholder="name">
    <input type="text" name="phoneSearch" placeholder="phone">
    <select name="typeSearch">
        <option value=""> Chọn loại Khách</option>
        <c:forEach items="${customerTypeList}" var="customerType">
            <option value="${customerType.customerID}">${customerType.nameCustomerType}</option>
        </c:forEach>
    </select>
    <button>Search</button>
</form>
<a href="/customer?action=create">Add new</a>

<table class="table table-striped">
    <tr>
        <td class="col-1">Id</td>
        <td class="col-1">Customer type</td>
        <td class="col-2">Name</td>
        <td class="col-1">Date Of Birth</td>
        <td class="col-1">Gender</td>
        <td class="col-1">Phone</td>
        <td class="col-1">Email</td>
        <td class="col-1">Address</td>
        <td class="col-1">Id Card</td>
        <td colspan="col-1">Edit</td>
        <td colspan="col-1">Delete</td>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>

            <td class="col-1">${customer.id}</td>
            <c:forEach items="${customerTypeList}" var="customerType">
                <c:if test="${customer.customerTypeId==customerType.customerID}">
                    <td class="col-1">${customerType.nameCustomerType}</td>
                </c:if>
            </c:forEach>

<%--            <td class="col-1">${customer.customerTypeId}</td>--%>

            <td class="col-2">${customer.name}</td>
            <td class="col-1">${customer.dateOfBirth}</td>
<%--            <td class="col-1">${customer.gender}</td>--%>
            <td class="col-1">
                <c:if test="${customer.gender == 0}">Nữ</c:if>
                <c:if test="${customer.gender == 1}">Nam</c:if>
            </td>
            <td class="col-1">${customer.phone}</td>
            <td class="col-1">${customer.email}</td>
            <td class="col-1">${customer.address}</td>
            <td class="col-1">${customer.idCard}</td>
            <td class="col-1"><a href="#">edit</a></td>
            <td class="col-1"><a href="#">delete</a></td>
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
