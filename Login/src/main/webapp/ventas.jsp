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
	<h1><img style='width: 80px; height: 60px' src="imgs/logo.png"><label><%=nombre %></label></h1>
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
<form action="Servletventas" method=POST>
	<div style= "left: 285px;" class="container">
		<h1></h1>
		<p></p>
		<hr style = "width: 1240px;">
			<table>
				<tr>
					<td>
						<label style="color:white"><b>Cédula</b></label><br>
						<input style="width: 395px;" type="text" placeholder="Ingrese cédula" name=cedula_cli value="${cliente.getCedcli()}">
						<input type="submit" class="registerbtn" name="confirmar">
					</td>
					<td>
						<label style="color:white"><b>Nombre del Cliente</b></label><br>
						<input type="text" name="nombre" value="${cliente.getNombrecli()}">
					</td>
					<td>
					</td>
					<td>
						<label style="color:white"><b>Cód. Venta</b></label><br>
						<input style ="width: 160px" type="text" name="cod_venta" value="">
					</td>
				</tr>
				<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
				<tr>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Cód. Producto</b></label>
					</td>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Nombre del producto</b></label>
					</td>
					<td>
						<label style="color:white; width: 60px;" for="ProvTaxnumb"><b>Cant.</b></label>
					</td>
					<td>
						<label style="color:white" for="ProvTaxnumb"><b>Precio del producto</b></label>
					</td>
				</tr>
				<tr>
					<td>
						<input style="width: 395px;" type="text" placeholder="Ingrese código producto 1" name="cod_producto" value="${producto.getCodproducto()}">
						<input type="submit" class="registerbtn" name="conpro" value="Consultar">
					</td>
					<td>
						<input type="text" class="nombre" name="n2" value="${producto.getNombre_producto()}">
					</td>
					<td>
						<input style="width: 60px;" type="text" class="cantidad" id="cantidad" name="can">
					</td>
					<td>
						<input style="width: 160px;" type="text" class="pre" id="pre" name="precio" value="${producto.getPrecio_venta()}">
					</td>
				</tr>
				<tr>
					<td>
						<input style="width: 395px;" type="text" placeholder="Ingrese código producto 2" name="codigo1" value="${producto1.getCodproducto()}">
						<input type="submit" class="registerbtn" name="conpro1" value="Consultar">
					</td>
					<td>
						<input type="text" class="nombre" name="n2" value="${producto1.getNombre_producto()}">
					</td>
					<td>
						<input style="width: 60px;" type="text" class="cantidad1" id="cantidad1" name="can1">
					</td>
					<td>
						<input style="width: 160px;" type="text" class="pre"  id="pre1" name="precio1" value="${producto1.getPrecio_venta()}">
					</td>
				</tr>
				<tr>
					<td>
						<input style="width: 395px;" type="text" placeholder="Ingrese código producto 3" name="codigo2" value="${producto2.getCodproducto()}">
						<input type="submit" class="registerbtn" name="conpro2" value="Consultar">
					</td>
					<td>
						<input type="text" class="nombre" name="n2" value="${producto2.getNombre_producto()}">
					</td>
					<td>
						<input style="width: 60px;" type="text" class="cantidad2" id="cantidad2" name="can2">
					</td>
					<td>
						<input style="width: 160px;" type="text" class="pre"  id="pre2" name="precio2" value="${producto2.getPrecio_venta()}">
					</td>
				</tr>
			</table>
		<hr style = "width: 1240px;">
		<center>
			<tr><td class="ult" colspan="5">
				<input type="submit" class="registerbtn" name="valor_total" value="Enviar Venta">
			</td></tr>
</tbody>
    
</table>
<input style='width: 130px; height: 47px' type="text" placeholder="Cédula usuario" name="cu" value="${vs.getCedusu()}">
			</td></tr>
		</center>
  </div>
</form> 
</body>
</html>
