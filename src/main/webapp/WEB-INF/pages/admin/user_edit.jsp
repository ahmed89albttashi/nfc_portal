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
				<strong> Register <i class="fa fa-user"></i>
				</strong>
			</div>

			<div class="panel-body">
				<div id="emp_steps_body"></div>

				<div id="emp_steps">
					<section>
						<p>
							<form role="form" action="./sysAdmin/users/edit/done/"
								method="post" >
								

								<div class="panel-body"></div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								
								
								<form:hidden  path="user.user_id"
									value="${user.user_id}" />
								<br>
								<div class="row">
								
								<form:errors path="*" class="error alert alert-danger alert-error" element="div" />
												
												
									<div class="col-md-5 col-sm-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												<h3 class="panel-title">Account Detail</h3>
											</div>
											<div class="panel-body">


												<form:errors path="user.email"
													class="error alert alert-danger alert-error" element="div" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i class="fa fa-at"></i></span>

													<form:input type="text" class="form-control" disabled=""
														placeholder="Email" path="user.email" required="required" />


												</div>


												<form:errors path="user.staff.staff_id"
													class="error alert alert-danger alert-error" element="div" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-user"></i></span>
													<form:input type="text" class="form-control"
														placeholder="Staff ID" path="user.staff.staff_id" />
												</div>

											</div>
										</div>
									</div>




								</div>

								<hr>
								<div class="row">

									<div class="col-md-5 col-sm-12">

										<div class="panel panel-info">
											<div class="panel-heading">
												<h3 class="panel-title">Personal Information</h3>
											</div>
											<div class="panel-body">

												<form:errors path="user.staff.fullName_en"
													class="error alert alert-danger alert-error" element="div" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-circle-o-notch glyphicon glyphicon-user"></i></span>
													<form:input type="text" class="form-control"
														placeholder="Name" path="user.staff.fullName_en" />
												</div>

												<form:errors path="user.staff.fullName_ar"
													class="error alert alert-danger alert-error" element="div" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-circle-o-notch glyphicon glyphicon-user"></i></span>
													<form:input type="text" class="form-control"
														placeholder="Name (Arabic)" path="user.staff.fullName_ar" />
												</div>

												<form:errors path="user.staff.gender"
													class="error alert alert-danger alert-error" element="div" />
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-venus"></i></span>



													<div class="btn-group" data-toggle="buttons">
														<label class="btn btn-default "> 
														<form:radiobutton path ="user.staff.gender" value="male" id="gender" /> Male
														</label> <label class="btn btn-default"> 
														<form:radiobutton path ="user.staff.gender" value="female" id="gender" /> Female
														</label>

													</div>

												</div>

												<%-- 
												<form:errors path="name"
													class="error alert alert-danger alert-error" element="div" /> --%>
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-circle-thin"></i></span>



													<div class="btn-group" data-toggle="buttons">
														<label class="btn btn-default " id="married_true">
															<form:radiobutton path="user.staff.status"  value="married" id="status"/> Married
														</label> <label class="btn btn-default" id="married_false">
															
															<form:radiobutton path="user.staff.status"  value="single" id="status"/> Single
														</label>

													</div>

												</div>

												<hr><%-- 
												<form:errors path="user.staff.dob"
													class="error alert alert-danger alert-error" element="div" />
												<div class="form-group input-group fuelux">
													<span class="input-group-addon"><i
														class="fa fa-calendar-o"></i></span>

													<form:input type="text" class="form-control"
														placeholder="Date of Birth" path="user.staff.dob" />

												</div> --%>


												<div class="form-group input-group">

													<span class="input-group-addon"><i
														class="fa fa-globe"></i></span> 
														<form:select
														class="combobox form-control" style="display: none;" path="user.staff.nationality" >
														<option value="${user.staff.nationality}" selected="selected">${user.staff.nationality}</option>
														<option value="Afghanistan">Afghanistan</option>
														<option value="Albania">Albania</option>
														<option value="Algeria">Algeria</option>
														<option value="American Samoa">American Samoa</option>
														<option value="Andorra">Andorra</option>
														<option value="Angola">Angola</option>
														<option value="Anguilla">Anguilla</option>
														<option value="Antartica">Antarctica</option>
														<option value="Antigua and Barbuda">Antigua and
															Barbuda</option>
														<option value="Argentina">Argentina</option>
														<option value="Armenia">Armenia</option>
														<option value="Aruba">Aruba</option>
														<option value="Australia">Australia</option>
														<option value="Austria">Austria</option>
														<option value="Azerbaijan">Azerbaijan</option>
														<option value="Bahamas">Bahamas</option>
														<option value="Bahrain">Bahrain</option>
														<option value="Bangladesh">Bangladesh</option>
														<option value="Barbados">Barbados</option>
														<option value="Belarus">Belarus</option>
														<option value="Belgium">Belgium</option>
														<option value="Belize">Belize</option>
														<option value="Benin">Benin</option>
														<option value="Bermuda">Bermuda</option>
														<option value="Bhutan">Bhutan</option>
														<option value="Bolivia">Bolivia</option>
														<option value="Bosnia and Herzegowina">Bosnia and
															Herzegowina</option>
														<option value="Botswana">Botswana</option>
														<option value="Bouvet Island">Bouvet Island</option>
														<option value="Brazil">Brazil</option>
														<option value="British Indian Ocean Territory">British
															Indian Ocean Territory</option>
														<option value="Brunei Darussalam">Brunei
															Darussalam</option>
														<option value="Bulgaria">Bulgaria</option>
														<option value="Burkina Faso">Burkina Faso</option>
														<option value="Burundi">Burundi</option>
														<option value="Cambodia">Cambodia</option>
														<option value="Cameroon">Cameroon</option>
														<option value="Canada">Canada</option>
														<option value="Cape Verde">Cape Verde</option>
														<option value="Cayman Islands">Cayman Islands</option>
														<option value="Central African Republic">Central
															African Republic</option>
														<option value="Chad">Chad</option>
														<option value="Chile">Chile</option>
														<option value="China">China</option>
														<option value="Christmas Island">Christmas Island</option>
														<option value="Cocos Islands">Cocos (Keeling)
															Islands</option>
														<option value="Colombia">Colombia</option>
														<option value="Comoros">Comoros</option>
														<option value="Congo">Congo</option>
														<option value="Congo">Congo, the Democratic
															Republic of the</option>
														<option value="Cook Islands">Cook Islands</option>
														<option value="Costa Rica">Costa Rica</option>
														<option value="Cota D'Ivoire">Cote d'Ivoire</option>
														<option value="Croatia">Croatia (Hrvatska)</option>
														<option value="Cuba">Cuba</option>
														<option value="Cyprus">Cyprus</option>
														<option value="Czech Republic">Czech Republic</option>
														<option value="Denmark">Denmark</option>
														<option value="Djibouti">Djibouti</option>
														<option value="Dominica">Dominica</option>
														<option value="Dominican Republic">Dominican
															Republic</option>
														<option value="East Timor">East Timor</option>
														<option value="Ecuador">Ecuador</option>
														<option value="Egypt">Egypt</option>
														<option value="El Salvador">El Salvador</option>
														<option value="Equatorial Guinea">Equatorial
															Guinea</option>
														<option value="Eritrea">Eritrea</option>
														<option value="Estonia">Estonia</option>
														<option value="Ethiopia">Ethiopia</option>
														<option value="Falkland Islands">Falkland Islands
															(Malvinas)</option>
														<option value="Faroe Islands">Faroe Islands</option>
														<option value="Fiji">Fiji</option>
														<option value="Finland">Finland</option>
														<option value="France">France</option>
														<option value="France Metropolitan">France,
															Metropolitan</option>
														<option value="French Guiana">French Guiana</option>
														<option value="French Polynesia">French Polynesia</option>
														<option value="French Southern Territories">French
															Southern Territories</option>
														<option value="Gabon">Gabon</option>
														<option value="Gambia">Gambia</option>
														<option value="Georgia">Georgia</option>
														<option value="Germany">Germany</option>
														<option value="Ghana">Ghana</option>
														<option value="Gibraltar">Gibraltar</option>
														<option value="Greece">Greece</option>
														<option value="Greenland">Greenland</option>
														<option value="Grenada">Grenada</option>
														<option value="Guadeloupe">Guadeloupe</option>
														<option value="Guam">Guam</option>
														<option value="Guatemala">Guatemala</option>
														<option value="Guinea">Guinea</option>
														<option value="Guinea-Bissau">Guinea-Bissau</option>
														<option value="Guyana">Guyana</option>
														<option value="Haiti">Haiti</option>
														<option value="Heard and McDonald Islands">Heard
															and Mc Donald Islands</option>
														<option value="Holy See">Holy See (Vatican City
															State)</option>
														<option value="Honduras">Honduras</option>
														<option value="Hong Kong">Hong Kong</option>
														<option value="Hungary">Hungary</option>
														<option value="Iceland">Iceland</option>
														<option value="India">India</option>
														<option value="Indonesia">Indonesia</option>
														<option value="Iran">Iran (Islamic Republic of)</option>
														<option value="Iraq">Iraq</option>
														<option value="Ireland">Ireland</option>
														<option value="Israel">Israel</option>
														<option value="Italy">Italy</option>
														<option value="Jamaica">Jamaica</option>
														<option value="Japan">Japan</option>
														<option value="Jordan">Jordan</option>
														<option value="Kazakhstan">Kazakhstan</option>
														<option value="Kenya">Kenya</option>
														<option value="Kiribati">Kiribati</option>
														<option value="Democratic People's Republic of Korea">Korea,
															Democratic People's Republic of</option>
														<option value="Korea">Korea, Republic of</option>
														<option value="Kuwait">Kuwait</option>
														<option value="Kyrgyzstan">Kyrgyzstan</option>
														<option value="Lao">Lao People's Democratic
															Republic</option>
														<option value="Latvia">Latvia</option>
														<option value="Lebanon">Lebanon</option>
														<option value="Lesotho">Lesotho</option>
														<option value="Liberia">Liberia</option>
														<option value="Libyan Arab Jamahiriya">Libyan
															Arab Jamahiriya</option>
														<option value="Liechtenstein">Liechtenstein</option>
														<option value="Lithuania">Lithuania</option>
														<option value="Luxembourg">Luxembourg</option>
														<option value="Macau">Macau</option>
														<option value="Macedonia">Macedonia, The Former
															Yugoslav Republic of</option>
														<option value="Madagascar">Madagascar</option>
														<option value="Malawi">Malawi</option>
														<option value="Malaysia">Malaysia</option>
														<option value="Maldives">Maldives</option>
														<option value="Mali">Mali</option>
														<option value="Malta">Malta</option>
														<option value="Marshall Islands">Marshall Islands</option>
														<option value="Martinique">Martinique</option>
														<option value="Mauritania">Mauritania</option>
														<option value="Mauritius">Mauritius</option>
														<option value="Mayotte">Mayotte</option>
														<option value="Mexico">Mexico</option>
														<option value="Micronesia">Micronesia, Federated
															States of</option>
														<option value="Moldova">Moldova, Republic of</option>
														<option value="Monaco">Monaco</option>
														<option value="Mongolia">Mongolia</option>
														<option value="Montserrat">Montserrat</option>
														<option value="Morocco">Morocco</option>
														<option value="Mozambique">Mozambique</option>
														<option value="Myanmar">Myanmar</option>
														<option value="Namibia">Namibia</option>
														<option value="Nauru">Nauru</option>
														<option value="Nepal">Nepal</option>
														<option value="Netherlands">Netherlands</option>
														<option value="Netherlands Antilles">Netherlands
															Antilles</option>
														<option value="New Caledonia">New Caledonia</option>
														<option value="New Zealand">New Zealand</option>
														<option value="Nicaragua">Nicaragua</option>
														<option value="Niger">Niger</option>
														<option value="Nigeria">Nigeria</option>
														<option value="Niue">Niue</option>
														<option value="Norfolk Island">Norfolk Island</option>
														<option value="Northern Mariana Islands">Northern
															Mariana Islands</option>
														<option value="Norway">Norway</option>
														<option value="Oman">Oman</option>
														<option value="Pakistan">Pakistan</option>
														<option value="Palau">Palau</option>
														<option value="Panama">Panama</option>
														<option value="Papua New Guinea">Papua New Guinea</option>
														<option value="Paraguay">Paraguay</option>
														<option value="Peru">Peru</option>
														<option value="Philippines">Philippines</option>
														<option value="Pitcairn">Pitcairn</option>
														<option value="Poland">Poland</option>
														<option value="Portugal">Portugal</option>
														<option value="Puerto Rico">Puerto Rico</option>
														<option value="Qatar">Qatar</option>
														<option value="Reunion">Reunion</option>
														<option value="Romania">Romania</option>
														<option value="Russia">Russian Federation</option>
														<option value="Rwanda">Rwanda</option>
														<option value="Saint Kitts and Nevis">Saint Kitts
															and Nevis</option>
														<option value="Saint LUCIA">Saint LUCIA</option>
														<option value="Saint Vincent">Saint Vincent and
															the Grenadines</option>
														<option value="Samoa">Samoa</option>
														<option value="San Marino">San Marino</option>
														<option value="Sao Tome and Principe">Sao Tome
															and Principe</option>
														<option value="Saudi Arabia">Saudi Arabia</option>
														<option value="Senegal">Senegal</option>
														<option value="Seychelles">Seychelles</option>
														<option value="Sierra">Sierra Leone</option>
														<option value="Singapore">Singapore</option>
														<option value="Slovakia">Slovakia (Slovak
															Republic)</option>
														<option value="Slovenia">Slovenia</option>
														<option value="Solomon Islands">Solomon Islands</option>
														<option value="Somalia">Somalia</option>
														<option value="South Africa">South Africa</option>
														<option value="South Georgia">South Georgia and
															the South Sandwich Islands</option>
														<option value="Span">Spain</option>
														<option value="SriLanka">Sri Lanka</option>
														<option value="St. Helena">St. Helena</option>
														<option value="St. Pierre and Miguelon">St.
															Pierre and Miquelon</option>
														<option value="Sudan">Sudan</option>
														<option value="Suriname">Suriname</option>
														<option value="Svalbard">Svalbard and Jan Mayen
															Islands</option>
														<option value="Swaziland">Swaziland</option>
														<option value="Sweden">Sweden</option>
														<option value="Switzerland">Switzerland</option>
														<option value="Syria">Syrian Arab Republic</option>
														<option value="Taiwan">Taiwan, Province of China</option>
														<option value="Tajikistan">Tajikistan</option>
														<option value="Tanzania">Tanzania, United
															Republic of</option>
														<option value="Thailand">Thailand</option>
														<option value="Togo">Togo</option>
														<option value="Tokelau">Tokelau</option>
														<option value="Tonga">Tonga</option>
														<option value="Trinidad and Tobago">Trinidad and
															Tobago</option>
														<option value="Tunisia">Tunisia</option>
														<option value="Turkey">Turkey</option>
														<option value="Turkmenistan">Turkmenistan</option>
														<option value="Turks and Caicos">Turks and Caicos
															Islands</option>
														<option value="Tuvalu">Tuvalu</option>
														<option value="Uganda">Uganda</option>
														<option value="Ukraine">Ukraine</option>
														<option value="United Arab Emirates">United Arab
															Emirates</option>
														<option value="United Kingdom">United Kingdom</option>
														<option value="United States">United States</option>
														<option value="United States Minor Outlying Islands">United
															States Minor Outlying Islands</option>
														<option value="Uruguay">Uruguay</option>
														<option value="Uzbekistan">Uzbekistan</option>
														<option value="Vanuatu">Vanuatu</option>
														<option value="Venezuela">Venezuela</option>
														<option value="Vietnam">Viet Nam</option>
														<option value="Virgin Islands (British)">Virgin
															Islands (British)</option>
														<option value="Virgin Islands (U.S)">Virgin
															Islands (U.S.)</option>
														<option value="Wallis and Futana Islands">Wallis
															and Futuna Islands</option>
														<option value="Western Sahara">Western Sahara</option>
														<option value="Yemen">Yemen</option>
														<option value="Yugoslavia">Yugoslavia</option>
														<option value="Zambia">Zambia</option>
														<option value="Zimbabwe">Zimbabwe</option>

													</form:select>
												</div>



