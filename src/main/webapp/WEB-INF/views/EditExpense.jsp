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

<f:form action="expenseedit" method="post" modelAttribute="expense">

		
		
		
		Payment Type:<f:select path="typeOfPayment">
              <f:option value="cash">cash</f:option>
             <f:option value="paytm">paytm</f:option>
             <f:option value="creditcard">credit card</f:option>
             <f:option value="debitcard">debitcard</f:option>
            
</f:select>
		<f:errors path="typeOfPayment"></f:errors>
		<br>
		<br>
		
		
ExpenseAmmount:<f:input path="expenseAmmount" />
		<f:errors path="expenseAmmount"></f:errors>
		<br>
		<br>
		Date:<f:input path="date" type="date"/>
		<f:errors path="date"></f:errors>
		<br>
		<br>
		time:<f:input path="time" type="time"/>
		<f:errors path="time"></f:errors>
		<br>
		<br>
		Description:<f:input path="description" type="text"/>
		<f:errors path="description"></f:errors>
		<br>
		<br>

		<br>
		<button type="submit" value="submit">Submit</button>
<f:hidden path="expenseId"/>


	</f:form>





</body>
</html>