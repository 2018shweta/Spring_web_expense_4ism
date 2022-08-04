<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<jsp:include page="CustomerHeader.jsp"></jsp:include>



<form action="addedmoney?accountid=${accountId}" method="post">


Add Ammount:<input type="text" name="ammount"><br><br>
<input type="submit">


</form>





</body>
</html>