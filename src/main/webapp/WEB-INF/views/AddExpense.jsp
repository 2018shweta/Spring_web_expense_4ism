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

<f:form action="expenseadded" method="post" modelAttribute="expenseBean">

		
		category<f:select path="categoryId" id="category" >
<c:forEach items="${category}" var="c">
<f:option value="${c.categoryId }">${c.categoryName}</f:option>

</c:forEach>
</f:select>

		
		<f:errors path="categoryId"></f:errors>
		<br>
		<br>
		
		
	sub category<f:select path="subCategoryId" id="subcategory">
	
	<f:option value="">Select sub category</f:option>
	
	
	</f:select>	
		
		Payment Type:<f:select path="typeOfPayment" id="accounts">
              <%-- <f:option value="cash">cash</f:option>
             <f:option value="paytm">paytm</f:option>
             <f:option value="creditcard">credit card</f:option>
             <f:option value="debitcard">debitcard</f:option> --%>
            <f:option value="">Select sub category</f:option>
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script>
	
		$(document).ready(function(){
			$("#category").change(function(){
			var id = document.getElementById("category").value;
						let url = "http://localhost:9595/subcategories?categoryId="+id;	
						 	 
						$.get(url)
						.done(function(data){
							console.log("gj"+data);
							let subcategory = $("#subcategory");
							subcategory.empty() 
								for(let i=0;i<data.length;i++){ 
								if(data[i].categoryId == id){
									subcategory.append(`<option value=`+data[i].subCategoryId+`>`+data[i].subCategoryName+`</option>`);
								}
							}
							//fun done
						}).fail(function(){
							console.log("something went wrong"); 
						});
			})//change()	
		
		
	
			$("#category").change(function(){
						let url = "http://localhost:9595/perCardId";	
						 	 
						$.get(url)
						.done(function(data){
							console.log("ac"+data);
							let sub = $("#accounts");
							sub.empty();
								for(let i=0;i<data.length;i++){ 
								console.log(data[i].accountId);
									sub.append("<option value="+data[i].accountId+">"+data[i].accountType+" / "+data[i].accountId+"</option>");
								
							}
							
						}).fail(function(){
							console.log("something went wrong"); 
						});
						
			
			})
		})//ready()
		
	</script>





</body>
</html>