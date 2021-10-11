<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/Styles.css">
	<link rel="icon" href="imgs/logo.png">
	<title>login</title>
</head>
<img src="imgs/logo.png" class = "center">
<body>

<%
String usu="";
if(request.getParameter("dato")!=null){
usu=request.getParameter("dato");
}
%>
	<form action="ServLetLogin" method="post" >	
		<div style='position: absolute; z-index: 0; left: 565px; top: 250px; width: 400px; height: 230px; background-color:#333333'><br>
   			<table class="card">
        	<tr>
            	<td><center><label style="color:#d95e28" for = "usu">Usuario: </label></center></td>
            	<td><input style="width:280px; height: 35px;" type="text"" name="usuario"></td>
        	</tr>
        	<tr>
            	<td><label style="color:#d95e28" for = "pass">Contraseña: </label></td>
            	<td><input style="width:280px;height: 35px;" type="password" name="password"></td>
        	</tr>
    		</table>
    		<center>    	 
        		<input type="submit" class="registerbtn" name="btnlog" value="Aceptar">
        		<input type="button" class="registerbtn" name="btnCan" value="Cancelar">
        	</center>
        </div>
	</form>
</body>
</html>