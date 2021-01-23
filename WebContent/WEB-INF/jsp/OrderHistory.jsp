<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Ordered History</title>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br>
 
 <center>
<br><br><br>
<h3>${emptyHistory}</h3>
<h3>${orderHistorydeleted}</h3>
</center>


 <c:if test="${orderHistory!=null }">
 
<center>
<h1>Your Ordered History</h1>
</center>


	<table border="1" align="center" bordercolor="darkblue" cellspacing="0">

		<tr>
			 
			<!-- <th>Customer EmailId</th> -->
			<th>Food Name</th>
			<th>FoodQuantity</th>
			<th>Total Price</th>
			<th>Ordered Date</th>

		</tr>
		
		<c:forEach var="orderhistory" items="${orderHistory}">
		
			<tr>
			
				<!-- <td>${orderhistory.email_id}</td> -->
				<td>${orderhistory.food_name}</td>
				<td>${orderhistory.quantity}</td>
				<td>${orderhistory.total_price}</td>
				<td>${orderhistory.date}</td>
			</tr>
			
		</c:forEach>


	</table>
	
<center><a href="deletecustorderhistory">Clear History</a></center>
</c:if>
<br><br><br><br><br><br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>