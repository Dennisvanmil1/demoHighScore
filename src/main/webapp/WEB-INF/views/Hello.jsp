<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Table</h2>
  
  <table class="table">
   	<tr>
    <td><c:if test="${g.collumnA > 7}">${g.token}</c:if></td>
   	<td><c:if test="${g.collumnB > 7}">${g.token}</c:if></td>
   	<td><c:if test="${g.collumnC > 7}">${g.token}</c:if></td>
   	<td><c:if test="${g.collumnD > 7}">${g.token}</c:if></td>
    <td><c:if test="${g.collumnE > 7}">${g.token}</c:if></td> 
    <td><c:if test="${g.collumnF > 7}">${g.token}</c:if></td>
    <td><c:if test="${g.collumnG > 7}">${g.token}</c:if></td> 
    <td><c:if test="${g.collumnH > 7}">${g.token}</c:if></td>
   </tr>
  
  
  </table>                                         
  
</div>

</body>
</html>
