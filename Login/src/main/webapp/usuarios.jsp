<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="icon" href="logo.png">
	<link rel="stylesheet" href="css/Styles.css">
	<title>Usuarios</title>
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
  <a style= "background-color: #d95e28" href="usuarios.jsp">Usuarios</a>
  <a href="clientes.jsp">Clientes</a>
  <a href="proveedores.jsp">Proveedores</a>
  <a href="productos.jsp">Productos</a>
  <a href="ventas.jsp">Ventas</a>
  <a href="reportes.jsp">Reportes</a>
</div>
<body>
<%
String cedusu="",nombreusu="",emailusu="",user="",password="";
if(request.getParameter("co")!=null){
cedusu=request.getParameter("co");
nombreusu=request.getParameter("no");
emailusu=request.getParameter("eu");
user=request.getParameter("us");
password=request.getParameter("pa");
}
%>
<form action="Servletusuarios" method="POST">
	<div style='position: absolute; z-index: 0; left: 530px;'>
		<h1></h1>
		<p></p>
		<hr>
			<label style="color:white"for="cedusu"><b>Cédula</b></label><br>
			<input type="text"placeholder="Ingrese cédula"name="cedula_usu"value="<%=cedusu%>"id="cedusu"required><br>
			
			<label style="color:white"for="nombreusu"><b>Nombre completo</b></label><br>
			<input type="text"placeholder="Ingrese nombre completo"name="nombre_usu"value="<%=nombreusu%>"id="nombreusu"><br>
			
			<label style="color:white"for="emailusu"><b>Correo electrónico</b></label><br>
			<input type="text"placeholder="Ingrese correo electrónico"name="email_usu"value="<%=emailusu%>"id="emailusu"><br>
		
			<label style="color:white"for="user"><b>Usuario</b></label><br>
			<input type="text"placeholder="Ingrese usuario"name="usuario"value="<%=user%>"id="user"><br>
			
			<label style="color:white"for="password"><b>Contraseña</b></label><br>
			<input type="password"placeholder="Ingrese contraseña"name="password"value="<%=password%>"id="password"><br>
		<hr>
		<center>
			<button type="submit" class="registerbtn" name="btncon">Consultar</button>
			<button type="submit" class="registerbtn" name="btnins">Crear</button>
			<button type="submit" class="registerbtn" name="btnact">Actualizar</button>
			<button type="submit" class="registerbtn" name="btneli">Borrar</button>
		</center>
  </div>
</form> 
</body>
</html>
