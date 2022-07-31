<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="CustomerHeader.jsp"></jsp:include>

<f:form action="expenseadded" method="post" modelAttribute="expenseBean">
Category:<f:select path="category">
             <f:option value="Food">Food</f:option>
             <f:option value="Shopping">Shopping</f:option>
             <f:option value="Lunch">Lunch</f:option>
             <f:option value="Dinner">Dinner</f:option>

 <f:option value="Fuel">Fuel</f:option>
  <f:option value="Grocery">Grocery</f:option>
   <f:option value="Coffe">Coffe</f:option>
</f:select>
		<f:errors path="category"></f:errors>
		<br>
		<br>
		
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



	</f:form>








</body>
</html>