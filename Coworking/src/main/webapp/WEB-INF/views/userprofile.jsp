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


		<br>
		<div style="margin-left:60px">
		<div style="color: teal; font-size: 30px">Perfil d'usuari</div>
<img src="${model.link}" height="80" width="80">
<br>
<b>Nom y Cognoms:</b> ${model.nom}&nbsp;${model.cognom}
<br>
<b>Ambit professional:</b> ${model.ambit}
<br>
<c:if test="${model.privacitat=='NO'}">
<b>Email de contacte:</b> ${model.email}
<br>
<b>Data de naixament:</b> ${model.data_naix}
<br>
<b>Telefon:</b> ${model.telefon}
<br>
<b>Informació sobre mi:</b> ${model.sobre_mi}
<hr>
</c:if>
<b>Web:</b> ${model.web}
<br>
<br>
<c:if test="${model.privacitat=='NO'}">
Perfil public
</c:if>
</div>
</body>
</html>