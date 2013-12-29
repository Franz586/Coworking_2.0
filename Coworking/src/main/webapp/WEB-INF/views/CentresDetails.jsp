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
<div style="color: teal;font-size: 30px">Centres coworking registrats</div>
<br><br>
<c:if test="${!empty model.centre_coworking}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: teal;color: white;text-align: center;" height="40px">
<td>Nom</td>
<td>Email</td>
<td>Web</td>
<td>Administrador</td>
</tr>
<c:forEach items="${model.centre_coworking}" var="centre">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${centre.nom}"/></td>
<td><c:out value="${centre.email}"/></td>
<td><c:out value="${centre.web}"/></td>
<td><c:out value="${centre.admin_centre.getemail()}"/></td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<a href="home.html" >Clic aqui per tornar a la pagina principal</a>
</center>
</body>
</html>