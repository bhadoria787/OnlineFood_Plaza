<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>

</head>
<body>

<jsp:include page="header.jsp" ></jsp:include><br><br><br><br>
<form:form method="post" action="savecustomer" name="regis">
<center>
<table>
<caption style="font-size:25px;"><b>Register Yourself</b></caption>
<tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>

<tr><td>Customer Name</td>  <td><form:input path="cust_name"/></td></tr><tr/><tr/><tr/><tr/>

<tr><td>Customer Email_id</td>  <td><form:input type="email" path="cust_email"/></td></tr><tr/><tr/><tr/><tr/>

<tr><td>Customer Password</td>  <td><form:password path="cust_pass" /></td></tr><tr/><tr/><tr/><tr/>

<tr><td>Customer Contact</td>  <td><form:input path="cust_contact"/></td></tr><tr/><tr/><tr/><tr/>

<tr><td>Customer Address</td>  <td><form:input path="cust_address"/></td></tr><tr/><tr/><tr/><tr/>


</table><br>
<input type="submit" value="save" />
</center>
</form:form>

<br><br><jsp:include page="footer.jsp" ></jsp:include>

</body>
</html>