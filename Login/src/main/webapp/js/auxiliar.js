$(document).ready(function() {
   // alert("json");

    $('.btnconusu').on('click', function() {
        //alert("clic en el boton");
        consultarusuarios();

    });

    function consultarusuarios() {
        $.ajax({
            url: "Servletusuarios",
            type: "POST",
            dataType: "json",
            success: function(result) {
                console.log(result);
                let tabla1 = document.querySelector('#usu');
                console.log(tabla1);
                tabla1.innerHTML = "";
                tabla1.innerHTML = `<tr>
						<th>Cedula usuario</th>
    					<th>Nombre usuario</th>
    					<th>Email usuario</th>
    					<th>Usuario</th>
    					<th>Password</th>             
                       </tr>`;

                for (let i of result) {
                    tabla1.innerHTML += `<tr> <td>${i.cedusu}</td>
	                       <td>${i.nombreusu}</td>
						   <td>${i.emailusu}</td>
						   <td>${i.user}</td>
						   <td>${i.password}</td>
	                 </tr>`;
                }
            }
        });
    }

    $('.btnconcli').on('click', function() {
        //alert("clic en el boton");
        consultarclientes();


    });

    function consultarclientes() {
        $.ajax({
            url: "Servletclientes",
            type: "POST",
            dataType: "json",
            success: function(result) {
                console.log(result);
                let tabla2 = document.querySelector('#cli');
                console.log(tabla2);
                tabla2.innerHTML = "";
                tabla2.innerHTML = `<tr>
						<th>Cedula cliente</th>
    					<th>Nombre cliente</th>
    					<th>Direccion cliente</th>
    					<th>Telefono cliente</th>
    					<th>Email cliente</th>             
                       </tr>`;

                for (let i of result) {
                    tabla2.innerHTML += `<tr> <td>${i.cedcli}</td>
	                       <td>${i.nombrecli}</td>
						   <td>${i.dircli}</td>
						   <td>${i.telcli}</td>
						   <td>${i.emailcli}</td>
	                 </tr>`;
                }
            }
        });
    }

    $('.btnconvencli').on('click', function() {
        //alert("clic en el boton");
        consultarventas();
    });

    function consultarventas() {
        $.ajax({
            url: "Servletventas",
            type: "POST",
            dataType: "json",
            success: function(result) {
                console.log(result);
                let tabla3 = document.querySelector('#ven');
                console.log(tabla3);
                tabla3.innerHTML = "";
                tabla3.innerHTML = `<tr>
						<th>Codigo venta</th>
    					<th>Cedula cliente</th>
    					<th>Valor total ventas</th>            
                       </tr>`;

                for (let i of result) {
                    tabla3.innerHTML += `<tr> <td>${i.cod_venta}</td>
	                       <td>${i.cedula_cli}</td>
						   <td>${i.totalventa}</td>
	                 </tr>`;
                }
            }
        });
    }
});

function mostrarcli() {
    var usu = document.getElementById("usu");
    usu.style.display = "none";
var cli = document.getElementById("cli");
    cli.style.display = "block";
var ven = document.getElementById("ven");
    ven.style.display = "none";
    return true;
}
function mostrarusu() {
    var usu = document.getElementById("usu");
    usu.style.display = "block";
var cli = document.getElementById("cli");
    cli.style.display = "none";
var ven = document.getElementById("ven");
    ven.style.display = "none";
    return true;
}
function mostrarven() {
    var usu = document.getElementById("usu");
    usu.style.display = "none";
var cli = document.getElementById("cli");
    cli.style.display = "none";
var ven = document.getElementById("ven");
    ven.style.display = "block";
    return true;
}