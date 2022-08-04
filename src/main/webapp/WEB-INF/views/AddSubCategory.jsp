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

<f:form action="subcategoryadded" method="post" modelAttribute="subCategoryBean">



category<f:select path="categoryId" >
<c:forEach items="${category}" var="c">
<f:option value="${c.categoryId }">${c.categoryName}</f:option>






</c:forEach>
</f:select>






Category Name:<f:input path="subCategoryName"/>
		<button type="submit" value="submit">Submit</button>



	</f:form>








</body>
</html>