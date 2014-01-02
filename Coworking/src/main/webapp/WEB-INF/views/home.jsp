<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
	<title>Home - Coworking 2.0</title>
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

<!-- TOP NAVBAR -->
        		
			<nav class="navbar navbar-default navbar-fixed-top">  <!-- Brand and toggle get grouped for better mobile display -->
				<div class = "container">
				  <div class="navbar-header">
				  	<!-- Botón para cuando la Barra se reduzca (RESPONSIVE DESIGN) -->
				    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
				      <span class="sr-only">Toggle navigation</span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				    </button>
				    <a class="navbar-brand" href="#">Coworking 2.0</a>
				  </div>
								  
				  <!-- Collect the nav links, forms, and other content for toggling -->
				  <div class="collapse navbar-collapse navHeaderCollapse">
				  <!-- Dentro de este Tag van las cosas a la izquierda (después de Coworking 2.0) -->
					
					<ul class="nav navbar-nav navbar-right">
					
						<c:choose>
							<c:when test="${loguejat}">
		    				<!-- Barra en caso de SI Logeado -->
							    	<c:url var="userLogout" value="logout.html" />
							    	
							      	<li class = "dropdown">
							      		<a href="#" class = "dropdown-toggle" data-toggle = "dropdown">Solicituds<b class = "caret"></b></a>
									</li>
							    	<li class = "dropdown">
										<a href="#" class = "dropdown-toggle" data-toggle = "dropdown">Grups<b class = "caret"></b></a>
									</li>
							      	<li class = "dropdown" id="espais">
							      		<a href="#" class = "dropdown-toggle" data-toggle = "dropdown">Els meus Espais<b class = "caret"></b></a>
							      					
							      				<ul class = "dropdown-menu">						      		
							      		<c:forEach items="${centresAdministrats}" var="centre">
								      		
								      			<li><a href = "#">${centre.nom}</a></li>
								      			
								      		
							      		</c:forEach>   	
							      				
							      				<li><a href = "#">Espai Estàtic</a></li>
								      			<li><a href = "registerCentre.html">Registrar Nou Centre</a></li>			
							      				</ul>			      		
							      	</li>
							    	<li class="active">
							    			<a href="myprofile.html">${loginname}</a>
							  
							    	</li>
									    <form:form class="navbar-form navbar-left" id="logoutForm" method="post" action="${userLogout}">
									      <button type="submit" value="Logout" class="btn btn-default">Tanca Sessió</button>
									    </form:form>
							</c:when>
							<c:otherwise>
							<!-- Barra en caso de NO Logeado -->
									<c:url var="userLogin" value="login.html" />
				 				 	<!-- TRATAR CASO DE LOGIN ERRONEO CON AJAX!!!! -->
				 				 	
				 				 	<!-- Log In -->
								    <form:form class="navbar-form navbar-left" id="loginForm" modelAttribute="usuari_registrat" method="post" action="${userLogin}" role="login">
								      <div class="form-group">
								        <form:input type="text" class="form-control" path="email" placeholder="Usuari"></form:input>
								      </div>
								      <div class="form-group">
								        <form:input type="password" class="form-control" path="contrasenya" placeholder="Contrasenya"></form:input>
								      </div>
								      <button type="submit" value="Login" class="btn btn-default">Iniciar Sessió</button>
								    </form:form>
								    
								    <!-- Registrarse NO ES UN LINK DEFINITIVO, POP-UP??-->
								    <button type="submit" class="btn btn-default" onclick="location.href='register.html';">Registrar-se</button>
								    
							</c:otherwise>
						</c:choose>
							
				    </ul>
				  </div><!-- /.navbar-collapse -->
				</div>
		    </nav>
		
		 
 
	<center>
		<br> <br> <br> <br> <br> <br>

		<div style="color: teal; font-size: 30px">Pàgina principal</div>
		<br> <br>
	
		<br> <br> <a href="register.html">Clic aqui per
			registrar-te</a> <br> <a href="userList.html">Clic aqui per
			consultar la BD d'usuaris</a> <br> <a href="centresList.html">Clic
			aqui per consultar la BD de centres</a>
	</center>
	
	

	<!-- Scripts siempre al final para que se cargue primero el contenido -->

	<!-- <script src="resources/js/bootstrap.min.js"></script>  -->
	<script src="<c:url value="resources/js/jquery-1.10.2.js"/>"></script>
	<script type="text/javascript" src="<c:url value="resources/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="resources/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="http://twitter.github.com/bootstrap/assets/js/bootstrap-dropdown.js"></script>
	<script src="<c:url value="resources/js/home.js"/>"></script>
	
</body>
</html>