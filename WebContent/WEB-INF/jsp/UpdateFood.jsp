<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" /><br><br><br><br>
<form:form method="post" action="updatefood">
 <center>
<table >
<caption style="font-size:25px;"><b><u>UpdateFood</u></b></caption>
<tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/><tr/>

<tr><td>Food Id</td>  <td><form:input path="food_id" value="${food.food_id}" /></td></tr><tr/><tr/>

<tr><td>Food Name</td>  <td><form:input path="food_name" value="${food.food_name}"/></td></tr><tr/><tr/>

<tr><td>Food Type</td>  <td><form:input path="food_type" value="${food.food_type}"/></td></tr><tr/><tr/>

<tr><td>Food Category</td>  <td><form:input path="food_category" value="${food.food_category}"/></td></tr><tr/><tr/>

<tr><td>Price</td>  <td><form:input path="price" value="${food.price}"/></td></tr><tr/><tr/>

</table><br>
<input align="middle" type="submit" value="update" />
</center>
</form:form>

<br><br><br><br><br><br><jsp:include page="footer.jsp" />
</body>
</html>