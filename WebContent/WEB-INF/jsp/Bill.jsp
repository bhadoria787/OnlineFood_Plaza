<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success!!</title>
<c:url value="/resources/images" var="img1"></c:url>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br><br><br>
<center>
<img align="middle" src="${img1}/orderplaced.png" alt="image" width="205" height="150"/><br>

<b>"Hurray Successfully ${Total}!!!!"</b>
</center>

<br><br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>