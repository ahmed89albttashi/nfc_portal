<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>




<table id="users_tbl" class="display" cellspacing="0" width="100%">

	<thead>
		<tr>
			<th>Staff ID</th>
			<th>Name</th>
			<th>Position</th>
			<th>Email</th>
			<th>Changed on</th>
			<th>Enabled</th>
			<th>Edit</th>
			<th>Delete</th>
			
		</tr>
	</thead>

	<tfoot>
		<tr>
			<th>Staff ID</th>
			<th>Name</th>
			<th>Position</th>
			<th>Email</th>
			<th>Changed on</th>
			<th>Enabled</th>
			<th>Edit</th>
			<th>Delete</th>
			
			
		</tr>
	</tfoot>
</table>


<%-- 
<c:forEach items="${users}" var="u">

${u.getName()} 
شركة 

</c:forEach>
 --%>

<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>

<script type="text/javascript"
	src="./resources/js/jquery.dataTables.min.js"></script>



<script type="text/javascript">
	$(document).ready(function() {

		var table =$('#users_tbl').DataTable({
				"ajax" : "./admin/users_list_json",
				"columns" : [ {
					"data" : "staff_id"
				}, {
					"data" : "name"
				}, {
					"data" : "position"
				}, {
					"data" : "email"
				}, {
					"data" : "changed_on"
				}, {
					"data" : "enabled"
				}],
				"columnDefs": [ {
		            "targets": 6,
		            "data": null,
		            "defaultContent": '<button class="btn edit btn-success  btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit"><span class="glyphicon glyphicon-pencil"></span></button>'
		        },{
		            "targets": 7,
		            "data": null,
		            "defaultContent": '<button class="btn delete btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete"><span class="glyphicon glyphicon-trash"></span></button>'
		        }]
			});


	    $('#users_tbl').on( 'click', '.edit', function () {
	    	 var data = table.row( $(this).closest('tr') ).data();
	         window.location.replace("./admin/user/edit/"+data["user_id"]);
	    } );

	    $('#users_tbl').on( 'click', '.delete', function () {
	    	var data = table.row( $(this).closest('tr') ).data();
	    	if(confirm("Caution : Do you want delete user \n"+data["name"]+" ?")){
		         window.location.replace("./admin/user/delete/"+data["user_id"]);
	    	}else{
	    		
	    	}
	    	
	    } );

		
	});
</script>
