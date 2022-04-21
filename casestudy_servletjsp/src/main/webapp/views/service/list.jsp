<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/4/2022
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<a href="/service?action=create">Add new</a>
<table class="table table-striped">
    <tr>
        <td class="col-1">Id</td>
        <td class="col-1">name</td>
        <td class="col-2">area</td>
        <td class="col-1">cost</td>
        <td class="col-1">peoples</td>
        <td class="col-1">type</td>
        <td class="col-1">typeId</td>
        <td class="col-1">standard</td>
        <td class="col-1">describe</td>
        <td colspan="col-1">areaPool</td>
        <td colspan="col-1">floor</td>
    </tr>
    <c:forEach items="${serviceList}" var="service">
        <tr>

            <td class="col-1">${service.id}</td>
            <td class="col-1">${service.name}</td>
            <td class="col-2">${service.area}</td>
            <td class="col-1">${service.cost}</td>
            <td class="col-1">${service.peoples}</td>
<%--            <td class="col-1">${service.typeId}</td>--%>
<%--            <c:forEach items="${rentTypes}" var="rTyppe">--%>
<%--                <c:if test="${service.typeId == rType.id}">--%>
<%--                    <td class="col-1">${rType.name}</td>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>
            <c:forEach items="${rentType}" var="rentTyppe">
                <c:if test="${service.typeId == rentTyppe.id}">
                    <td class="col-1">${rentTyppe.name}</td>
                </c:if>
            </c:forEach>
<%--            <td class="col-1">${service.typeIdService}</td>--%>
                <c:forEach items="${serviceType}" var="svType">
                    <c:if test="${service.typeIdService == svType.id}">
                       <td class="col-1">${svType.name}</td>
                    </c:if>
                </c:forEach>
            <td class="col-1">${service.standard}</td>
            <td class="col-1">${service.describe}</td>
            <td class="col-1">${service.areaPool}</td>
            <td class="col-1">${service.floor}</td>
        </tr>
    </c:forEach>
</table>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
