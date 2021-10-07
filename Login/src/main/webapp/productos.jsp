<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="icon" href="logo.png">
	<link rel="stylesheet" href="css/Styles.css">
	<title>Productos</title>
</head>
<%
HttpSession objsesion=request.getSession();
String nombre=(String)objsesion.getAttribute("llevadato");
%>
<div style="background-color:#333333">
	<h1><img style='width: 80px; height: 60px' src="imgs/logo.png"><label><%=nombre %></label></h1>
</div>
<div class="scrollmenu">
  <a href="Principal.jsp">Home</a>
  <a href="usuarios.jsp">Usuarios</a>
  <a href="clientes.jsp">Clientes</a>
  <a href="proveedores.jsp">Proveedores</a>
  <a style= "background-color: #d95e28" href="productos.jsp">Productos</a>
  <a href="ventas.jsp">Ventas</a>
  <a href="reportes.jsp">Reportes</a>
</div>
<body>
<form action="Servletproductos" method=POST enctype="multipart/form-data">
	<div style='position: absolute; z-index: 0; left: 510px;'>
		<h1></h1>
		<p></p>
		<hr style = "width: 605px;">
			<label style="color:white" for="archivo"><b>Nombre del archivo</b></label><br><br>
			  <center><input style = "width: 500px;" type="file" value="" id="archivo" name="archivo"></center>
		<hr style = "width: 605px;">
		<center>
			<button type="submit" class="registerbtn" name="cargar"value="add Archivo">Cargar</button>
		</center>
  </div>
</form>  
</body>
</html>
