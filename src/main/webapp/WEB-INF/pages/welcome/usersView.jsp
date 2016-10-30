<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>


<link rel="stylesheet" href="./resources/css/bdmailer/bdmailer.css" />
<table class="table">
	<thead>
		<tr>
			<td>Name</td>
			<td>Identity</td>
			<td>Job</td>
			<td>Birthday</td>
		</tr>

	</thead>

	<c:forEach items="${users}" var="user">
		<tr>

			<td>${user.getName()}</td>
			<td>${user.getUser_id()}</td>
			<td>${user.getJob()}</td>
			<td>${user.getDob()}</td>
		</tr>
		
	</c:forEach>
</table>

<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>