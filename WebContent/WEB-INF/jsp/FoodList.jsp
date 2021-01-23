<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<c:url value="/resources/images" var="img1"></c:url>
<style type="text/css">
td{font-family:Georgia, Garamond, serif;color:#002b80;font-style:italic;font-size:15px;font-weight: bold;text-align: center;}
th{font-family:Georgia, Garamond, serif;color:black;font-style:italic;font-size:15px;}

</style>

</head>
<body>
<% String userEmailId=(String)session.getAttribute("user"); 
   String adminEmailId=(String)session.getAttribute("admin"); 
%>
<jsp:include page="header.jsp" ></jsp:include><br><br><br><br>


 
	<table  align="center">
		<caption style="font-size:25px;"><b><u>MENU CARD</u></b></caption><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<th>Food Id</th>
			<th>Food Name</th>
			<th>Food Type</th>
			<th>Food Category</th>
			<th>Food Price</th>
			<%if(userEmailId==null && adminEmailId!=null){%>
			<th>Edit</th>
			<th>Delete</th>
			<%}%>
				
			<%if(userEmailId!=null && adminEmailId==null) {%>
			<th>Add to Cart</th>
			<%} %>
		</tr><tr/><tr/><tr/><tr/>
		<c:forEach var="food" items="${foodlist}">
			<tr>
				<td>${food.food_id}</td>
				<td Style="color:#3399ff;">${food.food_name}</td>
				<td>${food.food_type}</td>
				<td>${food.food_category}</td>
				<td Style="color:#3399ff;">${food.price}</td>
				<%if(userEmailId==null && adminEmailId!=null){%>
				<td><a href="editFood?foodId=${food.food_id}">edit</a></td>
				<td><a href="deleteFood?foodId=${food.food_id}">delete</a></td>
				<%}%>
				
				<%if(userEmailId!=null && adminEmailId==null) {%>
				<td><a href="addtocart?foodId=${food.food_id}">addToCart</a></td>
				<%} %>
			</tr>	<tr/><tr/>
		</c:forEach>
	</table>	
<jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>