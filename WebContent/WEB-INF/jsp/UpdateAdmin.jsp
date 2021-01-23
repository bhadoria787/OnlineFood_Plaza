<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Admin</title>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br><br><br><br>
<form method="post" action="updateadmin">
<center><caption style="font-size:25px;"><h2>Update Your Details</h2></caption></center>
<table align="center">


<tr><td>Admin Name</td>  <td><input type="text" name="admin_name" /></td></tr><tr/><tr/>

<tr><td>Admin Email_id</td>  <td><input type="email" name="admin_emailid" /></td></tr><tr/><tr/>

<tr><td>Admin Password</td>  <td><input type="password"   name="admin_pass" /></td></tr><tr/><tr/>

<tr><td>Admin Contact</td>  <td><input type="number" name="admin_phone_no" /></td></tr><tr/><tr/>

</table><br>

<center><input type="submit" value="update" /></center>

</form>

<br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>