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
				<spring:message code="sec.change_pass" />
			</div>


		</div>


<c:if test="${current_password_wrong == true}">
<div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
        <spring:message code="sec.reset.fail.current_pass_not" />
    </div>
</c:if>

    
		<div style="padding-top: 30px" class="panel-body">

			<div style="display: none" id="login-alert"
				class="alert alert-danger col-sm-12"></div>

			<form id="change_password" class="form-horizontal" role="form"
				action="./sec/change_password/" method="post">

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="email"
						type="text" class="form-control" name="email" value=""
						placeholder="@NFC~Email">
				</div>

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> 
						<input id="password"
						type="password" class="form-control" name="password"
						placeholder="<spring:message code="sec.change_pass.current_pass" />">
				</div>


				<hr>


				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="new_password"
						type="password" class="form-control" name="new_password"
						placeholder="<spring:message code="sec.reset.new_passowrd" />">
				</div>

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="confirm_password"
						type="password" class="form-control" name="confirm_password"
						placeholder="<spring:message code="sec.reset.confirm_new_passowrd" />">
				</div>

				


				<div style="margin-top: 10px" class="form-group">
					<!-- Button -->

					<div class="col-sm-12 controls">

						<input id="btn-login" type="submit" disabled="disabled"
							class="btn btn-lg btn-primary btn-block"
							value=" <spring:message code="tmplt.hdr.submit" />"> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />



					</div>
				</div>

			</form>


		</div>
	</div>
</div>


<script type="text/javascript" >
$.validator.addMethod( "notEqualTo", function( value, element, param ) {
	return this.optional( element ) || !$.validator.methods.equalTo.call( this, value, element, param );
}, "Please enter a different value, values must not be the same." );


$( "#change_password" ).validate({
	  rules: {
	    email: {
	      required: true,
	      email: true
	    },
	    password:{
	    	required: true , 
	    	minlength:3
	    },
	    new_password: {
	    	required: true , 
	    	minlength:6 ,
	    	notEqualTo:"#password"
	    },
	    confirm_password :{
	    	required: true , 
	    	equalTo: "#new_password"
	    }
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
	
$('#change_password input').on('keyup blur', function () { // fires on every keyup & blur
    if ($('#change_password').valid()) {                   // checks form for validity
        $('#btn-login').prop('disabled', false);        // enables button
    } else {
        $('#btn-login').prop('disabled', 'disabled');   // disables button
    }
});
</script>

<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>

