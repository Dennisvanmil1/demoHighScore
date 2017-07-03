<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="/demo/src/main/webapp/GridCSS.css" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>

<div id = "tableform" class="container">
  <h2>Vier op een rij</h2>
  
  <img src="/images/empty.jpg">
  <img src="/images/red.png">
  <img src="/images/yellow.jpg">
  
  <table class="table table-bordered">
  
  
<form action="${pageContext.request.contextPath}">
  		<td><button type = "submit" name = "buttonA" value = "buttonA">Add Coin</button></td>
  		<td><button type = "submit" name = "buttonB" value = "buttonB">Add Coin</button></td>
  		<td><button type = "submit" name = "buttonC" value = "buttonC">Add Coin</button></td>
  		<td><button type = "submit" name = "buttonD" value = "buttonD">Add Coin</button></td>
  		<td><button type = "submit" name = "buttonE" value = "buttonE">Add Coin</button></td>
  		<td><button type = "submit" name = "buttonF" value = "buttonF">Add Coin</button></td>
  		<td><button type = "submit" name = "buttonG" value = "buttonG">Add Coin</button></td>
  		<td><button type = "submit" name = "buttonH" value = "buttonH">Add Coin</button></td>
</form>
  		
  
  	<c:forEach begin="0" end="${fn:length(ColumnAArray)-1}" var="index">
   <tr>
      <td>${ColumnAArray[index]}</td>
      <td><c:out value="${ColumnBArray[index]}"/></td>
      <td><c:out value="${ColumnCArray[index]}"/></td>
      <td><c:out value="${ColumnDArray[index]}"/></td>
      <td><c:out value="${ColumnEArray[index]}"/></td>
      <td><c:out value="${ColumnFArray[index]}"/></td>
      <td><c:out value="${ColumnGArray[index]}"/></td>
      <td><c:out value="${ColumnHArray[index]}"/></td>
      
   </tr>
   <br>
</c:forEach>

   
  
  
  </table>                                         
  
</div>

</body>
</html>
