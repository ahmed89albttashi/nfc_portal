<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

 

<div id="loginbox" style="margin-top: 50px;"
	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-info">
		<div class="panel-heading">
			<div class="panel-title"><spring:message code="sec.reset_pass" /></div>
			
		</div>

		<div style="padding-top: 30px" class="panel-body">

			<div style="display: none" id="login-alert"
				class="alert alert-danger col-sm-12"></div>
			
			<form:form role="form" action="./sec/forget/user/a/done"
								method="POST"  class="form-horizontal" >

				
				<!-- Email -.> require if not using session   -->
				<c:choose>
			    <c:when test="${empty email}">
			        <spring:message code="gen.email" var="f_email"/>
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-tag"></i></span>
									<input id="email" name="email" type="text" class="form-control" 
									placeholder="${f_email}" required="required" />
									</div>
			    </c:when>
			    <c:otherwise>
			        <input type="hidden" name="email" value="${email}" />
			    </c:otherwise>
			</c:choose>


				<!-- ResetCode -->
				<spring:message code="sec.reset.code" var="f_reset_code"/>
				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="fa fa-tag"></i></span>
						<input id="reset_code" name="reset_code" type="text" class="form-control" placeholder="${f_reset_code}" required="required" />
				</div>

<hr>
				<!-- new Password -->
				<spring:message code="sec.reset.new_passowrd" var="f_new_password"/>
				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="fa fa-key"></i></span>
						<input type="password" name="pass1" id="pass1" class="form-control" placeholder="${f_new_password}" required="required" minlength="6"/>
				</div>


				<!-- Confirm password -->
				<spring:message code="sec.reset.confirm_new_passowrd" var="confirm_new_password"/>
				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="fa fa-check"></i></span>
						<input type="password" name="pass2" id="pass2"  data-rule-equalTo="#pass1" class="form-control" placeholder="${confirm_new_password}"/>
				</div>


				<div style="margin-top: 10px" class="form-group">
					<!-- Button -->
					
					<div class="col-sm-12 controls">
						<button  value="Send" class="btn btn-success" type="submit" id="submit" > <spring:message code="sec.reset" /> </button> 
						
						

					</div>
				</div>
								
			</form:form>




		</div>
	</div>
</div>

<script type="text/javascript" >
$( "#user" ).validate({
	  rules: {
	    email: {
	      required: true,
	      email: true
	    },


	  },
	  errorPlacement: function(error, element) {
		    if (element.is(":radio")) {
		        error.insertAfter(element.closest("div"));
		    } else {
		        error.insertAfter(element);
		    }
            error.appendTo($('.errorTxt span'));
		}
	});
	
	
</script>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>