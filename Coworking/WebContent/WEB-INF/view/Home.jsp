<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		
	<div style="color: teal;font-size: 30px">Pàgina principal</div>
	<br><br>
	<c:choose>
<c:when test="${model.loguejat}">
 <div style="color: teal;font-size: 20px"><p align="left">Menu usuari</p></div>
<form:form id="menuForm">
	<table style="width: 200px;" align="left">
	
		<tr>
			<td style="width: 200px; border-bottom-style: solid; border-top-style: solid; border-left-style: solid; border-right-style: solid"><a href="registerCentre.html" >Registrar centre coworking</a></td>
			
	</table>
	</form:form>
</c:when>
</c:choose>
<br><br>
	<a href="register.html" >Clic aqui per registrar-te</a>
	<br>
	<a href="userList.html" >Clic aqui per consultar la BD d'usuaris</a>
	<br>
	<a href="centresList.html" >Clic aqui per consultar la BD de centres</a>
</center>
</body>
</html>