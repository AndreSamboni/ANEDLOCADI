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
<center>
<form action="Servletreportes" method="POST">	
<input type="button" class="registerbtn" name="btncon">Listado de usuarios</button>
</form>

<form action="" method="">	
<input type="button" class="registerbtn" name="btncon">Listado de clientes</button>
</form>

<form action="" method="">		
<input type="button" class="registerbtn" name="btncon">Ventas por Cliente</button>
</form>
</center> 
</body>
</html>
