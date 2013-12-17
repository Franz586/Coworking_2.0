<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuaris registrats</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Usuaris registrats</div>
<br><br>
<c:if test="${!empty model.llistat_usuaris}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: teal;color: white;text-align: center;" height="40px">
<td>Email</td>
<td>Contrasenya</td>
<td>Nom</td>
<td>Cognom</td>
<td>Ambit Professional</td>
</tr>
<c:forEach items="${model.llistat_usuaris}" var="usuari">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${usuari.email}"/></td>
<td><c:out value="${usuari.contrasenya}"/></td>
<td><c:out value="${usuari.nom}"/></td>
<td><c:out value="${usuari.cognom}"/></td>
<td><c:out value="${usuari.amb_prof}"/></td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<a href="register.html" >Clic aqui per afegir un nou usuari</a>
<br>
<a href="home.html" >Clic aqui per tornar a la pagina principal</a>
</center>
</body>
</html>