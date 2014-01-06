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
<center>
Falta barra de login que me da error al copypastear el codigo html de la barra del home.jsp xD
</center>
		<br>
		<div style="margin-left:60px">
		<div style="color: teal; font-size: 30px">Perfil de ${model.nom}</div>
<img src="${model.link}" height="80" width="80">
<br>
<b>Descripció:</b> ${model.descripcio}
<br>
<b>Serveis del centre:</b>
<br> - ${model.serveis}
<br>
<b>Email de contacte:</b> ${model.email}
<br>
<b>Telefon:</b> ${model.telefon}
<br>
<b>Poblacio:</b> ${model.poblacio}
<br>
<b>Carrer:</b> ${model.carrer} <b>Nº Edifici:</b> ${model.num_edifici} 
<br>
<b>Nº de localitats:</b> ${model.capacitat}
<hr>
<b>Web:</b> ${model.web}
<br>
<b>Premium?:</b> ${model.premium}

<form action="editcenter.html" method="get">
		<input type="submit" value="Editar perfil">
</form>

</div>
</body>
</html>