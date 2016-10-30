<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>



<div id="loginbox" style="margin-top: 50px;"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title"> <spring:message code="admin.user.create.done" /> </div>
			
		</div>

		<div style="padding-top: 30px" class="panel-body">

Portal sending an email to employee : ${user.getName()} . . . .
			<div style="display: none" id="login-alert"
				class="alert alert-danger col-sm-12"></div>
		</div>
	</div>


</div>

<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>

