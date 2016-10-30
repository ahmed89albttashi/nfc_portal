<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%-- 
${stats} 
<c:set var="incdex" value="0"/>
<c:forEach items="${l_new}" var="l">
<c:set var="index" value="${index+1}" />
<br>
<c:out  value="${index}" />
<br>
${l[1]}
</c:forEach>

--%>

<script type="text/javascript">

$body = $("body");

$(document).on({
    ajaxStart: function() { $body.addClass("loading");    },
     ajaxStop: function() { $body.removeClass("loading"); }    
});


function load_ticket(ticket_id){
	$(function() {
		var base_path = '${c_path}';

		
		    $.ajax({url: "./a/itTicket/track_ajax/"+ticket_id+"/", success: function(result){
		    	$("html").html(result);
		        //$("#ticket_view").html(result);
		    }});
		

		//alert("on ready"+ticket_id);
		
		//$("#dash").hide(30);
		$( "#dash" ).hide(1000);
		
		$("#ticket_view").show(1000);
		$("#btn_back").show(250);

		
	});
	
	//btn_back

}



function load_dash(){

	$( "#ticket_view" ).hide(1000);
	$("#btn_back").hide(250);
	
	$("#dash").show(1000);
	
}



</script>



<!-- for loadin -->
<div class="modal"><!-- Place at bottom of page --></div>


<div id="dash">

<div class="row  row-centered center" >



<!-- NEW SECTION -->
	<div class="col-sm-3 col-xs-8 a_it_admin_cards "
		style="background: #cce2f5;">
		<div class="a_it_admin_cards_header">

			<h3> <a href="/a/itTicket/admin/new/">
				<span class="fa fa-tag"></span>
				<spring:message code="a.it_ticket.status.new" />
				<span class="badge">
<c:forEach var="a" items="${stats}" >

<c:if test="${a[0] == 'new' }" >
${a[1]}</c:if></c:forEach>
				 </span>
				 
				 </a>
			</h3>
			<hr>
		</div>

		<div class="a_it_admin_cards_body">
		
		<div class="list-group">
		<c:forEach items="${l_new}" var="l">
		
			<a class="list-group-item" style="cursor: help; " href="/a/itTicket/track/${l[1].getA1_ticket_ticket_id()}/">
			${l[1].getTitle()}
			<H6>last update : ${fn:substring(l[2], 0, 16)}</H6>
			</a>
			
			
		</c:forEach>
		</div>
		
		</div>
	</div>




<!-- Assigned section -->
	<div class="col-sm-3 col-xs-8 a_it_admin_cards col-centered">
		<div class="a_it_admin_cards_header">

			<h3><a href="/a/itTicket/admin/assigned/">
				<span class="fa fa-user-plus"></span>
				<spring:message code="a.it_ticket.status.assigned" />
				<span class="badge">
<c:forEach var="a" items="${stats}" >
<c:if test="${a[0] == 'assigned' }" >
${a[1]}</c:if></c:forEach>
</span>
</a>
			</h3>
			<hr>
		</div>

		<div class="a_it_admin_cards_body">
		<div class="list-group">
		<c:forEach items="${l_assigned}" var="l">
		
		
			<a class="list-group-item" style="cursor: help; " href="/a/itTicket/track/${l[1].getA1_ticket_ticket_id()}/">
			${l[1].getTitle()}
			<H6>last update : ${fn:substring(l[2], 0, 16)}</H6>
			</a>
			
			
			
			
		</c:forEach>
		</div></div>
	</div>




<!-- IN Progress Section -->
	<div class="col-sm-3 col-xs-8 a_it_admin_cards col-centered">
		<div class="a_it_admin_cards_header">

			<h3><a href="/a/itTicket/admin/in_progress/">
				<span class="fa fa-tasks"></span>
				<spring:message code="a.it_ticket.status.in_progress" />
				<span class="badge">
<c:forEach var="a" items="${stats}" >
<c:if test="${a[0] == 'in_progress' }" >
${a[1]}</c:if></c:forEach>
</span></a>
			</h3>
			<hr>
		</div>

		<div class="a_it_admin_cards_body">
		
		<div class="list-group">
		<c:forEach items="${l_in_progress}" var="l">
		
		
			<a class="list-group-item" style="cursor: help; " href="/a/itTicket/track/${l[1].getA1_ticket_ticket_id()}/">
			${l[1].getTitle()}
			<H6>last update : ${fn:substring(l[2], 0, 16)}</H6>
			</a>
			
			
			
			
		</c:forEach>
		</div>
		</div>
	</div>




