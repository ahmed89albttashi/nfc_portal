<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>




<div id="dash">

<div class="row  row-centered center" >




<table class=" display table table-striped table-bordered" id="tracks_list">
<thead>
<tr>
<th># </th>
<th>Number </th>
<th>Ticket</th>
<th>Owner</th>
<th>type </th>
<th>created on   </th>
<th>Last update</th>
<th>Status  </th>
<th>Assigned to  </th>
<tH>URL </tH>

</tr>
</thead>
<tbody>
<c:set var="count" value="0" />
<c:forEach items="${tracks}" var="u">

<tr>

<td>
<c:out value="${count}" />
<c:set var="count" value="${count+1}" />

</td>
<td>
${u.getA1Ticket().getA1_ticket_ticket_id()}
</td>

<td>
 <a href="/a/itTicket/track/${u.getA1Ticket().getA1_ticket_ticket_id()}/" data-content="${u.getA1Ticket().getSub_type()}" data-toggle="popover" data-trigger="hover" title="${u.getA1Ticket().getDetail()}">
${u.getA1Ticket().getTitle()}
</a>
</td>
<td>
${u.getA1Ticket().getCreated_by().getStaff().getFullName_en()}
</td>
<td>
${u.getA1Ticket().getSub_type()}
</td><td>
<h6>${fn:substring({u.getA1Ticket().getCreated_on().toString()}, 1, 17)} </h6>
</td>
<td>
<h6>${fn:substring({u.getCreated_on().toString()}, 1, 17)}</h6>
</td>
<td>
${u.getTrack()} 
</td><td>
 <c:forEach items="${u.getA1Ticket().getTrackers()}" var="t" >
 
 <h6>${t.getTracker_id().getFullName_en()}</h6><br>
 </c:forEach>
</td>

<td>
http://10.150.0.44:8080/a/itTicket/track/${u.getA1Ticket().getA1_ticket_ticket_id()}/
</td>
</tr>
</c:forEach>
</tbody>
</table>



</div>

</div>

 <button  id="btn_back" class="btn btn-default" style="display:none;" onclick="load_dash();"> <spring:message code="gen.btn.back" /> </button>
<div class="row  row-centered center" id="ticket_view">

</div>

<script type="text/javascript">

$(document).ready(function(){
    $('#tracks_list').DataTable( {
    	 dom: 'Bfrtip',
         buttons: [
             'copy', 'csv', 'excel', 'pdf', 'print'
         ]
    } );
    
    
    $('[data-toggle="popover"]').popover();   

    
});

</script>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>