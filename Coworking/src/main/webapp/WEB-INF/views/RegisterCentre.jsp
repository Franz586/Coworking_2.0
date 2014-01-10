<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulari de registre</title>
</head>
<body>
<c:choose>
<c:when test="${model.loguejat}">
 <c:url var="userLogout" value="logout.html"/>
<form:form id="logoutForm" method="post" action="${userLogout}">
	<table style="width: 90px;" align="right">
		<tr>
			<td style="width: 115px; border-bottom-style: solid; border-top-style: solid; border-left-style: solid; border-right-style: solid">Loguejat com <i><b>${model.loginname}</b></i></td>
			<tr><td>
			<input type="submit" value="Logout" />
			</td></tr>
	</table>
	</form:form>
</c:when>
 <c:otherwise>
 <c:url var="userLogin" value="login.html"/>
	<form:form id="loginForm" modelAttribute="usuari_registrat" method="post" action="${userLogin}">
	<table style="width: 90px; color: Black; border-bottom-style: solid; border-top-style: solid; border-left-style: solid; border-right-style: solid" align="right">
	<tr>
		<td><form:label path="email">Usuari</form:label></td>
		<td><form:input  path="email"/></td>
	</tr>
	<tr>
		<td><form:label path="contrasenya">Contrasenya</form:label></td>
		<td><form:input  path="contrasenya"/></td>
		</tr>
			
<tr><td></td><td>
<input type="submit" value="Login" />
</td></tr>
			</table>
			</form:form>
	</c:otherwise>

</c:choose> 
	<center>
		<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Formulari registre de centre</div>
<br><br>
<c:url var="centreRegistration" value="saveCentre.html"/>
<form:form id="registerForm" modelAttribute="centre_coworking" method="post" action="${centreRegistration}">
<table width="400px" height="150px">
<tr>
<td><form:label path="nom">Nom centre</form:label></td>
<td><form:input  path="nom"/></td>
</tr>
<tr>
<td><form:label path="poblacio">Població</form:label></td>
<td><form:select  path="poblacio" items="${model.poblacio}"></form:select></td>
</tr>
<tr>
<td><form:label path="carrer">Carrer</form:label></td>
<td><form:input  path="carrer"/></td>
</tr>
<tr>
<td><form:label path="num_edifici">Nº d'edifici</form:label></td>
<td><form:input  path="num_edifici"/></td>
</tr>
<tr>
<td><form:label path="link_foto">Imatge de perfil (URL)</form:label></td>
<td><form:input  path="link_foto" value=""/></td>
</tr>
<tr>
<td><form:label path="descripcio">Descripció</form:label></td>
<td><form:input  path="descripcio"/></td>
</tr>
<tr>
<td><form:label path="email">Email</form:label></td>
<td><form:input  path="email"/></td>
</tr>
<tr>
<td><form:label path="telefon">Teléfon</form:label></td>
<td><form:input  path="telefon"/></td>
</tr>
<tr>
<td><form:label path="capacitat">Nº de localitats</form:label></td>
<td><form:input  path="capacitat"/></td>
<tr>
<td><form:label path="web">Web</form:label></td>
<td><form:input  path="web"/></td>
</tr>
<tr>
<td>Serveis</td>
<td>
<form:checkbox path="banys" label="Banys" value="true"/>
	<br>
  	<form:checkbox path="cafeteria" label="Cafeteria" value="true"/>
	<br>
	<form:checkbox path="internet" label="Internet" value="true"/>
	<br>
	<form:checkbox path="sala_reunions" label="Sala de reunions" value="true"/>
</td>
</tr>
<tr><td></td><td>
<input type="submit" value="Registrar centre" />
</td></tr>
</table>
</form:form>
<br>
<a href="userList.html" >Clic aqui per consultar la BD d'usuaris</a>
<br>
<a href="home.html" >Clic aqui per tornar a la pagina principal</a>
</center>
</body>
</html>