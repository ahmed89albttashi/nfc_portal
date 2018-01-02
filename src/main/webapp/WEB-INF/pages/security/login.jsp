<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<h4>
	<%-- pass = ${en} --%> 

</h4>
<div id="loginbox" style="margin-top: 50px;"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="panel-title">
				<spring:message code="sec.login" />
			</div>
			<hr>
			<div
				style="float: right; font-size: 80%; position: relative; top: -10px">
				<a href="./sec/forget"> <spring:message code="sec.reset_pass" /> ?</a>
			</div>
			
		</div>

		<div style="padding-top: 30px" class="panel-body">

			<div style="display: none" id="login-alert"
				class="alert alert-danger col-sm-12"></div>

			<form id="loginform" class="form-horizontal" role="form"
				action="./sec/login/" method="post">

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="login-username"
						type="text" class="form-control" name="username" value=""
						placeholder="@NFC~Email">
				</div>

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
						type="password" class="form-control" name="password"
						placeholder="password">
				</div>



				<div class="input-group">
					<div class="checkbox">
						<label> <input id="login-remember" type="checkbox"
							name="remember" value="1"> <spring:message
								code="sec.remeber" />
						</label>
					</div>
				</div>


				<div style="margin-top: 10px" class="form-group">
					<!-- Button -->

					<div class="col-sm-12 controls">

						<input id="btn-login" type="submit"
							class="btn btn-lg btn-primary btn-block"
							value=" <spring:message code="sec.login" />"> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />



					</div>
				</div>

			</form>


		</div>
	</div>
</div>
</div>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>