<!-- INformation request Section -->
	<div class="col-sm-3 col-xs-8 a_it_admin_cards col-centered">
		<div class="a_it_admin_cards_header">

			<h3><a href="/a/itTicket/admin/info_request/">
				<span class="fa fa-info-circle"></span>
				<spring:message code="a.it_ticket.status.info_request" />
				<span class="badge">
<c:forEach var="a" items="${stats}" >
<c:if test="${a[0] == 'info_request' }" >
${a[1]}</c:if></c:forEach>
</span></a>
			</h3>
			<hr>
		</div>

		<div class="a_it_admin_cards_body">
		
		<div class="list-group">
		<c:forEach items="${l_info_request}" var="l">
		
		
			<a class="list-group-item" style="cursor: help; " href="/a/itTicket/track/${l[1].getA1_ticket_ticket_id()}/">
			${l[1].getTitle()}
			<H6>last update : ${fn:substring(l[2], 0, 16)}</H6>
			</a>
			
			
			
			
		</c:forEach>
		</div>
		</div>
	</div>






<!-- end first row  -->
</div>



<!-- Solved Section -->

<div class="row  row-centered center">

	<hr size="3">
	<div class="col-sm-3 col-xs-8 a_it_admin_cards col-centered" 
	style="background: #cce2f5;">
		<div class="a_it_admin_cards_header">

			<h3><a href="/a/itTicket/admin/solved/">
				<span class="fa fa-check-square"></span>
				<spring:message code="a.it_ticket.status.solved" />
				<span class="badge"><c:forEach var="a" items="${stats}" >
				<c:if test="${a[0] == 'solved' }" >${a[1]}</c:if></c:forEach></span>
			</a>
			</h3>
			<hr>
		</div>

		<div class="a_it_admin_cards_body">
		
		<div class="list-group">
		<c:forEach items="${l_solved}" var="l">
		
		
			<a class="list-group-item" style="cursor: help; " href="/a/itTicket/track/${l[1].getA1_ticket_ticket_id()}/">
			${l[1].getTitle()}
			<H6>last update : ${fn:substring(l[2], 0, 16)}</H6>
			</a>
			
			
			
			
		</c:forEach>
		</div>
		</div>
	</div>




<!-- Hold Section -->
	<div class="col-sm-3 col-xs-8 a_it_admin_cards col-centered">
		<div class="a_it_admin_cards_header">

			<h3><a href="/a/itTicket/admin/hold/">
				<span class="fa fa-thumb-tack"></span>
				<spring:message code="a.it_ticket.status.hold" />
				<span class="badge"><c:forEach var="a" items="${stats}" ><c:if test="${a[0] == 'hold' }" >
${a[1]}</c:if></c:forEach></span>
			</a>
			</h3>
			<hr>
		</div>

		<div class="a_it_admin_cards_body">
		
		<div class="list-group">
		<c:forEach items="${l_hold}" var="l">
		
		
			<a class="list-group-item" style="cursor: help; " href="/a/itTicket/track/${l[1].getA1_ticket_ticket_id()}/">
			${l[1].getTitle()}
			<H6>last update : ${fn:substring(l[2], 0, 16)}</H6>
			</a>
			
			
			
			
		</c:forEach>
		</div>
		</div>
	</div>








<!-- Closed Section -->
	<div class="col-sm-3 col-xs-8 a_it_admin_cards col-centered">
		<div class="a_it_admin_cards_header">

			<h3><a href="/a/itTicket/admin/closed/">
				<span class="fa fa-folder"></span>
				<spring:message code="a.it_ticket.status.closed" />
				<span class="badge"><c:forEach var="a" items="${stats}" ><c:if test="${a[0] == 'closed' }" >
${a[1]}</c:if></c:forEach></span>
</a>
			</h3>
			<hr>
		</div>

		<div class="a_it_admin_cards_body">
		
		<div class="list-group">
		<c:forEach items="${l_closed}" var="l">
		
		
			<a class="list-group-item" style="cursor: help; " href="/a/itTicket/track/${l[1].getA1_ticket_ticket_id()}/">
			${l[1].getTitle()}
			<H6>last update : ${fn:substring(l[2], 0, 16)}</H6>
			</a>
			
			
			
			
		</c:forEach>
		</div>
		</div>
	</div>

</div>

</div>

 <button  id="btn_back" class="btn btn-default" style="display:none;" onclick="load_dash();"> <spring:message code="gen.btn.back" /> </button>
<div class="row  row-centered center" id="ticket_view">

</div>



<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>