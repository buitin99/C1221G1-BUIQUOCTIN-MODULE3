<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/4/2022
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="ho_ten"></td>
        </tr>
        <tr>
            <th>dateOfBirth</th>
            <td><input type="text" name="dateOfBirth" id="ngay_sinh"></td>
        </tr>
        <tr>
            <th>idCard</th>
            <td><input type="text" name="idCard" id="so_cmnd"></td>
        </tr>
        <tr>
            <th>salary</th>
            <td><input type="text" name="salary" id="luong"></td>
        </tr>
        <tr>
            <th>phone</th>
            <td><input type="text" name="phone" id="so_dien_thoai"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><input type="text" name="email" id="email"></td>
        </tr>
        <tr>
            <th>address</th>
            <td><input type="text" name="address" id="dia_chi"></td>
        </tr>
        <tr>
            <th>position id</th>
            <td>
                <select name="positionId">
                    <c:forEach items="${position}" var="positions">
                        <option value="${positions.id}">${positions.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Education Degree</th>
            <td>
                <select name="educationDegreeId">
                    <c:forEach items="${education}" var="educations">
                        <option value="${educations.id}">${educations.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Division id</th>
            <td>
                <select name="divisionId">
                    <c:forEach items="${division}" var="divisions">
                        <option value="${divisions.id}">${divisions.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <button type="submit">Add new</button>
    </table>
</form>
</body>
</html>
