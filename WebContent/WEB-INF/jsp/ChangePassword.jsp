<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<style type="text/css">
td {
	font-size: 12px;
}
</style>
<script type="text/javascript">

	function matchpass() 
	{
		var firstpassword = document.loginf.pass.value;
		var secondpassword = document.loginf.new_pass.value;

		if (firstpassword == secondpassword) {
			return true;
		} else {
			alert("password must be same!");
			return false;
		}
	}
	
	function validate() 
	{  
		var msg; 
		if(document.loginf.pass.value.length>7){  
			msg=" Best";  
			}
		else if(document.loginf.pass.value.length>5){  
		msg=" Good";  
		}  
		  
		else{  
		msg=" Poor";  
		}  
		document.getElementById('passstrength').innerText=msg;  
		 }
</script>

</head>
<body >

	<jsp:include page="header.jsp"></jsp:include><br>
	<br>
	<br>
	<br>
	<b>${changepassfail}</b>
	<form method="post" action="changepassword" name="loginf"
		onsubmit="return matchpass()">
		
		
		<table align="center"">

<caption style="font-size:18px;" style="text-align:center"><b>Change Password</b></caption><tr></tr><tr></tr><tr></tr><tr></tr>

			<tr>
				<td>Type</td>
				<td><select name="type">
						<option value="USER">user</option>
						<option value="ADMIN">admin</option>
				</select></td>
			</tr>
			<tr /><tr />

			<tr>
				<td>New Password</td>
				<td><input type="password" name="pass" onkeyup="validate()"/><span id="passstrength">no strength</span></td> 
			</tr>
			<tr /><tr />

			<tr>
				<td>Re-Enter New Password</td>
				<td><input type="password" name="new_pass" /></td>
			</tr>
			

		</table>
		<br>
		<center><input type="submit" value="save change" /></center>
			
		
	</form>

	<br><br><br><br><br><br><jsp:include page="footer.jsp"></jsp:include>
</body>
</html>