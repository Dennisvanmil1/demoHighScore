<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="/GridCSS.css" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
  .table > thead > tr > th,
      .table > tbody > tr > th,
      .table > tfoot > tr > th,
      .table > thead > tr > td,
      .table > tbody > tr > td,
      .table > tfoot > tr > td {
      padding: 0px !important; cellspacing: 0px !important; text-align: center !important;
      padding-left: 0px; padding-right: 0px; background-color: #3A55EC !important;}
  </style>
	</head>
		<body>
			<div id = "tableform" class="container">
				<table class="table table-borderless table-condensed table-collapse">  
					<form action="${pageContext.request.contextPath}">
  		<td><button type = "submit" name = "buttonA" value = "buttonA"><b>Insert Token</b></button></td>
  		<td><button type = "submit" name = "buttonB" value = "buttonB"><b>Insert Token</b></button></td>
  		<td><button type = "submit" name = "buttonC" value = "buttonC"><b>Insert Token</b></button></td>
  		<td><button type = "submit" name = "buttonD" value = "buttonD"><b>Insert Token</b></button></td>
  		<td><button type = "submit" name = "buttonE" value = "buttonE"><b>Insert Token</b></button></td>
  		<td><button type = "submit" name = "buttonF" value = "buttonF"><b>Insert Token</b></button></td>
  		<td><button type = "submit" name = "buttonG" value = "buttonG"><b>Insert Token</b></button></td>
  		<td><button type = "submit" name = "buttonH" value = "buttonH"><b>Insert Token</b></button></td>
					</form>
 				<c:forEach begin="0" end="${fn:length(ColumnAArray)-1}" var="index">
   <tr>
      <td>${ColumnAArray[index]}</td>
      <td>${ColumnBArray[index]}</td>
      <td>${ColumnCArray[index]}</td>
      <td>${ColumnDArray[index]}</td>
      <td>${ColumnEArray[index]}</td>
      <td>${ColumnFArray[index]}</td>
      <td>${ColumnGArray[index]}</td>
      <td>${ColumnHArray[index]}</td>   
   </tr>
   <br>
				</c:forEach>
			</table>   
			<b>${checkWinner}</b>
			
			
			
<p id="endGame"></p>
<script>
function finishGame() {
    var txt;
    if (confirm("Would you like to save your score?") == true) {
       window.location.href = "http://localhost:8080/savescore";
    } else {
       window.location.href = "http://localhost:8080/grid";
    }
    document.getElementById("endGame").innerHTML = txt;
}
if("${checkWinner}" == ("Red player won the game") || "${checkWinner}" == ("Yellow player won the game")){
	finishGame();
}
</script>                                
  		</div>
	</body>
</html>
