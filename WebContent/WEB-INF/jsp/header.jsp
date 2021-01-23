<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.foodplaza.dao.CustomerDaoImpl"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<style type="text/css">

.dropbtn {
  padding: 16px;
  border: none;
  font-family:Georgia, Garamond, serif;
  font-style:italic;
  font-size:x-large;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 2;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;} </style>

<c:url value="/resources/css/templatemo_style.css" var="cssUrl"></c:url>
<link rel="stylesheet" href="${cssUrl}"></link>
<c:url value="/resources/images" var="img1"></c:url>

</head>
<body>
<% 
String userEmailId=(String)session.getAttribute("user"); 
String user_name=(String)session.getAttribute("customer_name");

String adminEmailId=(String)session.getAttribute("admin");
String admin_name=(String)session.getAttribute("adminname");
%>
<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        
          <%if(userEmailId==null && adminEmailId==null) 
            {%>
        	<li class="current"><a href="home"><b>Home</b></a></li>
        	<li><a href="showcartlist"><b>Menu</b></a></li>
        	<li><a href="customerform"><b>Sign Up</b></a></li>
        	<li><a href="loginform"><b>Login</b></a></li>
           <%}%>
            
            <%if(userEmailId!=null && adminEmailId==null) 
            {%>
            <div class="dropdown">
             <li class="current"><a class="dropbtn"><b><%=user_name%></b></a></li>
             <div class="dropdown-content">
             
             <a href="editCustomer?custEmail=<%=userEmailId%>">Update Profile</a>
             <a href="orderhistory">MY Order History</a>  
             </div>
            </div> 
             
            <li><a href="showcartlist"><b>Menu</b></a></li>
            <li><a href="Searchfoodform"><b>SearchFood</b></a></li>
            <li><a href="showcart"><b>Cart List</b></a></li>
            
            <li><a href="feedbackform"><b>Give Feedback</b></a></li>
            <li><a href="changepassform"><b>Change Password</b></a></li>
            <li><a href="logout"><b>Logout</b></a></li>
            
            <%} %>
            
            <%if(userEmailId==null && adminEmailId!=null) 
            {%>
            <li class="current"><a style="font-family:Georgia, Garamond, serif;font-style:italic;font-size:large;"><b><%=admin_name%></a></b></li>
            <li><a href="updateadminform">Update Profile</a></li>
            <li><a href="showcartlist"><b>Menu</b></a></li>
            <li><a href="showFoodForm"><b>Add Food</b></a></li>
            <li><a href="customerlist"><b>Customer List</b></a></li>
            <li><a href="changepassform"><b>Change Password</b></a></li>
            <li><a href="showAllfeedback"><b>Feedbacks</b></a></li>
            <li><a href="logout"><b>Logout</b></a></li>
            
            <%} %>
        </ul>
    </div> <!-- end of menu -->
</body>
</html>