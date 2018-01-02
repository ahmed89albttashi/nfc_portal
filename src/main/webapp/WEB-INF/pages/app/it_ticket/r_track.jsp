<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<div class="row  pad-top">

	<div class="container-fluid">

		<div class="panel panel-default">
			<div class="panel-heading">
				<strong> <spring:message code="a.it_ticket.status.${ticket_status}" />
					<i class="fa fa-list"></i>
				</strong>
			</div>

			<div class="panel-body">
				<div id="emp_steps_body"></div>

				<div id="emp_steps">

					<p>
					<table role="tabled" class="table table-striped table-hover"
						data-toggle="table">
						<thead>
							<tr>
								<th data-field="id" >#</th>
								<th data-field="name" width="40%"><spring:message
										code="a.it_ticket.f.title" /></th>
								<c:set var="counter" value="1"></c:set>
								<th data-field="id"><spring:message
										code="a.it_ticket.f.type" /></th>
								<th data-field="name"><spring:message
										code="a.it_ticket.f.type" /></th>
								<th data-field="price"><spring:message
										code="a.it_ticket.status" /></th>
								<th data-field="price"><spring:message
										code="gen.created_on" /></th>
								<%-- <th data-field="price"><spring:message code="gen.options" /></th> --%>
							</tr>
						</thead>


						<c:forEach items="${tracks}" var="tr">

							<tr>
								<td><small>${counter}<c:set var="counter" value="${counter+1}" /></small>
								</td>
								
								<td>
								<a href="./a/itTicket/track/${tr.getA1Ticket().getA1_ticket_ticket_id()}/">${tr.getA1Ticket().getTitle()} 
								
								<br>
								<small class="text-muted">${tr.getA1Ticket().getCreated_by().getStaff().getFullName_en()} </small> </a>
								
								</td>
								
								
								<td><spring:message
										code="a.it_ticket.f.type.${tr.getA1Ticket().getType()}" /></td>
								<td><spring:message
										code="a.it_ticket.f.type.support.type.${tr.getA1Ticket().getSub_type()}" /></td>
								
								<td>FNA</td>
								<td><h5><small> ${fn:substring(tr.getA1Ticket().getCreated_on().toString(), 0,16)} </small></h5></td>
								
								
								<!-- Hide Options -->
								<%-- 
								<td>
								<a href="./a/itTicket/edit?ticket_id=${ticket.getA1_ticket_ticket_id() }">
										<i class="fa fa-edit"></i> </a> &nbsp; ||  &nbsp;
								<a href="./a/itTicket/delete?ticket_id=${ticket.getA1_ticket_ticket_id() }">
								<i class="fa fa-trash"></i> </a>&nbsp; 
										
										</td> --%>
							</tr>
						</c:forEach>
					</table>



				</div>




			</div>

		</div>
	</div>


</div>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>