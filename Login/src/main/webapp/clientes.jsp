<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="icon" href="logo.png">
	<link rel="stylesheet" href="css/Styles.css">
	<title>Clientes</title>
</head>
<%
HttpSession objsesion=request.getSession();
String nombre=(String)objsesion.getAttribute("llevadato");
%>
<div style="background-color:#333333">
	<h1><img style='width: 80px; height: 60px' src="imgs/logo.png"><label><%=nombre %></label><label> - ${vs.getCiudad()}</label></h1>
</div>
<div class="scrollmenu">
  <a href="Principal.jsp">Home</a>
  <a href="usuarios.jsp">Usuarios</a>
  <a style= "background-color: #d95e28" href="clientes.jsp">Clientes</a>
  <a href="proveedores.jsp">Proveedores</a>
  <a href="productos.jsp">Productos</a>
  <a href="ventas.jsp">Ventas</a>
  <a href="reportes.jsp">Reportes</a>
</div>
<body>
<%
String cedcli="",nombrecli="",dircli="",telcli="",emailcli="";
if(request.getParameter("co")!=null){
cedcli=request.getParameter("co");
nombrecli=request.getParameter("no");
dircli=request.getParameter("dir");
telcli=request.getParameter("tel");
emailcli=request.getParameter("em");
}
%>
<form action="Servletclientes" method="POST">
	<div style='position: absolute; z-index: 0; left: 530px;'>
		<h1></h1>
		<p></p>
		<hr>
			<label style="color:white"for="cedcli"><b>Cédula</b></label><br>
			<input type="text"placeholder="Ingrese cédula"name="cedula_cli"value="<%=cedcli%>"id="cedcli"required><br>
			
			<label style="color:white"for="nombrecli"><b>Nombre completo</b></label><br>
			<input type="text"placeholder="Ingrese nombre completo"name="Nombre_cli"value="<%=nombrecli%>"id="nombrecli" ><br>
		
			<label style="color:white"for="dircli"><b>Dirección</b></label><br>
			<input type="text"placeholder="Ingrese dirección"name="direccion_cli"value="<%=dircli%>"id="dircli" ><br>
			
			<label style="color:white"for="telcli"><b>Teléfono</b></label><br>
			<input type="text"placeholder="Ingrese teléfono"name="Telefono_cli"value="<%=telcli%>"id="telcli" ><br>
			
			<label style="color:white"for="emailcli"><b>Correo electrónico</b></label><br>
			<input type="text"placeholder="Ingrese correo electrónico"name="email_cli"value="<%=emailcli%>"id="emailcli" ><br>
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
