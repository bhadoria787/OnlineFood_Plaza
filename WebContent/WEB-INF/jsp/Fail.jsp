<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fail!!</title>
<c:url value="/resources/images" var="img1"></c:url>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br><br><br><br><br>

<img align="middle" src="${img1}/fail2.jpg" alt="image" /><br>
<b>Failed !!!! ${status}</b>

<br><br><br><br><br><br>
<jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>