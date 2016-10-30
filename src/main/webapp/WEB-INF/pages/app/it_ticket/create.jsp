<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
							<form:form id="create_ticket_frm" role="form" action="./a/itTicket/create/"
								method="post" commandName="a_IT_Ticket" accept-charset="UTF-8">

								<form:errors path="*">
								</form:errors>
								

								<div class="panel-body"></div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<br>
								<div class="row">
									<div class="col-md-11 col-sm-12">
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
															class="fa fa-plus-square"> </span> <input type="radio"
															value="request" disabled=disabled name="type"
															id="option1" autocomplete="off"> <spring:message
																code="a.it_ticket.f.type.request" />
														</label> <label class="btn btn-default active"> <span
															class="fa fa-life-ring"> </span> <input type="radio"
															name="type" id="option2" value="support"
															autocomplete="off" checked> <spring:message
																code="a.it_ticket.f.type.support" />
														</label>

													</div>

												</div>





												<form:errors path="sub_type"
													class="error alert alert-danger alert-error" element="div" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-asterisk"></i></span>



													<div class="btn-group" data-toggle="buttons">
														<label class="btn btn-default  "> <span
															class="fa fa-desktop"> </span> <input type="radio"
															name="sub_type" id="option1" value="pc"
															autocomplete="off"> <spring:message
																code="a.it_ticket.f.type.support.type.pc" />

														</label> <label class="btn btn-default active"> <span
															class="fa fa-unlink"> </span> <input type="radio"
															name="sub_type" value="network" id="option2"
															autocomplete="off" checked> <spring:message
																code="a.it_ticket.f.type.support.type.network" />
														</label> 
														
														<label class="btn btn-default"> <span
															class="fa fa-envelope-o"> </span> <input type="radio"
															name="sub_type" value="email" id="option2"
															autocomplete="off"> <spring:message
																code="a.it_ticket.f.type.support.type.email" />
														</label> 
														
														<label class="btn btn-default "> <span
															class="fa fa-phone"> </span> <input type="radio"
															value="extension" name="sub_type" id="option2"
															autocomplete="off"> <spring:message
																code="a.it_ticket.f.type.support.type.extension" />
														</label>
														
														<label class="btn btn-default "> <span
															class="fa fa-print"> </span> <input type="radio"
															name="sub_type" value="printer" id="option2"
															autocomplete="off"> <spring:message
																code="a.it_ticket.f.type.support.type.printer" />
														</label><label class="btn btn-default "> <span
															class="fa fa-cubes"> </span> <input type="radio"
															name="sub_type" value="application" id="option2"
															autocomplete="off"> <spring:message
																code="a.it_ticket.f.type.support.type.application" />
														</label> <label class="btn btn-default "> <span
															class="fa fa-gear"> </span> <input type="radio"
															name="sub_type" value="other" id="option2"
															autocomplete="off"> <spring:message
																code="a.it_ticket.f.type.support.type.other" />
														</label>

													</div>

												</div>


												<spring:message code="a.it_ticket.f.title" var="title" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-file-text-o"></i></span>
													<spring:bind path="title">

														<input type="text" class="form-control custom-control"
															placeholder="${title}" name="title" />
													</spring:bind>
												</div>


												<spring:message code="a.it_ticket.f.detail" var="detail" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-file-text-o"></i></span>
													<spring:bind path="sub_type">

														<textarea class="form-control custom-control" rows="5"
															style="resize: none" placeholder="${detail}"
															name="detail"></textarea>
													</spring:bind>
												</div>

											</div>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-11 col-sm-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h3 class="panel-title">
													<spring:message code="gen.attachments" />
												</h3>
											</div>
											<div id="fine-uploader-gallery"></div>
											</div>
											</div>
											</div>

								<button type="submit" class="btn btn-lg btn-primary ">
									<spring:message code="tmplt.hdr.submit" />
									<span class="glyphicon glyphicon-send"></span>
								</button>

							</form:form>

						</p>
					</section>
				</div>




			</div>

		</div>
	</div>
	
	
	
	

	
<script src="./resources/js/jquery.fine-uploader.min.js"
	type="text/javascript">
	
	
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
    		$('#create_ticket_frm').append('<input type="hidden" name="uploads[]" value="'+response.attch_id+'" />')
    		
    	}
    }
    


});
    </script>
<!-- 



<script src="./resources/js/bootstrap-datepicker.js"
	type="text/javascript">
	
</script>

<script src="./resources/js/bootstrap-combobox.js"
	type="text/javascript">
	
</script>

 -->
<!-- 
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
 -->


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>