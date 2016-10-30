<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
					<section>
						<p>
							<form:form role="form" action="./a/itTicket/edit/"
								method="post" commandName="a_IT_Ticket" accept-charset="UTF-8" >

								<form:errors path="*" />
								<form:hidden path="app_it_ticket_ticket_id"/>
								
								
								
								<div class="panel-body"></div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<br>
								<div class="row">
									<div class="col-md-5 col-sm-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h3 class="panel-title">
													<spring:message code="a.it_ticket.f.basic_info" />
												</h3>
											</div>
											<div class="panel-body">


		<form:errors path="type"
			class="error alert alert-danger alert-error" element="div" />
		<div class="form-group input-group">
			<span class="input-group-addon"><i
				class="fa fa-asterisk"></i></span>



			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-default  disabled"> <span
					class="fa fa-plus-square"> </span> 
					<input type="radio" value="request" disabled=disabled
					name="type" id="option1" autocomplete="off"> <spring:message
						code="a.it_ticket.f.type.request" />
				</label> <label class="btn btn-default active"> <span
					class="fa fa-life-ring"> </span> 
					<input type="radio"
					name="type" id="option2" value="support" autocomplete="off" checked>
					<spring:message code="a.it_ticket.f.type.support" />
				</label>

			</div>

		</div>





		<form:errors path="sub_type"
			class="error alert alert-danger alert-error" element="div" />
		<div class="form-group input-group">
			<span class="input-group-addon"><i
				class="fa fa-asterisk"></i></span>



			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-default   ${a_IT_Ticket.getSub_type()=='pc'?'active':'' }"> <span
					class="fa fa-desktop"> </span> <input type="radio" ${a_IT_Ticket.getSub_type()=='pc'?'checked':'' }
					name="sub_type" id="option1" value="pc" autocomplete="off"> <spring:message
						code="a.it_ticket.f.type.support.type.pc" />
						
				</label> 
				
				<label class="btn btn-default ${a_IT_Ticket.getSub_type()=='network'?'active':'' }"> <span
					class="fa fa-unlink"> </span> <input type="radio"
					name="sub_type" value="network" id="option2" autocomplete="off" ${a_IT_Ticket.getSub_type()=='network'?'checked':'' }>
					<spring:message
						code="a.it_ticket.f.type.support.type.network" />
				</label> 
				
				
				<label class="btn btn-default  ${a_IT_Ticket.getSub_type()=='email'?'active':'' }"> <span
					class="fa fa-envelope-o"> </span> 
					<input type="radio"
					name="sub_type" value="email" id="option2" autocomplete="off" ${a_IT_Ticket.getSub_type()=='email'?'checked':'' }> <spring:message
						code="a.it_ticket.f.type.support.type.email" />
				</label> 
				
				<label class="btn btn-default  ${a_IT_Ticket.getSub_type()=='extension'?'active':'' }"> <span
					class="fa fa-phone"> </span> 
					<input type="radio" value="extension"
					name="sub_type" id="option2" autocomplete="off" ${a_IT_Ticket.getSub_type()=='extension'?'checked':'' }> <spring:message
						code="a.it_ticket.f.type.support.type.extension" />
				</label>
				
				<label class="btn btn-default  ${a_IT_Ticket.getSub_type()=='printer'?'active':'' }"> <span
					class="fa fa-print"> </span> 
					<input type="radio"
					name="sub_type" value="printer" id="option2" autocomplete="off"
					${a_IT_Ticket.getSub_type()=='printer'?'checked':'' }> 
					<spring:message
						code="a.it_ticket.f.type.support.type.printer" />
				</label>
				
				<label class="btn btn-default  ${a_IT_Ticket.getSub_type()=='application'?'active':'' }"> <span
					class="fa fa-cubes"> </span> <input type="radio"
					name="sub_type" value="application" id="option2" autocomplete="off"
					${a_IT_Ticket.getSub_type()=='application'?'checked':'' }> 
					<spring:message
						code="a.it_ticket.f.type.support.type.application" />
				</label>
				<label class="btn btn-default  ${a_IT_Ticket.getSub_type()=='other'?'active':'' }"> <span
					class="fa fa-gear"> </span> 
					<input type="radio"
					name="sub_type" value="other" id="option2" autocomplete="off"
					${a_IT_Ticket.getSub_type()=='other'?'checked':'' }> 
					<spring:message
						code="a.it_ticket.f.type.support.type.other" />
				</label>

			</div>

		</div>


		<spring:message code="a.it_ticket.f.title" var="title" />
		<div class="form-group input-group">
			<span class="input-group-addon"><i
				class="fa fa-file-text-o"></i></span>
			<form:input path="title" cssClass="form-control custom-control" placeholder="${title}"/>
		</div>


		<spring:message code="a.it_ticket.f.detail"
			var="detail" />
		<div class="form-group input-group">
			<span class="input-group-addon"><i
				class="fa fa-file-text-o"></i></span>

			<form:textarea path="${detail}"  cssClass="form-control custom-control"  rows="5" placeholder="${detail}"/>

		</div>

											</div>
										</div>
									</div>




								</div>

								<hr>
						</p>
					</section>

					<p>

						<button type="submit" class="btn btn-lg btn-primary ">
							<spring:message code="tmplt.hdr.search.submit" />
							<span class="glyphicon glyphicon-send"></span>
						</button>

						</form:form>

					</p>


				</div>




			</div>

		</div>
	</div>


</div>




<script src="./resources/js/bootstrap-datepicker.js"
	type="text/javascript">
	
</script>

<script src="./resources/js/bootstrap-combobox.js"
	type="text/javascript">
	
</script>



<script type="text/javascript">
	$(document).ready(function() {

		$("#dob , #join_on").each(function() {
			$(this).datepicker({
				allowPastDates : true,
				format : 'dd/mm/yyyy'
			});
		});

		$('.combobox').combobox();

	});
</script>



<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>