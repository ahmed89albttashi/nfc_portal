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
			
			<form:form role="form" action="./sec/forget/"
								method="POST" commandName="user" class="form-horizontal" >

<c:if test="${not empty msg}">


<div class="alert alert-success">
  <strong> <spring:message code="tmplt.success"/> </strong> <spring:message code="sec.reset.msg"/> 
</div>
</c:if>

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> 
						<form:input path="email" class="form-control" placeholder="@NFC~Email"/>

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
</script>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>