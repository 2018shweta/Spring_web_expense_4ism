<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<jsp:include page="CustomerHeader.jsp"></jsp:include>
<table border="2">


<tr>
<th>Account Type</th>
<th>cardNumber</th>
<th>upiId</th>
<th>ammount</th>
<th>IsActive</th>
<th>Add Money</th>
</tr>

<c:forEach items="${accountBean }" var="a">
   <tr>
   
   <td>${a.accountType }</td>
   <td>${a.cardId }</td>
   <td>${a.upiId }</td>
   <td>${a.ammount}</td>
   <td>${a.isActive}</td>
   <td><a href="addmoney?accountid=${a.accountId}">AddMoney</a></td>
   </tr>
   






</c:forEach>




</table><br><br>
<h1>total</h1>
<%--  <c:forEach items="${ac}" var="ac">


<!--  <h3>${ac.ammount}</h3>-->
</c:forEach>
--%>
<h3>${total}</h3>
</body>
</html>