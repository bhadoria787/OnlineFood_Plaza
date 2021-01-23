<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CART LIST</title>
<c:url value="/resources/images" var="img1"></c:url>
<style type="text/css">
 
</style>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br><br><br><br>

<form:form action="placeorder" >
<center>
<c:if test="${pofail!=null}">
  <img align="middle" src="${img1}/emptycart.png" alt="image"  width="205" height="150" /><br>
  <h3>${pofail}</h3><br />
</c:if>

<c:if test="${deletecart!=null}">
  <img align="middle" src="${img1}/itemremove.png" alt="image"  width="170" height="125" /><br>
  <h3>${deletecart}</h3><br />
</c:if>

<c:if test="${emailnotsent!=null}">
<img align="middle" src="${img1}/orderplaced.png" alt="image" width="205" height="150"/><br>
<h2>${emailnotsent}</h2>
<h3 style="color: #404040">kindly update your id to one which you use for gmail account to get more infor about your order through our email service </h3>
</c:if>

<c:if test="${emailsent!=null}">
<img align="middle" src="${img1}/orderplaced.png" alt="image" width="205" height="150"/><br>
<h2>${emailsent}</h2>
</c:if>

<br>
<c:if test="${pofail==null && emailnotsent==null && emailsent==null}">
<caption><h2>CART LIST</h2></caption>


	<table border="1" bordercolor="darkblue" cellspacing="0">
		
		
        
		<tr>
			<th>Cart id</th>
			<th>Customer Email Id</th>
			<th>Food Id</th>
			<th>Food Name</th>
			<th>Food Quantity</th>
			<th>Total Price</th>
			<th>Clear Cart</th>
			<th>Delete Cart</th>
		</tr>

		<c:forEach var="cart" items="${cartlist}">

			<tr>
				<td>${cart.cart_id}</td>
				<td>${cart.cust_emailid}</td>
				<td>${cart.food_id}</td>
				<td>${cart.food_name}</td>
				<td>${cart.cart_quantity}</td>
				<td>${cart.total_price}</td>
				<input type="hidden" name="foodname" value="${cart.food_name}">
				<input type="hidden" name="price" value="${cart.total_price}">
				<input type="hidden" name="quantity" value="${cart.cart_quantity}">
				<td><a href="clearCart?cust_emailId=${cart.cust_emailid}">clear</a></td>
				<td><a href="deleteCart?cartId=${cart.cart_id}">delete</a></td>
			</tr>

		</c:forEach>
		
	</table>
	<br>
	<input type="submit" value="placeorder">&nbsp;&nbsp;
	<input type="submit" value="cancel">
	</center>
	</c:if>
</form:form>

<br><br><br><br><br><br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>