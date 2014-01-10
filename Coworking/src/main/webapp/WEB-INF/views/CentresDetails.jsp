<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="content" class="container">

	<div class="jumbotron text-center">

		<div style="color: teal;font-size: 30px">Centres coworking registrats</div>
		<c:if test="${!empty model.centre_coworking}">
			<table class="table table-hover table-condensed" border="1">
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

	</div>
	
</div>