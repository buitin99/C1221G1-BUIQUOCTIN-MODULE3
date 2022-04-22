<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/4/2022
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Case study servlet jsp</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="row">
  <div class="col-4"></div>
  <div class="col-4"></div>
  <div class="col-4">
    <p style="float: right; text-align: center">[C1221-G1]Bùi Quốc Tín</p>
  </div>
</div>
<hr>
<nav>
  <div class="row col-12" style="float: right">
    <div class="col-8" style="float:right;">
      <ul class="row" style="list-style-type: none">
        <li class="col-2"><a href="#">Home</a></li>
        <li class="col-2"><a href="/employee?action=employee">Employee</a></li>
        <li class="col-2"><a href="/customer?action=list">Customer</a></li>
        <li class="col-2"><a href="/service?action=service">Service</a></li>
        <li class="col-2"><a href="">Contract</a></li>
      </ul>
    </div>
    <div class="col-4">
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<div class="col-12 row">
  <div class="col-3"></div>
  <div class="col-9"></div>
</div>
<hr>
<div class="row">
  <div class="col-4">
    <ul style="list-style-type: none">
      <li>item 1</li>
      <li>item 2</li>
      <li>item 3</li>
    </ul>
  </div>
  <div class="col-8">body</div>
</div>
<div class="row">
  <div class="col-12">
    <p style="text-align: center">footer</p>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>