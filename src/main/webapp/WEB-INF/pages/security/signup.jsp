<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<!-- to print 123 encrypted -->
<%-- en:${en} --%>


<div id="loginbox" style="margin-top: 50px;"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title">Sign Up</div>
			<div
				style="float: right; font-size: 80%; position: relative; top: -10px">
				<a href="./sec/forget">Forgot password?</a>
			</div>
		</div>

		<div style="padding-top: 30px" class="panel-body">

			<div style="display: none" id="login-alert"
				class="alert alert-danger col-sm-12"></div>

			<form id="loginform" class="form-horizontal" role="form"
				action="./sec/signup" method="post">

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="login-username"
						type="text" class="form-control" name="username" value=""
						placeholder="Your Email Address ">
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
							name="remember" value="1"> Remember me
						</label>
					</div>
				</div>


				<div style="margin-top: 10px" class="form-group">
					<!-- Button -->

					<div class="col-sm-12 controls">

						<input id="btn-login" type="submit"
							class="btn btn-lg btn-primary btn-block" value="Sign up"> 
							
							
							<input
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
