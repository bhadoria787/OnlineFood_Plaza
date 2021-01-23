<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<c:url value="/resources/images" var="img1"></c:url>
<style type="text/css">
td{font-size:12px;}

</style>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br>
 
<center>
<img align="middle" src="${img1}/customerlist.png" alt="image" width="140" height="110" /><br>
<h1>Customer List</h1>
</center>
	<table border="1" align="center" bordercolor="darkblue" cellspacing="0">

		<tr>
			
			<th>Customer EmailId</th>
			<th>Customer Name</th>
			<th>Customer Password</th>
			<th>Customer Contact</th>
			<th>Customer Address</th>
			
			<th>Delete</th>
		</tr>
		
		<c:forEach var="customer" items="${custlist}">
		
			<tr>
				<td>${customer.cust_email}</td>
				<td>${customer.cust_name}</td>
				<td>${customer.cust_pass}</td>
				<td>${customer.cust_contact}</td>
				<td>${customer.cust_address}</td>
				
				<td><a href="deleteCustomer?custEmail=${customer.cust_email}">delete</a></td>
			</tr>
			
		</c:forEach>


	</table>


<br><br><br><br><br><br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>