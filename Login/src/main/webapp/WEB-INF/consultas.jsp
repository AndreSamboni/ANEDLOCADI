<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="icon" href="logo.png">
	<link rel="stylesheet" href="css/Styles.css">
	<title>Proveedores</title>
</head>
<div style="background-color:#333333">
	<h1>Bienvenido</h1>
</div>
<div class="scrollmenu">
  <a href="Principal.jsp">Home</a>
  <a href="usuarios.jsp">Usuarios</a>
  <a href="clientes.jsp">Clientes</a>
  <a style= "background-color: #d95e28" href="proveedores.jsp">Proveedores</a>
  <a href="productos.jsp">Productos</a>
  <a href="ventas.jsp">Ventas</a>
  <a href="reportes.jsp">Reportes</a>
</div>
<body>
<%
String nitprov="",nombreprov="",direccionprov="",telefonoprov="",ciudadprov="";
if(request.getParameter("co")!=null){
nitprov=request.getParameter("co");
nombreprov=request.getParameter("nom");
direccionprov=request.getParameter("dir");
telefonoprov=request.getParameter("tel");
ciudadprov=request.getParameter("ciu");
}
%>
<form action="Servletproveedores" method=POST>
	<div style='position: absolute; z-index: 0; left: 530px;'>
		<h1></h1>	
		<p></p>
		<hr>
			<label style="color:white" for="nitprov"><b>NIT</b></label><br>
			<input type="text" placeholder="Ingrese NIT" name="nit_proveedor"value="<%=nitprov%>" id="nitprov" required><br>
			
			<label style="color:white" for="nombreprov"><b>Nombre completo</b></label><br>
			<input type="text" placeholder="Ingrese nombre completo" name="nombre_prov"value="<%=nombreprov%>" id="nombreprov" ><br>
		
			<label style="color:white" for="direccionprov"><b>Dirección</b></label><br>
			<input type="text" placeholder="Ingrese dirección" name="direccion_prov"value="<%=direccionprov%>" id="direccionprov" ><br>
			
			<label style="color:white" for="telefonoprov"><b>Teléfono</b></label><br>
			<input type="text" placeholder="Ingrese teléfono" name="telefono_prov"value="<%=telefonoprov%>" id="telefonoprov" ><br>
			
			<label style="color:white" for="ciudadprov"><b>Ciudad</b></label><br>
			<input type="text" placeholder="Ingrese ciudad" name="ciudad_prov"value="<%=ciudadprov%>" id="ciudadprov" ><br>
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