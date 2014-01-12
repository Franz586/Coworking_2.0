<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<title>Coworking 2.0 - Modificar Centre ${model.nom}</title>
<meta name="description" content="Página de Inicio en Coworking 2.0">

<style>
body {
	padding-top: 70px;
}
</style>

<!--  <link rel="stylesheet" href="resources/css/bootstrap.min.css"> -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">

</head>


<body>

<!-- Top Navbar! -->
        		
			<div class="navbar navbar-default navbar-fixed-top">  <!-- Brand and toggle get grouped for better mobile display -->

			<!-- Search Form -->
					<form action="cercarapida" method="get" class="navbar-form navbar-right">  					
					<div class="form-group">
						<input name="search" id="search" value="${model.textbox}" type="text" class="form-control" placeholder="Nom d'usuari o centre">
					</div>
					<button type="submit" class="btn btn-default">Cercar</button>
				</form>
			
			<!-- Titulo Izquierdo -->
				<div class = "container">
				  <div class="navbar-header">
				  	<!-- Botón para cuando la Barra se reduzca (RESPONSIVE DESIGN) -->
				    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
				      <span class="sr-only">Toggle navigation</span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				    </button>
				    <a class="navbar-brand" href="home.html">Coworking 2.0</a>
				  </div>
								  
				  <!-- Collect the nav links, forms, and other content for toggling -->
				  <div id ="userInfo" class="collapse navbar-collapse navHeaderCollapse">
				  <!-- Dentro de este Tag van las cosas a la izquierda (después de Coworking 2.0) -->
					
					<ul class="nav navbar-nav navbar-right">
					
						<c:choose>
							<c:when test="${loguejat}">
		    				<!-- Barra en caso de SI Logeado -->
					    	
							      	<li class = "dropdown">
							      		<a href="#" class = "dropdown-toggle" data-toggle = "dropdown">Solicituds<b class = "caret"></b></a>
							      		<ul class = "dropdown-menu">
							      			<li><a href = "#">Funcionalitat No Implementada</a></li>
										</ul>
									</li>
							    	<li class = "dropdown">
										<a href="#" class = "dropdown-toggle" data-toggle = "dropdown">Grups<b class = "caret"></b></a>
										<ul class = "dropdown-menu">
							      			<li><a href = "#">Funcionalitat No Implementada</a></li>
										</ul>
									</li>
							      	<li class = "dropdown" id="espais">
							      		<a href="#" class = "dropdown-toggle" data-toggle = "dropdown">Els meus Espais<b class = "caret"></b></a>
							      					
							      			<ul class = "dropdown-menu">						      		
								      		<c:forEach items="${centresAdministrats}" var="centre">
									      		<li>
									      			<a href = "mycenterprofile.html?centreId=${centre.idcentre}">${centre.nom}</a>
									      		</li>								      			
								      		</c:forEach>
								      		<li><a href = "registerCentre.html">Registrar Nou Centre</a></li>			
							      			</ul>			      		
							      	</li>
							    	<li class="active">
							    			<a href="myprofile.html">${loginname}</a>	  
							    	</li>
									    <form:form class="navbar-form navbar-left" id="logout" method="post" role="logout" action="logout">
									      <button type="submit" value="Logout" class="btn btn-default">Tanca Sessió</button>
									    </form:form>
							</c:when>
							<c:otherwise>
							<!-- Barra en caso de NO Logeado -->

								    <form:form class="navbar-form navbar-left form-inline" id="login" modelAttribute="usuari_registrat" method="post" action="${userLogin}" role="login">
								      <div class="form-group">
								        <form:input type="text" class="form-control" path="email" placeholder="Usuari"></form:input>
								      </div>
								      <div class="form-group">
								        <form:input type="password" class="form-control" path="contrasenya" placeholder="Contrasenya"></form:input>
								      </div>
								      <button type="submit" value="Login" class="btn btn-default">Iniciar Sessió</button>
								    </form:form>
								 								  
								    <!-- Registrarse NO ES UN LINK DEFINITIVO, POP-UP??-->
								    <a href="register.html" class="navbar-btn btn btn-default navbar-left">Registrar-se</a>
								    
							</c:otherwise>
						</c:choose>
							
				    </ul>
				  </div><!-- /.navbar-collapse -->
				</div>
		    <div class="row">
    				<div class="col-lg-11 col-xs-11">
						<a class="pull-right" href="cercaAvancada.html">Cerca Avançada</a>
					</div>
				</div>
				
		    </div>
	<br>
		
		