<%-- 
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-flag"></i></span> <input type="text"
														class="form-control" placeholder="Live in" name="staff.live_in">
												</div>

												<hr>

												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-plus-square"></i></span> <input type="text"
														class="form-control" placeholder="ID Number" name="staff.id_number">
												</div>
<!-- 
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-plus-square"></i></span> <input type="text"
														class="form-control" placeholder="Passport Number">
												</div>



												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-calendar"></i></span> <input id="join_on"
														type="text" class="form-control"
														placeholder="Passport Expiry Date">
												</div>
 -->

											</div>
										</div>


									</div>


									<div class="col-md-5 col-sm-12">


										<div class="panel panel-info">
											<div class="panel-heading">
												<h3 class="panel-title">Orginization</h3>
											</div>
											<div class="panel-body">


												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-calendar"></i></span> <input id="join_on"
														type="text" class="form-control" placeholder="Join on">
												</div>



												<div class="form-group input-group">

											<span class="input-group-addon"><i
														class="fa fa-level-up"></i></span> <select
														class="combobox form-control" style="display: none;">
														<option value="" selected="selected">Grade</option>
														<option value='M1'>M1</option>
														<option value='M2'>M2</option>
														<option value='M3'>M3</option>
														<option value='M4'>M4</option>
														<option value='M5'>M5</option>
														<option value='S1'>S1</option>
														<option value='S2'>S2</option>
														<option value='S3'>S3</option>
														<option value='S4'>S4</option>
														<option value='S5'>S5</option>
														<option value='S6'>S6</option>
														<option value='S7'>S7</option>
														<option value='S8'>S8</option>
														<option value='SP'>SP</option>
														<option value='Z'>Z</option>

														</select>
														
														</div>
														
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-level-up"></i></span> <input type="text"
														class="form-control" placeholder="grade">
												</div>

												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-briefcase"></i></span> <input type="text"
														class="form-control" placeholder="Position">
												</div>

												<hr>
												<div class="form-group input-group">

													<span class="input-group-addon"><i
														class="fa fa-th-large"></i></span> <select
														class="combobox form-control" style="display: none;" name="staff.department">
														<option value="" selected="selected">Department</option>
														
														<c:forEach var="dep" items="${depts}">
															<option value="${dep.getDepartment_id()}">${dep.getName_en()}</option>
														</c:forEach>
														
														<option value="Afghanistan">Information
															Technology</option>
														<option value="Albania">Human Resources</option>
														<option value="Algeria">Account</option>
													</select>
												</div>



												<div class="form-group input-group">

													<span class="input-group-addon"><i
														class="fa fa-user"></i></span> <select
														class="combobox form-control" style="display: none;" name = "staff.manager" path="staff.manager">
														
															
														<c:forEach var="stf" items="${staffs}">
															<option value="${stf.getStaff_id()}">${stf.getFullName_en()}</option>
														</c:forEach>
														
													</select>
												</div>

												<hr>
												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-map-marker"></i></span> <select
														class="combobox form-control" style="display: none;">
														<option value="" selected="selected">WorkPlace</option>
														<option value="Afghanistan">Head Office</option>
														<option value="Albania">Call Center - Muscat</option>
														<option value="Albania">Reservation Office -
															Shannah</option>
														<option value="Albania">Reservation Office -
															Khassab</option>
														<option value="Albania">Reservation Office -
															Shinas</option>
														<option value="Albania">Reservation Office -
															Masirah</option>
														<option value="Albania">Ferries</option>
														<option value="Albania">Ware House</option>
													</select>
												</div>


												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-phone"></i></span> <input type="text"
														class="form-control" placeholder="Telephone" name="telephone">
												</div>


												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-mobile"></i></span> <input type="text"
														class="form-control" placeholder="Mobile" name="mobile">
												</div>


												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-mobile"></i></span> <input type="text"
														class="form-control" placeholder="CPN" name="cpn">
												</div>





												<div class="form-group input-group">
													<span class="input-group-addon"><i
														class="fa fa-check-square-o"></i></span>

 --%>

													<div class="btn-group" data-toggle="buttons">
														<label class="btn btn-default "> 
														<form:radiobutton path="user.enabled"  name="user.enabled" id="enabled"
															   value="true" /> Enable
														</label> 
														
														<label class="btn btn-default"> 
														<form:radiobutton  
															  value="false" path="user.enabled" name="user.enabled" id="enabled"/> Disable
														</label>

													</div>

												</div>



											</div>
										</div>

									</div>

								</div>


								<hr>
						</p>
					</section>

					<section id="step_family_sec">
						<p>

							<button type="submit" class="btn btn-lg btn-primary ">
								Publish <span class="glyphicon glyphicon-send"></span>
							</button>

							</form>

						</p>
					</section>


				</div>




			</div>

		</div>
	</div>


