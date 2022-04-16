<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
  <a href="/product">Back to product list</a>
</p>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <input type="text" name="name"><br>
      </tr>
      <tr>
        <td>price: </td>
        <input type="number" name="price"><br>
      </tr>
      <tr>
        <td>describe: </td>
        <input type="text" name="describe"><br>
      </tr>
      <tr>
        <td>produce: </td>
        <input type="text" name="produce"><br>
      </tr>
      <tr>
        <td><input type="submit" value="Delete customer"></td>
        <td><a href="/customers">Back to product list</a></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>