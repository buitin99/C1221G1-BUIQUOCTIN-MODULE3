<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/4/2022
  Time: 3:13 PM
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
<%Employee employee = (Employee) request.getAttribute("employee"); %>
<form method="post">
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="ho_ten" value="<c:out value='${employee.name}'/>"></td>
        </tr>
        <tr>
            <th>Date Of Birth</th>
            <td><input type="text" name="dateOfBirth" id="ngay_sinh" value="<c:out value='${employee.dateOfBirth}'/>"></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td><input type="text" name="idCard" id="so_cmnd" value="<c:out value='${employee.idCard}'/>"></td>
        </tr>
        <tr>
            <th>salary</th>
            <td><input type="text" name="salary" id="luong" value="<c:out value='${employee.salary}'/>"></td>
        </tr>
        <tr>
            <th>phone</th>
            <td><input type="text" name="phone" id="so_dien_thoai" value="<c:out value='${employee.phone}'/>"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><input type="text" name="email" id="email" value="<c:out value='${employee.email}'/>"></td>
        </tr>
        <tr>
            <th>address</th>
            <td><input type="text" name="address" id="dia_chi" value="<c:out value='${employee.address}'/>"></td>
        </tr>
        <tr>
            <th>positionId</th>
            <td>
                <select name="positionId">
                    <c:forEach items="${position}" var="positions">
                        <option value="${positions.id}">${positions.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>educationDegreeId</th>
            <td>
                <select name="educationDegreeId">
                    <c:forEach items="${education}" var="educations">
                        <option value="${educations.id}">${educations.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>divisionId</th>
            <td>
                <select name="divisionId">
                    <c:forEach items="${division}" var="divisions">
                        <option value="${divisions.id}">${divisions.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <button type="submit">Update</button>
</form>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
