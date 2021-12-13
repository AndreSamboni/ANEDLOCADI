<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
      <script type="text/javascript" src="js/auxiliar.js"></script>
      <link rel="icon" href="logo.png">
      <link rel="stylesheet" href="css/Styles.css">
      <title>Reportes</title>
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
      <a href="productos.jsp">Productos</a>
      <a href="ventas.jsp">Ventas</a>
      <a style= "background-color: #d95e28" href="reportes.jsp">Reportes</a>
   </div>
   <body>
      <br><br>
      <form action="" method="">
         <center> 
            <input style="background-color: #04AA6D; color: white; padding: 11px 15px; margin: 3px 0; border: none;  cursor: pointer;  width: 140px;  opacity: 0.9" type="button" class="btnconusu" name="btnconusu" value="Listado de usuarios" onclick="mostrarusu();">
            <input style="background-color: #04AA6D; color: white; padding: 11px 15px; margin: 3px 0; border: none;  cursor: pointer;  width: 140px;  opacity: 0.9" type="button" class="btnconcli" name="btnconcli" value="Listado de clientes" onclick="mostrarcli();">
            <input style="background-color: #04AA6D; color: white; padding: 11px 15px; margin: 3px 0; border: none;  cursor: pointer;  width: 140px;  opacity: 0.9" type="button" class="btnconvencli" name="btnconvencli" value="Ventas por cliente" onclick="mostrarven();">
         </center>
      </form>
      <br><br><br>
      <table  id="usu" class="tableRepor" style="display:none; margin: 0 auto">
      <table  id="cli" class="tableRepor" style="display:none; margin: 0 auto">
      <table  id="ven" class="tableRepor1" style="display:none; margin: 0 auto">
   </body>
</html>