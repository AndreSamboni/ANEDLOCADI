<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="icon" href="logo.png">
	<link rel="stylesheet" href="css/Styles.css">
	<title>Reportes</title>
</head>
<%
HttpSession objsesion=request.getSession();
String nombre=(String)objsesion.getAttribute("llevadato");
%>
<div style="background-color:#333333">
	<h1><img style='width: 80px; height: 60px' src="imgs/logo.png"><label><%=nombre %></label></h1>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
</div>
<div class="scrollmenu">
  <a href="Principal.jsp">Home</a>
  <a href="usuarios.jsp">Usuarios</a>
  <a href="clientes.jsp">Clientes</a>
  <a href="proveedores.jsp">Proveedores</a>
  <a href="productos.jsp">Productos</a>
  <a href="ventas.jsp">Ventas</a>
  <a style= "background-color: #d95e28" href="reportes.jsp">Reportes</a>
</div>
<body>
<br><br>
<table style="float: left">
  <tr>
    <th><button type="button" class="registerbtn2" name="btnconusu">Listado de usuarios</button></th>
  </tr>
  <tr>
    <th><button type="button" class="registerbtn2" name="btnconcli">Listado de clientes</button></th>
  </tr>
  <tr>
    <th><button type="button" class="registerbtn2" name="btnconvencli">Ventas por Cliente</button></th>
  </tr>
</table>
<br>
<center>
<table  class="tableRepor" name="ola"  border="1">
  <tr>
    <th>Cedula usuario</th>
    <th>Nombre usuario</th>
    <th>Email usuario</th>
    <th>Usuario</th>
    <th>Password</th>
  </tr>
  <tr>
    <td>123456789</td>
    <td>12345</td>
    <td>123.555.789</td>
    <td>John Johnny</td>
    <td>johnny@example.com</td>
  </tr>
</center>
</div>
</body>
</html>
