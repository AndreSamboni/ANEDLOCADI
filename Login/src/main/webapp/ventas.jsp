<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="icon" href="logo.png">	
	<link rel="stylesheet" href="css/Styles.css">
	<title>Ventas</title>
</head>
<%
HttpSession objsesion=request.getSession();
String nombre=(String)objsesion.getAttribute("llevadato");
%>
<div style="background-color:#333333">
	<h1><label><%=nombre %></label></h1>
</div>
<div class="scrollmenu">
  <a href="Principal.jsp">Home</a>
  <a href="usuarios.jsp">Usuarios</a>
  <a href="clientes.jsp">Clientes</a>
  <a href="proveedores.jsp">Proveedores</a>
  <a href="productos.jsp">Productos</a>
  <a style= "background-color: #d95e28" href="ventas.jsp">Ventas</a>
  <a href="reportes.jsp">Reportes</a>
</div>
<body>
<form action="action_page.php">
	<div style= "left: 250px;" class="container">
		<h1></h1>
		<p></p>
		<hr style = "width: 1509px;">
			<table>
				<tr>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Cédula</b></label><br>
						<input style="width: 395px;" type="text" placeholder="Ingrese NIT" name="ProvTaxnumb" id="ProvTaxnumb">
						<button type="submit" class="registerbtn" name="btncns">Consultar</button>
					</td>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Cliente</b></label><br>
						<input type="text" placeholder="Ingrese NIT" name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Consec</b></label><br>
						<input style ="width: 230px" type="text" placeholder="Ingrese NIT" name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
				</tr>
				<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
				<tr>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Productos</b></label>
					</td>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Nombre de productos</b></label>
					</td>
					<td>
						<label style="color:white; width: 60px;" for="ProvTaxnumb"><b>Cant</b></label>
					</td>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Vlr. Total</b></label>
					</td>
				</tr>
				<tr>
					<td>
						<input style="width: 395px;" type="text" name="ProvTaxnumb" id="ProvTaxnumb">
						<button type="submit" class="registerbtn" name="btncns">Consultar</button>
					</td>
					<td>
						<input type="text"  name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
					<td>
						<input style="width: 60px;" type="text"  name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
				</tr>
				<tr>
					<td>
						<input style="width: 395px;" type="text" name="ProvTaxnumb" id="ProvTaxnumb">
						<button type="submit" class="registerbtn" name="btncns">Consultar</button>
					</td>
					<td>
						<input type="text" name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
					<td>
						<input style="width: 60px;" type="text"  name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
				</tr>
				<tr>
					<td>
						<input style="width: 395px;" type="text" name="ProvTaxnumb" id="ProvTaxnumb">
						<button type="submit" class="registerbtn" name="btncns">Consultar</button>
					</td>
					<td>
						<input type="text" name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
					<td>
						<input style="width: 60px;" type="text"  name="ProvTaxnumb" id="ProvTaxnumb">
					</td>
				</tr>
			</table>
		<hr style = "width: 1509px;">
		<center>
			<button type="submit" class="registerbtn" name="btncns">Consultar</button>
		</center>
  </div>
</form> 
</body>
</html>
