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
	<center>
		<br><br>
<div style="color: teal;font-size: 30px">Formulari de registre</div>
<br><br>
<c:url var="userRegistration" value="saveUser.html"/>
<form:form id="registerForm" modelAttribute="usuari_registrat" method="post" action="${userRegistration}">
<table width="400px" height="150px">
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
<tr><td></td><td>
<input type="submit" value="Registrar-se" />
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