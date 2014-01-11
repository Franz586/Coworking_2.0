<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<title>Coworking 2.0 - Registrar Usuari</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
	body {
		padding-top: 70px;
	}
</style>

<!--  <link rel="stylesheet" href="resources/css/bootstrap.min.css"> -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	type="text/css" rel="stylesheet">

</head>
<body>

<!-- Top Navbar! -->
        		
			<div class="navbar navbar-default navbar-fixed-top">  <!-- Brand and toggle get grouped for better mobile display -->

			<!-- Search Form -->
					<form action="cercarapida" method="get" class="navbar-form navbar-right">  					
					<div class="form-group">
						<input name="search" id="search" value="${model.textbox}" type="text" class="form-control">
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
									    <form:form class="navbar-form navbar-left" id="logout" method="post" action="${userLogout}">
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


<!-- Central Content! -->

<div id="content" class="container">

	<div class="jumbotron text-center">
	
			<div style="color: teal;font-size: 30px">Formulari de registre</div>
			<c:url var="userRegistration" value="saveUser.html"/>
			
				<form:form id="registerForm" modelAttribute="usuari_registrat" method="post" action="${userRegistration}">
					<table class="table table-hover table-condensed" border="1">
					<tr>
						<td><form:label path="email">Email</form:label></td>
						<td><form:input  path="email"/></td>
					</tr>
					<tr>
						<td><form:label path="contrasenya">Contrasenya</form:label></td>
						<td><form:input  path="contrasenya"/></td>
					</tr>
					<tr>
						<td><form:label path="dni">DNI</form:label></td>
						<td><form:input  path="dni"/></td>
					</tr>
					<tr>
						<td><form:label path="nom">Nom</form:label></td>
						<td><form:input  path="nom"/></td>
					</tr>
					<tr>
						<td><form:label path="cognom">Cognom</form:label></td>
						<td><form:input  path="cognom"/></td>
					</tr>
					<tr>
						<td><form:label path="data_naix">Data de naixement</form:label></td>
						<td><form:input  path="data_naix"/></td>
					</tr>
					<tr>
						<td><form:label path="adreca">Adreça</form:label></td>
						<td><form:input  path="adreca"/></td>
					</tr>
					<tr>
						<td><form:label path="link_foto">Imatge de perfil (URL)</form:label></td>
						<td><form:input  path="link_foto" value=""/></td>
					</tr>
					<tr>
						<td><form:label path="telefon">Teléfon</form:label></td>
						<td><form:input  path="telefon"/></td>
					</tr>
					<tr>
						<td><form:label path="privacitat">Perfil privat?</form:label></td>
						<td><form:select  path="privacitat" items="${model.privacitat}"></form:select></td>
					</tr>
					<tr>
						<td><form:label path="premium">Premium?</form:label></td>
						<td><form:select  path="premium" items="${model.privacitat}"></form:select></td>
					</tr>
					<tr>
						<td><form:label path="amb_prof">Àmbit professional</form:label></td>
						<td><form:select path="amb_prof" items="${model.ambit}"></form:select></td>
					</tr>
					<tr>
						<td><form:label path="web">Lloc web</form:label></td>
						<td><form:input  path="web"/></td>
					</tr>
						<tr>
						<td><form:label path="sobre_mi">Informació sobre mi</form:label></td>
						<td><form:input  path="sobre_mi"/></td>
					</tr>
					</table>
					
				<input type="submit" value="Registrar-se" />
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
	<script src="<c:url value="resources/js/bootstrap.js"/>"></script>
	<script src="<c:url value="resources/js/home.js"/>"></script>
	
</body>
</html>