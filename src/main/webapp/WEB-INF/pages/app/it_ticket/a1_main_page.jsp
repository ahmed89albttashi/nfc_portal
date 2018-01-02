<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>




<div class="row">


	<hr>
	<div class="col-md-10 col-xs-10">
		

		
			<h2><spring:message code="tmplt.apps.it_ticket" /></h2>
		
		<img src="./resources/img/a1/banner_it.jpg" />
			<!-- <p><i class="fa fa-user-md fa-5x " aria-hidden="true"></i></p> -->
			<div class="jumbotron">
			<p> <spring:message code="a.it_ticket.intro" /> </p>
			<p>
				<a class="btn btn-primary btn-lg fa fa-question" href="/a/itTicket/create/" role="button"> <spring:message code="a.it_ticket.create" /></a>
			</p>
		</div>
	</div>

</div>




<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>