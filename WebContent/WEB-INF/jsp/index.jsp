<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Royal Orchid Food Plaza</title>

<c:url value="/resources/css/templatemo_style.css" var="cssUrl"></c:url>
<link rel="stylesheet" href="${cssUrl}"></link>
<c:url value="/resources/images" var="img1"></c:url>

<meta name="keywords" content="" />
<meta name="description" content="" />
</head>
<body>
<jsp:include page="header.jsp" ></jsp:include><br/>

<% 
String userEmailId=(String)session.getAttribute("user"); 
String adminEmailId=(String)session.getAttribute("admin");  
%>

<c:if test="${loginsuc=='userloginsuc'}">   
  <img align="middle" src="${img1}/welcome.jpg" alt="image" width="100%" /><br> 
</c:if> 
<c:if test="${loginsuc=='adminloginsuc'}"> 
  <img align="middle" src="${img1}/welcome.jpg" alt="image" width="100%" /><br>
</c:if>
<center>
<c:if test="${custdetailupdate!=null}"> 
  <img align="middle" src="${img1}/successful.jpg" alt="image" width="205" height="150" /><br>
  <h3> <% out.print("Hurray!! "+userEmailId+" "); %>${custdetailupdate}</h3>
</c:if>
<c:if test="${custfeedback!=null}"> 
  <img align="middle" src="${img1}/feedback.png" alt="image" width="260" height="70" />
  <h3> <% out.print(userEmailId+", "); %>${custfeedback}</h3>
</c:if>
<c:if test="${changepassuc!=null}"> 
  <img align="middle" src="${img1}/changedpass.png" alt="image" width="60" height="60" />
  <h3> ${changepassuc}</h3>
</c:if>
<h3>${regissuc}</h3>
<h3>${detailupdate}</h3>
</center>
    
    <div id="templatemo_top_dishes">

    	<h1>Recommended Dishes</h1>
    	
        <div class="top_dishes_box">
       	  <img src="${img1}/burger.jpg" alt="image" width="205" height="150"/>
          <h2>Hamburger</h2>
            
      </div>
        
        <div class="top_dishes_box">
       	  <img src="${img1}/Matar-Paneer.jpg" alt="image" width="205" height="150"/>
            <h2>Mattar Paneer</h2>
         
        </div>
        
        <div class="top_dishes_box">
       	  <img src="${img1}/eggswithroastedbread.jpg" alt="image" width="205" height="150"/>
            <h2>Eggs with roasted bread</h2>
          
      </div>
        
        <div class="top_dishes_box">
       	  <img src="${img1}/south-indian-food.jpg" alt="image" width="205" height="150"/>
            <h2>Delicacies South Indian Dishes</h2>
            
         
        </div>
        
        <div class="cleaner">&nbsp;</div>
    
    </div> <!-- end of top dishes -->
    
    <div id="templatemo_content">
    	<span class="top"></span>
        <div id="templatemo_innter_content">
            
                <div id="templatemo_content_left">
                    <h1>Welcome to our website</h1>
                <img src="${img1}/resturant.jpg" alt="image" width="315" height="210" />
                    
                    
                        
                    <div class="cleaner_with_height">&nbsp;</div>
                
                </div> <!-- end of content left -->
                
                <div id="templatemo_content_right">
                    
                    <div class="right_column_section">
	                    <h1>Special meal for you</h1>
                        <img src="${img1}/garlicbread.jpg" alt="image"  width="205" height="150"/>
                        <h3>Garlic Bread</h3>
                     </div>
                
                </div> <!-- end of content right -->
        		<div class="cleaner">&nbsp;</div>
        </div>   
        <div class="cleaner" style="background: #fff;">&nbsp;</div> 	
    </div>


<jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>
