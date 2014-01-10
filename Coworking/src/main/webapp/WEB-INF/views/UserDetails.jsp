<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<div id="content" class="container">

	<div class="jumbotron text-center">

		<div style="color: teal;font-size: 30px">Usuaris registrats</div>
		<c:if test="${!empty model.llistat_usuaris}">
			<table class="table table-hover table-condensed" border="1">
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
	
	</div>

</div>