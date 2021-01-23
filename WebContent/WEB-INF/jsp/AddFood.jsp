<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Food</title>
<style type="text/css">
td{font-size:12px;}
</style>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br><br><br><br>

<form:form method="post" action="savefood">
 <center>
<table>

<caption style="font-family:Georgia, Garamond, serif;font-size:22px;font-weight: bold;">Add Food</caption>
<tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>

<tr><td>Food ID</td>  <td><form:input path="food_id"/></td></tr><tr/><tr/>

<tr><td>Food Name</td>  <td><form:input path="food_name"/></td></tr><tr/><tr/>

<tr><td>Food Type</td>  <td><form:input path="food_type"/></td></tr><tr/><tr/>

<tr><td>Food Category</td>  <td><form:input path="food_category"/></td></tr><tr/><tr/>

<tr><td>Price</td>  <td><form:input path="price"/></td></tr>

</table><br>
<input type="submit" value="save" />
</center>

</form:form>

<br><br><br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>