<!-- Contingut Central -->
 
<div id="content" class="container">

	<div class="jumbotron text-center">
	
			<div style="color: teal;font-size: 30px">Editar perfil del centre</div>
			<!--<c:url var="centreUpdate" value="updateCentre.html"/>-->
				<form:form id="updateForm" modelAttribute="centre_coworking" method="post" action="${centreUpdate}">
					<table class="table table-hover table-condensed" border="1">
					<tr>
						<td><form:label path="nom">Nom centre</form:label></td>
						<td><form:input data-msg-nom="Ha de ser un nom entre 3-10 caràcters"
										data-msg-required="Aquest camp és obligatori"
										data-rule-required="true" path="nom" value="${model.nom}"/></td>
					</tr>
						<form:hidden path="idcentre" value="${model.idcentre}" />
						<form:hidden path="admin_centre" value="${model.admin_centre}" />
						
						
					<tr>
						<td><form:label path="poblacio">Població</form:label></td>
						<td><form:select data-msg-poblacio="Ha de ser una població de les possibles"
										data-msg-required="Aquest camp és obligatori"
										data-rule-required="true" path="poblacio" items="${model.poblacio}"></form:select></td>
					</tr>
					<tr>
						<td><form:label path="descripcio">Descripció</form:label></td>
						<td><form:input data-msg-descripcio="Ha d'incloure una petita descripció"
										data-msg-required="Aquest camp és obligatori"
										data-rule-required="true" path="descripcio" value="${model.descripcio}"/></td>
					</tr>
					<tr>
						<td><form:label path="email">Email</form:label></td>
						<td><form:input data-msg-email="Ha de ser una direcció de correu vàlida"
										data-msg-required="Aquest camp és obligatori"
										data-rule-required="true" path="email" value="${model.email}"/></td>
					</tr>
					<tr>
						<td><form:label path="telefon">Teléfon</form:label></td>
						<td><form:input data-msg-telefon="Ha de ser un telèfon vàlid"
										data-msg-required="Aquest camp és obligatori"
										data-rule-required="true" path="telefon" value="${model.telefon}"/></td>
					</tr>
					<tr>
						<td><form:label path="capacitat">Nº de localitats</form:label></td>
						<td><form:input  path="capacitat" value="${model.capacitat}"/></td>
					</tr>
					<tr>
						<td><form:label path="carrer">Carrer</form:label></td>
						<td><form:input data-msg-carrer="Ha de ser un carrer existent"
										data-msg-required="Aquest camp és obligatori"
										data-rule-required="true" path="carrer" value="${model.carrer}"/></td>
					</tr>
					<tr>
						<td><form:label path="num_edifici">Nº d'edifici</form:label></td>
						<td><form:input  path="num_edifici" value="${model.num_edifici}"/></td>
					</tr>
					<tr>
						<td><form:label path="link_foto">Imatge de perfil (URL)</form:label></td>
						<td><form:input  path="link_foto" value="${model.link}"/></td>
					</tr>
					<tr>
						<td><form:label path="web">Web</form:label></td>
						<td><form:input  path="web" value="${model.web}"/></td>
					</tr>
					<tr>
						<td>Serveis</td>
						<td>
							<form:checkbox path="banys" label="Banys" checked="${model.banys}" value="true"/>
							<br>
						  	<form:checkbox path="cafeteria" label="Cafeteria" checked="${model.cafeteria}" value="true"/>
							<br>
							<form:checkbox path="internet" label="Internet" checked="${model.internet}" value="true"/>
							<br>
							<form:checkbox path="sala_reunions" label="Sala de reunions" checked="${model.sala}" value="true"/>
						</td>
						
					</tr>
					</table>
					
					<input type="submit" value="Finalitzar edició" />
				</form:form>
	</div>
</div>
	

