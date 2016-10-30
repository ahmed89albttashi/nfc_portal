<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>






<div class="row  pad-top">

	<div class="container-fluid">

		<div class="panel panel-default">
			<div class="panel-heading">
				<strong> <spring:message code="a.it_ticket.create" /> <i
					class="fa fa-edit"></i>
				</strong>
			</div>

			<div class="panel-body">
				<div id="emp_steps_body"></div>

				<div id="emp_steps">

					<p> <spring:message code="a.it_ticket.f.e.complete" /> </p>


				</div>




			</div>

		</div>
	</div>


</div>

<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>