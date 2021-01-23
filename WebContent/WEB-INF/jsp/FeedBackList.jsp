<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers Feedbacks</title>
<c:url value="/resources/images" var="img1"></c:url>
<style type="text/css">
td{font-size:12px;}
</style>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br><br><br>
<center><h1>Customers Feedbacks</h1></center>

	<table border="1" align="center" bordercolor="darkblue" cellspacing="0">

		<tr>
			<th>FeedBack ID</th>
			<th>Customer Name</th>
			<th>Customer Email_ID</th>
			<th>Review</th>
			<th>Suggestion</th>
			<th>Remove Feedback</th>
		</tr>

		<c:forEach var="feedback" items="${feedbklist}">

			<tr>
				<td>${feedback.feedback_id}</td>
				<td>${feedback.customer_name}</td>
				<td>${feedback.customer_emailid}</td>
				<td>${feedback.review}</td>
				<td>${feedback.suggestion}</td>
				<td><a href="deletefd?feedbackid=${feedback.feedback_id}">remove</a></td>
			</tr>

		</c:forEach>

	</table><br>
	<center><img align="middle" src="${img1}/feedback_solutions1.png" alt="image" width="205" height="150" /></center>
<br><br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>