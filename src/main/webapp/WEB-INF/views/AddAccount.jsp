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
Accounttype:<f:select path="accountType" id="type">
             <f:option value="cash">cash</f:option>
             <f:option value="paytm">paytm</f:option>
             <f:option value="creditcard">credit card</f:option>
             <f:option value="debitcard">debitcard</f:option>


</f:select>
		<f:errors path="accountType"></f:errors>
		<br>
		<br>
		<div id="ammount">
ammount:<f:input path="ammount"  />
		<f:errors path="ammount"></f:errors>
		</div>
		<br>
		<br>

		<br>
<div id="upiid">	
Upiid:<f:input path="upiId"  />
		<f:errors path="upiId"></f:errors>
		<br>
		<br>

		<br>
		
	</div>
	<div id="cardno" >	
card no:<f:input path="cardId" />
		<f:errors path="cardId"></f:errors>
		<br>
		<br>

		<br>			
	</div>	
		
		<button type="submit" value="submit">Submit</button>



	</f:form>


<script type="text/javascript">
	document.addEventListener('DOMContentLoaded',function(){

        document.querySelector("#type").onchange=function(){
        	
        	if(this.value == 'creditcard' || this.value == 'debitcard' ){
                document.querySelector("#upiid").style.display='none';
                document.querySelector("#cardno").style.display='block';
                document.querySelector("#ammount").style.display='block';
        	}
        	if(this.value == "cash"){
        		document.querySelector("#upiid").style.display='none';
                document.querySelector("#cardno").style.display='none';
                document.querySelector("#ammount").style.display='block';
        	}
        	if(this.value == "paytm"){
        		document.querySelector("#upiid").style.display='block';
                document.querySelector("#cardno").style.display='none';
                document.querySelector("#ammount").style.display='block';
        	}
		}
	})
	</script>



</body>
</html>