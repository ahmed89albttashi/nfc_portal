<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>

<script type="text/template" id="qq-template-gallery">
        <div class="qq-uploader-selector qq-uploader qq-gallery" qq-drop-area-text="Drop files here">
            <div class="qq-total-progress-bar-container-selector qq-total-progress-bar-container">
                <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-total-progress-bar-selector qq-progress-bar qq-total-progress-bar"></div>
            </div>
            <div class="qq-upload-drop-area-selector qq-upload-drop-area" qq-hide-dropzone>
                <span class="qq-upload-drop-area-text-selector"></span>
            </div>
            <div class="qq-upload-button-selector qq-upload-button">
                <div>Upload a file</div>
            </div>
            <span class="qq-drop-processing-selector qq-drop-processing">
                <span>Processing dropped files...</span>
                <span class="qq-drop-processing-spinner-selector qq-drop-processing-spinner"></span>
            </span>
            <ul class="qq-upload-list-selector qq-upload-list" role="region" aria-live="polite" aria-relevant="additions removals">
                <li>
                    <span role="status" class="qq-upload-status-text-selector qq-upload-status-text"></span>
                    <div class="qq-progress-bar-container-selector qq-progress-bar-container">
                        <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-progress-bar-selector qq-progress-bar"></div>
                    </div>
                    <span class="qq-upload-spinner-selector qq-upload-spinner"></span>
                    <div class="qq-thumbnail-wrapper">
                        <img class="qq-thumbnail-selector" qq-max-size="120" qq-server-scale>
                    </div>
                    <button type="button" class="qq-upload-cancel-selector qq-upload-cancel">X</button>
                    <button type="button" class="qq-upload-retry-selector qq-upload-retry">
                        <span class="qq-btn qq-retry-icon" aria-label="Retry"></span>
                        Retry
                    </button>

                    <div class="qq-file-info">
                        <div class="qq-file-name">
                            <span class="qq-upload-file-selector qq-upload-file"></span>
                            <span class="qq-edit-filename-icon-selector qq-edit-filename-icon" aria-label="Edit filename"></span>
                        </div>
                        <input class="qq-edit-filename-selector qq-edit-filename" tabindex="0" type="text">
                        <span class="qq-upload-size-selector qq-upload-size"></span>
                        <button type="button" class="qq-btn qq-upload-delete-selector qq-upload-delete">
                            <span class="qq-btn qq-delete-icon" aria-label="Delete"></span>
                        </button>
                        <button type="button" class="qq-btn qq-upload-pause-selector qq-upload-pause">
                            <span class="qq-btn qq-pause-icon" aria-label="Pause"></span>
                        </button>
                        <button type="button" class="qq-btn qq-upload-continue-selector qq-upload-continue">
                            <span class="qq-btn qq-continue-icon" aria-label="Continue"></span>
                        </button>
                    </div>
                </li>
            </ul>

            <dialog class="qq-alert-dialog-selector">
                <div class="qq-dialog-message-selector"></div>
                <div class="qq-dialog-buttons">
                    <button type="button" class="qq-cancel-button-selector">Close</button>
                </div>
            </dialog>

            <dialog class="qq-confirm-dialog-selector">
                <div class="qq-dialog-message-selector"></div>
                <div class="qq-dialog-buttons">
                    <button type="button" class="qq-cancel-button-selector">No</button>
                    <button type="button" class="qq-ok-button-selector">Yes</button>
                </div>
            </dialog>

            <dialog class="qq-prompt-dialog-selector">
                <div class="qq-dialog-message-selector"></div>
                <input type="text">
                <div class="qq-dialog-buttons">
                    <button type="button" class="qq-cancel-button-selector">Cancel</button>
                    <button type="button" class="qq-ok-button-selector">Ok</button>
                </div>
            </dialog>
        </div>
    </script>

    
    
<div class="row">


	<hr>
	<div class="col-md-10 col-xs-10">
			<i class="fa fa-edit"></i>
			<spring:message code="a.it_ticket.ticket" />
			: <span> <b> ${ticket.getTitle()} </b></span>
			
			<%-- ${ticket.getDetail()}  --%>
		


	
	

	<!-- Tracks -->
	<c:forEach var="a" items="${tracks}">


			<div class="col-md-12 col-xs-12 a1track_each ">


				<div class="a1track_each_head text-muted">
					<spring:message code="a.it_ticket.status" />
					: <b> <spring:message code="a.it_ticket.status.${a.getTrack()}" /> 
					
					</b>
					<div style="float: right;">
						<i class="fa fa-edit"></i> : <small> ${fn:substring( {a.getChanged_on()},
							1, 17)}</small>

					</div>
					<br> <small><spring:message
							code="a.it_ticket.track.by" /></small> : <i>
						${a.getCreated_by().getName() } </i>
				</div>
				<hr>
				<div class="text-primary">
					${a.getDetail()} <br>

				</div>
				
				
				<c:if test="${fn:length(a.getAttachment()) gt 0}">
				<div class="text-muted">
				<hr>
				<div class="text-primary"> <spring:message code="gen.attachments" />   </div>
				
				<ol>
					<c:forEach items="${a.getAttachment()}" var="attch" >
					<li> <a target="_blank" href="./a/itTicket/track/download_attch/${attch.getAttachment_id()}">${attch.getSf_name()}</a></li>
					</c:forEach>
					</ol>
				</div>
				
				</c:if>
				



		</div>
		<br>

	</c:forEach>
</div>


