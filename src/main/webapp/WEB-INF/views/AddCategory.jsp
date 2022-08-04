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
//<jsp:include page="CustomerHeader.jsp"></jsp:include>

<f:form action="categoryadded" method="post" modelAttribute="categoryBean">
Category Name:<f:input path="categoryName"/>
		<button type="submit" value="submit">Submit</button>



	</f:form>









</body>
</html>