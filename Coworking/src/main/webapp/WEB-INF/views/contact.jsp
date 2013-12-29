<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Spring MVC and Ajax : Contact</title>

		<link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
		
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		
		<script src="<c:url value="/resources/js/contact.js"/>"></script>

	</head>

<body>

	<div id="container">
		<h2>Find Contact By Name</h2>
		
		<h2>Submit new Contact</h2>
		<form id="saveContact">
			<div>
				<label for="firstNameInput">First Name:</label>
				<input type="text" name="firstName" id="firstNameInput" />
			</div>
			<div>
				<label for="lastNameInput">Last Name:</label>
				<input type="text" name="lastName" id="lastNameInput" />
			</div>
			<div>
				<label for="ageInput">Age:</label>
				<input type="text" name="age" id="ageInput" style="width: 37px; "/>
			</div>
			
			<div><input id="submit" type="submit" value="Save Contact"></div>
		</form>
	
		<br><br>
		<h2>Table Contact</h2>
		<table id="contactTableResponse" class="table tr">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th scope="row">Spring-Ajax</th>
					<td colspan="4">JQuery Ajax</td>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.id}</td>
						<td>${contact.firstName}</td>
						<td>${contact.lastName}</td>
						<td>${contact.age}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>

</html>