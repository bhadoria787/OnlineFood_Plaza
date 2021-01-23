<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" ></jsp:include>	<br><br><br><br>	
		
<form:form method="post" action="addtocart">
<center>
<table >
<caption style="font-size:25px;"><b>ADD TO CARD</b></caption>
<tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>

<tr><td>Cart id</td>  <td><form:input path="cart_id"/></td></tr>

<tr><td>Cart Email id</td>  <td><form:input path="cust_emailid"/></td></tr>

<tr><td>Food id</td>  <td><form:input path="food_id" value="${food.food_id }" /></td></tr>

<tr><td>Food name</td>  <td><form:input path="food_name"/></td></tr>

<tr><td>Cart quantity</td>  <td><form:input path="cart_quantity"/></td></tr>

<tr><td>Total price</td>  <td><form:input path="total_price"/></td></tr>



</table><br>
<input type="submit" value="addtocart" />
</center>
</form:form>

<jsp:include page="footer.jsp" ></jsp:include>	
</body>
</html>