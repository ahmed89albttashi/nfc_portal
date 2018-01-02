<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<div class="row  pad-top">

	<div class="container-fluid">

		<c:if test="${fn:length(not_closed_tracks) gt 0}">
			<div class="panel panel-info">
				<div class="panel-heading">
					<strong> <i class="fa fa-tasks"></i> <spring:message
							code="a.it_ticket.status.in_progress" /> 
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
									<th data-field="id">#</th>
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


							<c:forEach items="${not_closed_tracks}" var="track">
								<c:set value="${track.getA1Ticket()}" var="ticket" />

								<tr>
									<td><small>${counter}<c:set var="counter"
												value="${counter+1}" /></small></td>
									<td><a
										href="./a/itTicket/track/${ticket.getA1_ticket_ticket_id() }/">${ticket.getTitle()}
									</a></td>
									<td><spring:message
											code="a.it_ticket.f.type.${ticket.getType()}" /></td>
									<td><spring:message
											code="a.it_ticket.f.type.support.type.${ticket.getSub_type()}" /></td>

									<td><spring:message
											code="a.it_ticket.status.${track.getTrack()}" /></td>
									<td><h5>
											<small>
												${fn:substring(ticket.getCreated_on().toString(), 0,16)} </small>
										</h5></td>



								</tr>
							</c:forEach>
						</table>



					</div>




				</div>

			</div>

		</c:if>

		<c:if test="${fn:length(not_closed_tracks) lt 1}">
			<div class="alert alert-success">
				<strong> <spring:message
							code="a.it_ticket.status.in_progress" /> : </strong> <spring:message code="a.it_ticket.my_ticket.not_closed_empty_msg" />.
			</div>
		</c:if>








		<div class="panel panel-default">
			<div class="panel-heading">
				<strong><i class="fa fa-folder"></i> <spring:message code="a.it_ticket.status.closed" />
					
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
								<th data-field="id">#</th>
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


						<c:forEach items="${closed_tracks}" var="track">
							<c:set value="${track.getA1Ticket()}" var="ticket" />

							<tr>
								<td><small>${counter}<c:set var="counter"
											value="${counter+1}" /></small></td>
								<td><a
									href="./a/itTicket/track/${ticket.getA1_ticket_ticket_id() }/">${ticket.getTitle()}
								</a></td>
								<td><spring:message
										code="a.it_ticket.f.type.${ticket.getType()}" /></td>
								<td><spring:message
										code="a.it_ticket.f.type.support.type.${ticket.getSub_type()}" /></td>

								<td><spring:message
										code="a.it_ticket.status.${track.getTrack()}" /></td>
								<td><h5>
										<small>
											${fn:substring(ticket.getCreated_on().toString(), 0,16)} </small>
									</h5></td>


							

							</tr>
						</c:forEach>
					</table>



				</div>




			</div>

		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong><i class="fa fa-folder"></i> <spring:message code="a.it_ticket.to_follow" />
					
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
								<th data-field="id">#</th>
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


						<c:forEach items="${to_follow}" var="ticket">

							<tr>
								<td><small>${counter}<c:set var="counter"
											value="${counter+1}" /></small></td>
								<td><a
									href="./a/itTicket/track/${ticket.getA1_ticket_ticket_id() }/">${ticket.getTitle()}
								</a></td>
								<td><spring:message
										code="a.it_ticket.f.type.${ticket.getType()}" /></td>
								<td><spring:message
										code="a.it_ticket.f.type.support.type.${ticket.getSub_type()}" /></td>

								<td> </td>
								<td><h5>
										<small>
											${fn:substring(ticket.getCreated_on().toString(), 0,16)} </small>
									</h5></td>


							

							</tr>
						</c:forEach>
					</table>



				</div>




			</div>

		</div>
	</div>


</div>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>