<!-- Bottom Navbar! -->	
	
	<div class = "navbar navbar-inverse navbar-fixed-bottom">
		
		<a href="userList.html" class="navbar-btn btn btn-link pull-left">Llista BD Usuaris</a>
		<a href="centresList.html" class="navbar-btn btn btn-link pull-left">Llista BD Centres</a>
		
		<div class = "container">
		
			<p class = "navbar-text pull-left"><b>Mapa Web:</b></p>
			
			<a href="home.html" class = "navbar-btn btn btn-link pull-left">Inici</a>
			<a href="#" class = "navbar-btn btn btn-link pull-left">Que és Coworking?</a>
			<a href="#" class = "navbar-btn btn btn-link pull-left">Sobre Nosaltres</a>
			<a href="#" class = "navbar-btn btn btn-link pull-left">Contacte</a>
			
			<a class = "navbar-btn btn btn-danger pull-right">Google+</a>
			<a class = "navbar-btn btn btn-info pull-right">Twitter</a>
			<a class = "navbar-btn btn btn-primary pull-right">Facebook</a>
			
			<p class = "navbar-text pull-right"><b>Segueix-nos a:</b></p>	
		
		</div>
	</div>
	

<!-- Scripts siempre al final para que se cargue primero el contenido -->

	<!-- <script src="resources/js/bootstrap.min.js"></script>  -->
	<script src="<c:url value="resources/js/jquery-1.10.2.js"/>"></script>
	<script type="text/javascript" src="<c:url value="resources/js/jquery-1.10.2.js"/>"></script>
	<script src="//ajax.aspnetcdn.com/ajax/jQuery.validate/1.11.1/jquery.validate.js" type="text/javascript"></script>
	<script src="<c:url value="resources/js/bootstrap.js"/>"></script>
	<script src="<c:url value="resources/js/home.js"/>"></script>
	<script type="text/javascript">
		$("#updateForm").validate({
			showErrors: function(errorMap, errorList) {
			 
				// Clean up any tooltips for valid elements
				$.each(this.validElements(), function (index, element) {
					var $element = $(element);
					 
					$element.data("title", "") // Clear the title - there is no error associated anymore
					.removeClass("error")
					.tooltip("destroy");
				});
				 
				// Create new tooltips for invalid elements
				$.each(errorList, function (index, error) {
					var $element = $(error.element);
					 
					$element.tooltip("destroy") // Destroy any pre-existing tooltip so we can repopulate with new tooltip content
					.data("title", error.message)
					.addClass("error")
					.tooltip(); // Create a new tooltip based on the error messsage we just set in the title
				});
			},
			 
			submitHandler: function(form) {
				console.log("AJAX Update");
	            //var data = $("#updateForm").serializeObject();
	         	var data = {
	        			banys: document.getElementById('banys').checked,
	        		 	cafeteria: document.getElementById('cafeteria').checked,
	        			internet: document.getElementById('internet').checked,
	        			sala_reunions : document.getElementById('sala').checked,
	        			capacitat: $("#capacitat").val(),
	        			carrer: $("#carrer").val(),
	        			descripcio: $("#descripcio").val(),
	        			email: $("#email").val(),
	        			link_foto: $("#link_foto").val(),
	        			nom: $("#nom").val(),
	        			num_edifici: $("#num_edifici").val(),
	        			poblacio: $("#poblacio").val(),
	        			telefon: $("#telefon").val(),
	        			web: $("#web").val()
	
	            };
	            $.ajax({
	            	type: 'POST',
	                url: "updateCentre",
	                contentType: 'application/json',
	                data: JSON.stringify(data),
	                //dataType: 'json',
	                success: function(retorn) {
	                	console.log(retorn);
	                	var result = JSON.parse(retorn).result;                    	
	                	$(document.body).load("mycenterprofile.html?centreId=" + result, function(){
	                		$('.dropdown-toggle').dropdown();
	                	});
	                }
				});
	            return false;
			}
		});
		
		 $.fn.serializeObject = function() {
		        var o = {};
		        var a = this.serializeArray();
		        $.each(a, function() {
		            if (o[this.name]) {
		                if (!o[this.name].push) {
		                    o[this.name] = [o[this.name]];
		                }
		                o[this.name].push(this.value || '');
		            } else {
		                o[this.name] = this.value || '';
		            }
		        });
		        return o;
		    };
	</script>


</body>
</html>