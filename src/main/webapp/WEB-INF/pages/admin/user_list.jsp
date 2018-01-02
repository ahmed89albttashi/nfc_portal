<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<table class=" display table table-striped table-bordered" id="user_list">
<thead>
<tr>
<th># </th>
<th>Staff ID </th>
<th>Email </th>
<th>Name  </th>
<th>Name (AR) </th>
<th> Options </th>

</tr>
</thead>
<tbody>
<c:set var="count" value="0" />
<c:forEach items="${activeList}" var="u">

<tr>

<td>
<c:out value="${count}" />
<c:set var="count" value="${count+1}" />

</td>

<td>
${u.getStaff().getStaff_id()} 
</td>
<td>
${u.getEmail()} 
</td><td>
${u.getStaff().getFullName_en()} 
</td><td>
${u.getStaff().getFullName_ar()} 
</td>

<td>
<a href="./sysAdmin/users/edit/${u.getUser_id()}" > Edit </a>
</td>
</tr>
</c:forEach>
</tbody>
</table>


<script type="text/javascript">

$(document).ready(function(){
    $('#user_list').DataTable();
    
});

</script>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>