</div>




<script src="./resources/js/bootstrap-datepicker.js"
	type="text/javascript">
	
</script>

<script src="./resources/js/bootstrap-combobox.min.js"
	type="text/javascript">
	
</script>
<!-- 
<script src="./resources/js/jquery.uploadfile.min.js"
	type="text/javascript">
	
</script> -->
<!-- 
<script src="./resources/js/jquery.steps.min.js" type="text/javascript">
	
</script> -->


<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#dob , #join_on").each(function() {
							$(this).datepicker({
								allowPastDates : true,
								format : 'dd/mm/yyyy'
							});
						});

						$('.combobox').combobox();
						/* 
						 //Upload files configuration 

						 var settings = {
						 url : "upload.php",
						 dragDrop : true,
						 fileName : "myfile",
						 allowedTypes : "jpg,png,gif,doc,pdf,zip",
						 returnType : "json",
						 onSuccess : function(files, data, xhr) {
						 // alert((data));
						 },
						 showDelete : true,
						 deleteCallback : function(data, pd) {
						 for (var i = 0; i < data.length; i++) {
						 $.post("delete.php", {
						 op : "delete",
						 name : data[i]
						 }, function(resp, textStatus, jqXHR) {
						 //Show Message  
						 $("#status").append("<div>File Deleted</div>");
						 });
						 }
						 pd.statusbar.hide(); //You choice to hide/not.

						 }
						 }
						 var uploadObj = $("#mulitplefileuploader").uploadFile(settings);
						 */

						$('#employee_file_in_list li a')
								.on(
										"click",
										function() {
											var li_wo_sp = $(this).text()
													.replace(/\s/g, "");

											var div = $('<div>')
													.attr(
															{
																class : 'form-group input-group'
															});

											var inp = $('<input>').attr({
												type : 'file',
												id : 'foo',
												name : 'bar'
											});

											var spn = $('<span>')
													.attr(
															{
																class : 'btn btn-default btn-file'
															}).append(
															$(this).text())
													.append(inp);
											div.append(spn);
											//appendTo('#employee_files');

											$(
													'<div class="input-group input-file"> <div class="form-control"> <a href="/path/to/your/current_file_name.pdf" target="_blank"> </a> </div> <span class="input-group-addon"> <a class="btn btn-primary" href="javascript:;"> '
															+ $(this).text()
															+ ' <input type="file" name="'
															+ li_wo_sp
															+ '" id ="doc_in_'
															+ li_wo_sp
															+ '" onchange="$(this).parent().parent().parent().find(\'.form-control\').html( /[^/|^\]*$/.exec($(this).val())[0]);"> </a> </span> </div><br>')
													.appendTo('#employee_files');

											$(this).remove();
											$('#doc_in_' + li_wo_sp).click();

											var doc_count = $('.badge').html();
											doc_count++;
											$('.badge').html(doc_count);

										});
						/* 
						var wizard = $("#emp_steps").steps({
							headerTag : "h3",
							bodyTag : "section",
							transitionEffect : "slideLeft",
							autoFocus : true
						});
						 */
						/* //marry -> hide #step_family
						$("#married_false").on("click",function(){
							$('#emp_steps-t-2').hide();
						});
						$("#married_true").on("click",function(){
							$('#emp_steps-t-2').show();
						}); */

						/* $("#emp_steps > h3").each(function(){
							$("<span id=\"emp_steps_tab\" class='bg-primary'>"+$(this).text()+"</span>").appendTo("#emp_steps_head");
							//$("#emp_steps_head").append($(this).text());
							//alert($(this).text());
							$(this).remove();
						}); */

					});
	
	$(document)
	.ready(
			function() {

				$('#status[value="${user.staff.status}"]').parent().addClass("active");

				$('#gender[value="${user.staff.gender}"]').parent().addClass("active");
				
				$('#enabled[value="${user.enabled}"]').parent().addClass("active");
				
			});
</script>





<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>

