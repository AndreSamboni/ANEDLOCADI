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
	<h1><img style='width: 80px; height: 60px' src="imgs/logo.png"><label><%=nombre %></label><label> - ${vs.getCiudad()}</label></h1>
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
<%
//double precio_compra=0.00, precio_venta=0.00;
String codproducto="", nombre_producto="",nit_proveedor="",iva_compra="", precio_compra="", precio_venta="";
if(request.getParameter("co")!=null){
codproducto=request.getParameter("co");
nombre_producto=request.getParameter("no");
nit_proveedor=request.getParameter("ni");
precio_compra=request.getParameter("pc");
iva_compra=request.getParameter("ic");
precio_venta=request.getParameter("pv");
}
%>
<form action="Servletproductos" method=POST enctype="multipart/form-data">
	<div style='position: absolute; z-index: 0; left: 330px;'>
		<h1></h1>
		<p></p>
		<hr style = "width: 900px;">
		<table>
				<tr>
				<td><label style="color:#d95e28"><b>Carga masiva de productos</b></label></td></tr>
		</table><br>
		<center><table>
				<tr>
				<td><label style="color:white" for="archivo"><b>Nombre del archivo</b></label><br><br>
			    <input style = "width: 270px;" type="file" value="" id="archivo" name="archivo"></td>
			    <td><button type="submit" class="registerbtn" name="cargar"value="add Archivo">Cargar</button></td>
			    </tr>
		</table></center><br><br>
		<hr style = "width: 900px;">
		<table>
				<tr>
				<td><label style="color:#d95e28"><b>Gestión individual de productos</b></label></td></tr>
		</table><br>
<center><table>
<tr>        
            <td>
			<label style="color:white"for="cedcli"><b>Cód. Producto</b></label><br>
			<input style="width: 120px;" type="text"placeholder="Ingrese código"name="cod_producto"value="<%=codproducto%>"id="co"required><br></td>
			<td>
			<label style="color:white"for="nombrecli"><b>Descripción producto</b></label><br>
			<input style="width: 280px;" type="text"placeholder="Ingrese descripción del producto"name="nombre_producto"value="<%=nombre_producto%>"id="no" ><br></td>
		    <td>
			<label style="color:white"for="dircli"><b>Nit Proveedor</b></label><br>
			<input style="width: 120px;" type="text"placeholder="Ingrese Nit"name="nit_proveedor"value="<%=nit_proveedor%>"id="ni" ><br></td>
			<td>
			<label style="color:white"for="telcli"><b>Precio compra</b></label><br>
			<input style="width: 120px;" type="text"placeholder="$ 0.00"name="precio_compra"value="<%=precio_compra%>"id="pc" ><br></td>
			<td>
			<label style="color:white"for="emailcli"><b>Iva compra</b></label><br>
			<input style="width: 80px;" type="text"placeholder="%"name="iva_compra"value="<%=iva_compra%>"id="ic" ><br></td>
			<td>
			<label style="color:white"for="emailcli"><b>Precio venta</b></label><br>
			<input style="width: 120px;" type="text"placeholder="$ 0.00"name="precio_venta"value="<%=precio_venta%>"id="pv" ><br></td>
</tr>
</table></center><br>
<hr style = "width: 900px;">
<tr><td>
		<center>
			<button type="submit" class="registerbtn" name="btncon">Consultar</button>
			<button type="submit" class="registerbtn" name="btnins">Crear</button>
			<button type="submit" class="registerbtn" name="btnact">Actualizar</button>
			<button type="submit" class="registerbtn" name="btneli">Borrar</button>
		</center>
</td></tr>
</div>
</form>  
</body>
</html>
