<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set new password</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	<br>
	
	<center>
		<c:if test="${usernotpresent!=null}">
			<h3>${usernotpresent}</h3>
		</c:if>
		<br>

		<c:if test="${wrongno!=null}">
			<h3>${wrongno}</h3>
		</c:if>
		<br>

		<c:if test="${passresetsuccess!=null}">
			<h3 style="color: green;">${passresetsuccess}</h3>
			<h3>Please set the pass which is unique as well one which you
				can rememeber</h3>
		</c:if>
		<br>
		<h3>Enter details to get your password</h3></center>
		
		<br>
		<form action="forgotpassword" method="post">
			<table align="center">

				<tr>
					<td>Type</td>
					<td><select name="type">
							<option value="USER">user</option>
							<option value="ADMIN">admin</option>
					</select></td>
				</tr>
				<tr />
				<tr />

				<tr>
					<th>Email Id:</th>
					<td><input type="type" name="emailid"></td>
				</tr>
				<tr />
				<tr>
					<th>Phone number:</th>
					<td><input type="type" name="phoneno"></td>
				</tr>
				<tr />

			</table>
			<br>
			<center><input type="submit" value="Enter"></center>
		</form>

	<br>
	<br><jsp:include page="footer.jsp"></jsp:include>
</body>
</html>