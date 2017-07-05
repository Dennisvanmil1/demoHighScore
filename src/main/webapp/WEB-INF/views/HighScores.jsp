<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="highscores.css">

<title>Insert title here</title>
</head>
<body>



<p> </p>
<h3> Current highscore ranking:</h3>

<br>
${bestHighScore}
${currentScore}

<p>
<table class="table table-striped">

<tr>
	<td> <b>Rank</b></td>
	<td> <b>Player Name</b></td>
	<td> <b>Score </b></td>
</tr>

<c:forEach var="hsScore" items="${hsListTop10}" varStatus="loop">
   <tr>
   	  <td>${loop.index+1}</td>
      <td><c:out value="${hsScore.name}"/></td>
      <td><c:out value="${hsScore.score}"/></td>
   </tr>
</c:forEach>
</table>



</body>
</html>