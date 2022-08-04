<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Expense</title>
</head>
<body>
<jsp:include page="CustomerHeader.jsp"></jsp:include>

	<table border="5">
		<tr>
			<th>Category</th>
			<th>Date</th>
			<th>Payment Type</th>
			<th>ExpenseAmount</th>
			<th>Time</th>
			<th>Description</th>
			
			<th>Action</th>

		</tr>
		<c:forEach items="${expense}" var="e">
			<tr>
				<td>${e.categoryId}</td>
				<td>${e.date}</td>
				
				<td>${e.typeOfPayment}</td>
				<td>${e.expenseAmmount}</td>
					<td>${e.time}</td>
						<td>${e.description}</td>
				<td><a href="deleteexpense?expenseid=${e.expenseId}">Delete</a>|<a href="updateexpense?expenseid=${e.expenseId}">Update</a></td>
			</tr>
		</c:forEach>

	</table>

</form>
</body>
</html>