<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/Styles.css">
	<title>Home</title>
</head>
<%
HttpSession objsesion=request.getSession();
String nombre=(String)objsesion.getAttribute("llevadato");
%>
<div style="background-color:#333333">
	<h1>Bienvenido <label><%=nombre %></label></h1>

<!--<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>-->
</div>
<div class="scrollmenu">
  <a style= "background-color: #d95e28" href="Principal.jsp">Home</a>
  <a href="usuarios.jsp">Usuarios</a>
  <a href="clientes.jsp">Clientes</a>
  <a href="proveedores.jsp">Proveedores</a>
  <a href="productos.jsp">Productos</a>
  <a href="ventas.jsp">Ventas</a>
  <a href="reportes.jsp">Reportes</a>
</div>
<body>
</body>
</html>