<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> style="width: 100%; height:50%;"</title>
<c:url value="/resources/images" var="img1"></c:url>
<style type="text/css">

   table {
      position: relative;
      z-index: 1;
    }
    
    img{
      position: absolute;
      z-index: 2;
      top: 52%;
      left:18%;
    }
 
</style>
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br><br><br><br>
<img align="middle" src="${img1}/feedbackp.jpg" alt="image" width="280" height="220" /><br><br>
<form:form  action="addFeedback" method="post">
<center>
<caption><h2>Submit Your Feedbacks</h2></caption>

<table>

			<tr> <td>Customer Name:</td>     <td><form:input path="customer_name"/></td>    </tr><tr/><tr/>
			<tr> <td>Customer Emailid:</td>  <td><form:input path="customer_emailid"/></td> </tr><tr/><tr/>
			<tr> <td>Review:</td>            <td><form:input path="review" /></td>          </tr><tr/><tr/>
			<tr> <td>Suggestion:</td>        <td><form:input path="suggestion"/></td>       </tr><tr/><tr/>
			<tr><td></td></tr>
</table><br>
<input type="submit" value="submit" />
</center>
</form:form>

<br><br><jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>