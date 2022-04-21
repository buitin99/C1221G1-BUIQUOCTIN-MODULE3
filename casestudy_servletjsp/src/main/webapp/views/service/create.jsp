<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/4/2022
  Time: 9:54 AM
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
            <th>Name</th>
            <td><input type="text" name="name" id="ten_dich_vu"></td>
        </tr>
        <tr>
            <th>Area</th>
            <td><input type="text" name="area" id="dien_tich"></td>
        </tr>
        <tr>
            <th>cost</th>
            <td><input type="text" name="cost" id="chi_phi_thue"></td>
        </tr>
        <tr>
            <th>peoples</th>
            <td><input type="text" name="peoples" id="sp_nguoi_toi_da"></td>
        </tr>
        <th>type</th>
        <td>
            <select name="typeId">
                <c:forEach items="${serviceType}" var="serviceTypes">
                    <option value="${serviceTypes.id}">${serviceTypes.name}</option>
                </c:forEach>
            </select>
        </td>
        <th>Customer type</th>
        <td>
            <select name="typeIdService">
                <c:forEach items="${rentType}" var="rentTypes">
                    <option value="${rentTypes.id}">${rentTypes.name}</option>
                </c:forEach>
            </select>
        </td>
        <tr>
            <th>standard</th>
            <td><input type="text" name="standard" id="tieu_chuan_phong"></td>
        </tr>
        <tr>
            <th>describe</th>
            <td><input type="text" name="describe" id="mo_ta_tien_nghi_khac"></td>
        </tr>
        <tr>
            <th>areaPool</th>
            <td><input type="text" name="areaPool" id="dien_tich_ho_boi"></td>
        </tr>
        <tr>
            <th>floor</th>
            <td><input type="text" name="floor" id="so_tang"></td>
        </tr>
        <button type="submit">Add new</button>
    </table>
</form>
</body>
</html>
