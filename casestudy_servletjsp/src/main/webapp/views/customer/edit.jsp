<%@ page import="model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/4/2022
  Time: 10:29 AM
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
<%Customer customer = (Customer) request.getAttribute("customer"); %>
<form method="post">
    <table>
        <tr>
            <th>Customer type</th>
            <td>
                <select name="customerType">
                    <c:forEach items="${customerTypeList}" var="customerType">
                        <option value="${customerType.customerID}">${customerType.nameCustomerType}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="ho_va_ten" value="<c:out value='${customer.name}'/>"></td>
        </tr>
        <tr>
            <th>Date Of Birth</th>
            <td><input type="text" name="dateOfBirth" id="ngay_sinh" value="<c:out value='${customer.dateOfBirth}'/>"></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td><input type="text" name="gender" id="gioi_tinh" value="<c:out value='${customer.gender}'/>"></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><input type="text" name="phone" id="so_dien_thoai" value="<c:out value='${customer.phone}'/>"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><input type="text" name="email" id="email" value="<c:out value='${customer.email}'/>"></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><input type="text" name="address" id="dia_chi" value="<c:out value='${customer.address}'/>"></td>
        </tr>
        <tr>
            <th>IDCard</th>
            <td><input type="text" name="idCard" id="so_cmnd" value="<c:out value='${customer.idCard}'/>"></td>
        </tr>
    </table>
    <button type="submit">Update</button>
</form>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
