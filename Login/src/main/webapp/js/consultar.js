$(document).ready(function(){
	alert("json");
	
$.ajax({
  url: "Servletreportes",
  type:"POST",
  dataType: "json",
  success: function( result ) {
   console.log(result);    
  }
});

});