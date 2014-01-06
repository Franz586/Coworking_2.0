<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<title>Home - Coworking 2.0</title>
<meta name="description" content="Página de Inicio en Coworking 2.0">

<style>
body {
	padding-top: 70px;
}
</style>

<!--  <link rel="stylesheet" href="resources/css/bootstrap.min.css"> -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet">

</head>


<body>

<!-- TOP NAVBAR -->
        
    <c:choose>
		<c:when test="${model.loguejat}">
		    <!-- Barra en caso de SI Logeado -->
		
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">  <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header">
			    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			      <span class="sr-only">Toggle navigation</span>
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>
			    </button>
			    <a class="navbar-brand" href="#">Coworking 2.0</a>
			  </div>
			
			  <!-- Collect the nav links, forms, and other content for toggling -->
			  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    <ul class="nav navbar-nav">
			      <li class="active"><a href="myprofile.html">Perfil</a></li>
			      <li><a href="mycentres.html">Els meus Centres</a></li>
			    </ul>
				
				<ul class="nav navbar-nav navbar-right">
			    	<c:url var="userLogout" value="logout.html" />
					    <form:form class="navbar-form navbar-left" id="logoutForm" method="post" action="${userLogout}">
					      <div class="form-group">
					        <label>Loguejat com <i><b>${model.loginname}</b></i>.</label>
					      </div>
					      <button type="submit" value="Logout" class="btn btn-default">Tanca Sessió</button>
					    </form:form>
			    </ul>
			  </div><!-- /.navbar-collapse -->
		    </nav>
		</c:when>

		<c:otherwise>
			<!-- Barra en caso de NO Logeado -->
			
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">  <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header">
			    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			      <span class="sr-only">Toggle navigation</span>
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>
			    </button>
			    <a class="navbar-brand" href="#">Coworking 2.0</a>
			  </div>
			
			  <!-- Collect the nav links, forms, and other content for toggling -->
			  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">	
			    <ul class="nav navbar-nav navbar-right">
			    	<c:url var="userLogin" value="login.html" />
					    <form:form class="navbar-form navbar-left" id="loginForm" modelAttribute="usuari_registrat" method="post" action="${userLogin}" role="login">
					      <div class="form-group">
					        <form:input type="text" class="form-control" path="email" placeholder="Usuari"></form:input>
					      </div>
					      <div class="form-group">
					        <form:input type="password" class="form-control" path="contrasenya" placeholder="Contrassenya"></form:input>
					      </div>
					      <button type="submit" value="Login" class="btn btn-default">Inicia Sessió</button>
					    </form:form>
			    </ul>
			  </div><!-- /.navbar-collapse -->
		    </nav>
		    
		</c:otherwise>
		
	</c:choose>
 
 	<center>
	<div style="color: teal;font-size: 30px">Editar perfil del centre</div>
<br><br>

<c:url var="centreUpdate" value="updateCentre.html"/>
<form:form id="updateForm" modelAttribute="centre_coworking" method="post" action="${centreUpdate}">
<table width="400px" height="150px" style="border-bottom-style: solid; border-top-style: solid; border-left-style: solid; border-right-style: solid">
<tr>
<td><form:label path="nom">Nom centre</form:label></td>
<td><form:input  path="nom" value="${model.nom}"/></td>
</tr>
<form:hidden path="idcentre" value="${model.idcentre}" />
<form:hidden path="admin_centre" value="${model.admin_centre}" />
<tr>
<td><form:label path="poblacio">Població</form:label></td>
<td><form:select  path="poblacio" items="${model.poblacio}"></form:select></td>
</tr>
<tr>
<td><form:label path="descripcio">Descripció</form:label></td>
<td><form:input  path="descripcio" value="${model.descripcio}"/></td>
</tr>
<tr>
<td><form:label path="email">Email</form:label></td>
<td><form:input  path="email" value="${model.email}"/></td>
</tr>
<tr>
<td><form:label path="telefon">Teléfon</form:label></td>
<td><form:input  path="telefon" value="${model.telefon}"/></td>
</tr>
<tr>
<td><form:label path="capacitat">Nº de localitats</form:label></td>
<td><form:input  path="capacitat" value="${model.capacitat}"/></td>
</tr>
<tr>
<td><form:label path="carrer">Carrer</form:label></td>
<td><form:input  path="carrer" value="${model.carrer}"/></td>
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
<tr><td></td><td>
<input type="submit" value="Finalitzar edició" />
</td></tr>
</table>
</form:form>
</center>
	

	<!-- Scripts siempre al final para que se cargue primero el contenido -->

	<!-- <script src="resources/js/bootstrap.min.js"></script>  -->
	<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="http://twitter.github.com/bootstrap/assets/js/bootstrap-dropdown.js"></script>
	<script src="resources/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>


</body>
</html>