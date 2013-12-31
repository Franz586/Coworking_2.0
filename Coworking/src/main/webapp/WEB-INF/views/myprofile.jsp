<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<title>Perfil - Coworking 2.0</title>
<meta name="description" content="Página de Perfil en Coworking 2.0">

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

		<br>
		<div style="margin-left:60px">
		<div style="color: teal; font-size: 30px">El meu perfil</div>
<img src="http://www.fashionally.com/images/default_profile_pic.jpg" height="80" width="80">
<br>
<b>Nom y Cognoms:</b> ${model.nom}&nbsp;${model.cognom}
<br>
<b>DNI:</b> ${model.dni}
<br>
<b>Ambit professional:</b> ${model.ambit}
<br>
<b>Email de contacte:</b> ${model.email}
<br>
<b>Data de naixament:</b> ${model.data_naix}
<br>
<b>Telefon:</b> ${model.telefon}
<br>
<b>Informació sobre mi:</b> ${model.sobre_mi}
<hr>

<b>Web:</b> ${model.web}
<br>
<b>Perfil privat?:</b> ${model.privacitat}
<br>
<b>Premium?:</b> ${model.premium}
<form action="editprofile.html" method="get">
		<input type="submit" value="Editar perfil">
	</form>
</div>
</body>
</html>