<br><br><br>
<div class="col-md-2 col-xs-2 well ">
<spring:message code="a.it_ticket.id" /> : <pre> ${ticket.getA1_ticket_ticket_id()} </pre> <br> 
		<spring:message code="a.it_ticket.track.by" />
		: ${ticket.getCreated_by().getName()}
		
		

		<hr>


		<h6>
			<spring:message code="gen.created_on" />
			:  <small> <c:out
					value="${fn:substring( {ticket.getCreated_on()}, 1, 17)}" /></small> <br>

			<spring:message code="gen.last_update" />
			:  <small> <c:out
					value="${fn:substring( {ticket.getChanged_on()}, 1, 17)}" />
			</small>

		</h6>
<hr>
<h6><spring:message code="a.it_ticket.trackers_list" /> : </h6>
	<c:forEach items="${involvedTracker}" var="it">
		<i class="fa fa-user" aria-hidden="true"> <small>${it.getTracker_id().getName()}  </small></i>
	</c:forEach>
<br> <br>
	</div>


	<form id="form_track"
		action="/a/itTicket/track/${ticket.getA1_ticket_ticket_id()}/update"
		method="post">


		<div class="col-md-12 col-xs-12 edit-block ">


			<br>
			<br>
			<br>
			<br>

			<h4><spring:message code="a.it_ticket.track.new" /></h4>
			<div class="form-group col-xs-8">
				<label> <spring:message code="a.it_ticket.status" />
				</label> <select class="form-control " name="track" id="track">
					<option value="new">
						<spring:message code="a.it_ticket.status.new" />
					</option>
					<option value="assigned">
						<spring:message code="a.it_ticket.status.assigned" />
					</option>
					<option value="in_progress">
						<spring:message code="a.it_ticket.status.in_progress" />
					</option>
					<option value="info_request">
						<spring:message code="a.it_ticket.status.info_request" />
					</option>
					<option value="hold">
						<spring:message code="a.it_ticket.status.hold" />
					</option>
					<option value="solved">
						<spring:message code="a.it_ticket.status.solved" />
					</option>
					<option value="closed">
						<spring:message code="a.it_ticket.status.closed" />
					</option>
				</select>
				
				<hr>
				<div id="assigned_form" style="display: none;">
				<label>Assigned to </label>
				<select name="trackers" multiple="multiple" class="form-control">
				<c:forEach items="${it_staff}" var="staff">
				  	<option value="${staff.getUser_id() }" > ${staff.getName() } </option>
				</c:forEach>
				
				</select>
				</div>
			</div>

			<div class="form-group col-xs-12">
			
			
				<button type="button" class="btn btn-default"><spring:message code="a.it_ticket.status.assigned" /></button>
				<button type="button" class="btn btn-default"><spring:message code="a.it_ticket.status.in_progress" /></button>
				<button type="button" class="btn btn-default"><spring:message code="a.it_ticket.status.info_request" /></button>
				<hr>
				<button type="button" class="btn btn-default"><spring:message code="a.it_ticket.status.hold" /></button>
				<button type="button" class="btn btn-default"><spring:message code="a.it_ticket.status.solved" /></button>
				<button type="button" class="btn btn-default"><spring:message code="a.it_ticket.status.closed" /></button> 
				
				
				<textarea id="detail" name="detail" style="width: 100%" rows="15"></textarea>
			</div>

			<br> <input type="hidden" name="a1Ticket"
				value="${ticket.getA1_ticket_ticket_id()}"> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</div>
		<div class="col-md-12 col-xs-12 ">
		
<div id="fine-uploader-gallery"></div> 
											<br>
			<button id="track_submit" class="btn btn-lg btn-primary ">
				<spring:message code="tmplt.hdr.submit" />
				<span class="glyphicon glyphicon-send"></span>
			</button>
		</div>


	</form>

</div>
<script type="text/javascript">
	var tm = tinymce
			.init({
				selector : "textarea",
				plugins : [
						"advlist autolink lists link image charmap print preview anchor",
						"searchreplace visualblocks code fullscreen",
						"insertdatetime media table contextmenu paste" ],
				toolbar : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
			});

	$(function() {
		$("#track_submit").click(function() {
			tinyMCE.activeEditor.getContent({
				format : 'raw'
			});
			//tinyMCE.triggerSave();
			//alert(tinyMCE.get('content').getContent());
			var editorContent = tinyMCE.get('content').getContent();

			if($("#track").val()=="assigned"){
				alert("must select at least one staff");
			}

			if (editorContent == '') {
				
			}
			
			
		});
		
		$("#track").on('change', function() {
		    if ($(this).val() == 'assigned'){
		        $("#assigned_form").show();
		    } else {
		    	$("#assigned_form").hide();
		    }
		});
	});
</script>


<script>
$('#fine-uploader-gallery').fineUploader({
    template: 'qq-template-gallery',
    request: {
        endpoint: '/a/itTicket/upload_attach/'
        ,params: {
            ${_csrf.parameterName} : '${_csrf.token}'
        }
    },
    thumbnails: {
        placeholders: {
            waitingPath: '/resources/img/fineupload/placeholders/waiting-generic.png',
            notAvailablePath: '/resources/img/fineupload/placeholders/not_available-generic.png'
        }
    },
    validation: {
        allowedExtensions: ['jpeg', 'jpg', 'gif', 'png', 'pdf', 'doc', 'docx', 'png']
    },
    callbacks:{
    	onComplete:function(id, name, response) {
    		$('#form_track').append('<input type="hidden" name="uploads[]" value="'+response.attch_id+'" />')
    		
    	}
    }
    


});
    </script>

<div id="tn_vld_detail"
	title="<spring:message code="a.it_ticket.track.f.vld.detail"/> ">
</div>




<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>
