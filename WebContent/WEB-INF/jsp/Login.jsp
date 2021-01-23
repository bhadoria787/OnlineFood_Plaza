<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<c:url value="/resources/images" var="img1"></c:url>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br><br>
<center><c:if test="${loginfail!=null}">
  <img align="middle" src="${img1}/fail2.jpg" alt="image" width="205" height="150" /><br>
  <h1>${loginfail}</h1><br />
</c:if>
<c:if test="${loginfail==null}">
  <img align="middle" src="${img1}/loginsign.png" alt="image" width="90" height="70" /><br><br>
</c:if>
</center>


	<form method="post" action="savelogin">

		<table align="center">
			
			<caption style="font-size:25px;"><b>Login</b></caption>
            <tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>

			<tr>
				<td>Type</td>
				<td>
				<select name="type">
				<option value="USER">user</option>
				<option value="ADMIN">admin</option>
				</select></td>
			</tr><tr/><tr/>
			<tr>
				<td>Email-Id</td>
				<td><input type="text" name="emailid" /></td>
			</tr><tr/><tr/>

			<tr>
				<td>Password</td>
				<td><input type="password"  name="pass" /></td>
			</tr><tr/><tr/>
			
      
		</table><br>
		<center><input align="middle" type="submit" value="Login" /></center>
	</form><br>
<center><a href="forgotpasswordform">Forgot Password</a></center>
<br><br><jsp:include page="footer.jsp"></jsp:include>
</body>
</html>