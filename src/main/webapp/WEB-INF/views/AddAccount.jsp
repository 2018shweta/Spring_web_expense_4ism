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

<f:form action="accountadded" method="post" modelAttribute="accountBean">
Accounttype:<f:select path="accountType">
             <f:option value="cash">cash</f:option>
             <f:option value="paytm">paytm</f:option>
             <f:option value="creditcard">credit card</f:option>
             <f:option value="debitcard">debitcard</f:option>


</f:select>
		<f:errors path="accountType"></f:errors>
		<br>
		<br>
ammount:<f:input path="ammount" />
		<f:errors path="ammount"></f:errors>
		<br>
		<br>

		<br>
		<button type="submit" value="submit">Submit</button>



	</f:form>






</body>
</html>