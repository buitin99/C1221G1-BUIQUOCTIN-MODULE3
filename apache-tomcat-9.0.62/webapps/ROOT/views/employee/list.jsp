<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/4/2022
  Time: 9:09 PM
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
<form action="/employee">
    <input type="hidden" name="action" value="search" placeholder="name">
    <input type="text" name="nameSearch" placeholder="name">
    <select name="positionSearch">
        <option value=""> Chọn vị trí</option>
        <c:forEach items="${position}" var="positions">
            <option value="${positions.id}">${positions.name}</option>
        </c:forEach>
    </select>
    <select name="divisionSearch">
        <option value=""> Chọn bộ phận</option>
        <c:forEach items="${division}" var="divisions">
            <option value="${divisions.id}">${divisions.name}</option>
        </c:forEach>
    </select>
    <button>Search</button>
</form>
<a href="/employee?action=create">Add new</a>
<table class="table table-striped">
    <tr>
        <td class="col-1">Id</td>
        <td class="col-1">Name</td>
        <td class="col-1">Date Of Birth</td>
        <td class="col-1">Id Card</td>
        <td class="col-1">salary</td>
        <td class="col-1">Phone</td>
        <td class="col-1">Email</td>
        <td class="col-1">Address</td>
        <td class="col-1">PositionId</td>
        <td class="col-1">educationDegreeId</td>
        <td class="col-1">divisionId</td>
        <td class="col1"><p>edit</p><p>delete</p></td>

    </tr>

    <c:forEach items="${employee}" var="employeeList">
        <tr>
            <td class="col-1">${employeeList.id}</td>
            <td class="col-1">${employeeList.name}</td>
            <td class="col-1">${employeeList.dateOfBirth}</td>
            <td class="col-1">${employeeList.idCard}</td>
            <td class="col-1">${employeeList.salary}</td>
            <td class="col-1">${employeeList.phone}</td>
            <td class="col-1">${employeeList.email}</td>
            <td class="col-1">${employeeList.address}</td>
            <c:forEach items="${position}" var="positionList">
                <c:if test="${employeeList.positionId == positionList.id}">
                    <td class="col-1">${positionList.name}</td>
                </c:if>
            </c:forEach>

            <c:forEach items="${education}" var="educationList">
                <c:if test="${employeeList.educationDegreeId == educationList.id}">
                    <td class="col-1">${educationList.name}</td>
                </c:if>
            </c:forEach>

            <c:forEach items="${division}" var="divisionList">
                <c:if test="${employeeList.divisionId == divisionList.id}">
                    <td class="col-1">${divisionList.name}</td>
                </c:if>
            </c:forEach>
            <td class="col-1">
                <a href="/employee?action=edit&id=${employeeList.id}">edit</a>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                        onclick="deleteCustomer(${employeeList.id},'${employeeList.name}')">
                    Xóa
                </button>
            </td>

        </tr>
    </c:forEach>

</table>

<form action="/employee" method="post">
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="idEmployeeDelete">
                    <p style="color: red">Bạn có chắc muốn xóa <span id="nameEmployee"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Xóa</button>
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    function deleteCustomer(id, name) {
        document.getElementById("idEmployeeDelete").value = id;
        document.getElementById("nameEmployee").innerText = name;
    }
</script>

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
