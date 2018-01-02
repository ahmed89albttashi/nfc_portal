<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="c_url" value="${requestScope['javax.servlet.forward.request_uri'] }" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="c_base" value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>
<base	href="${c_base}" />

<script type="text/javascript" src="./resources/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>
<c:forEach items="${js_add}" var="js" varStatus="loop">
<script type="text/javascript" src="./resources/js/${js}"></script>
</c:forEach>

<c:set var="locale" value="${pageContext.request.locale.language}" /> 

<% 
Enumeration en = request.getParameterNames();


%>
<title><spring:message code="tmplt.hdr.webname" /> :: <spring:message code="${pg_hd}"/> </title>

<link rel="stylesheet" href="./resources/fonts/amiri.css" />
<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="./resources/css/font-awesome.min.css" />


<spring:message code="tmplt.hdr.css" />

	<c:forEach var="css_item" items="${pg_css_items}" varStatus="loop">
	<link rel="stylesheet" href="./resources/css/<c:out value="${css_item}"></c:out>"/>
	</c:forEach>



            <link href="./resources/img/mainTemplate/favicon.png" rel="shortcut icon" >
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">


</head>
<body>
	<div class="container">

		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">
					<!--  <img src="./resources/img/mainTemplate/headerSiteIcon.png" width="40"> -->
					<!-- <img src="./resources/img/mainTemplate/logo.png" height="30px"> -->
					<b><i>&nbsp; <spring:message code="tmplt.hdr.webname"/> &nbsp; </i></b> 
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">


					<li class="dropdown active"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-expanded="false"><spring:message code="${pg_app_name}"/> <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<c:forEach items="${pg_menu}" var="item">
								<li><a href="${item[1]}"><spring:message code="${item[0]}"/> </a></li>
							</c:forEach>


						</ul></li>


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><spring:message code="tmplt.apps" />  <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="./a/itTicket/"><spring:message code="tmplt.apps.it_ticket" /></a></li>
							<li class="divider"></li>
							<%-- <li><a href="./a/itTicket/"><spring:message code="tmplt.apps.it_ticket" /></a></li>
							<li><a href="./admin/"><spring:message code="tmplt.apps.admin" /></a></li>
							<li><a href="./a/mail_reference/"><spring:message code="tmplt.apps.mail_reference" /></a></li>
							<li><a href="#"><spring:message code="tmplt.apps.admin_contract" /></a></li>
							<li><a href="#"><spring:message code="tmplt.apps.car_management" /></a></li>
							<li class="divider"></li>
							<li><a href="./a/bdMailer/"><spring:message code="tmplt.apps.bd_mailer" /></a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li> --%>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="<spring:message code="tmplt.hdr.search"/>">
					</div>
					<button type="submit" class="btn btn-default"><spring:message code="tmplt.hdr.submit"/></button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					
	
					<li class="dropdown"><a href="#" class="dropdown-toggle fa fa-globe"
						data-toggle="dropdown" role="button" aria-expanded="false">
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
						
						
							<li><a href="${c_url}?locale=ar">عربي</a></li>
							<li><a href="${c_url}?locale=en">English</a></li>
						</ul></li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle glyphicon glyphicon-user"
						data-toggle="dropdown" role="button" aria-expanded="false">
						<sec:authorize access="isAuthenticated()"> 
						<sec:authentication property="principal.username" />
						
						<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
									
			<sec:authorize access="@a1SecurityService.canAccessAdmin(authentication)">
			
							<li><a href="./sysAdmin/" ><spring:message code="sys.admin"/></a></li>
			</sec:authorize>
							<li><a href="./sec/logout/" ><spring:message code="tmplt.hdr.signout"/></a></li>
							<li><a href="./sec/change_password/" ><spring:message code="sec.change_pass"/></a></li>
						</ul></li>
						
						</sec:authorize>
						
			
						<sec:authorize access="isAnonymous()"> 
						<spring:message code="tmplt.hdr.account"/>
						
						<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="./sec/login/"><spring:message code="tmplt.hdr.signin"/></a></li>
							<!-- <li class="divider"></li> -->
						</ul></li>
						</sec:authorize>

							
				</ul>
			</div>
		</div>





		<!-- logout function linked to <A> in links -->
		<form id="logoutForm"
			action="<c:url value="/j_spring_security_logout" />" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>


		

		<script>
			function logout() {
				document.getElementById("logoutForm").submit();
			}
		</script> <!-- /.container-fluid --> </nav>
		
		<ol class="breadcrumb">
	<c:set value="1" var="nav_i" scope="page" />

	<c:forEach var="nav" items="${pg_nav}" varStatus="loop">


		<c:choose>
			<c:when test="${fn:length(pg_nav) eq nav_i}">


				<li class="active" style="font-weight: bold;"> <spring:message code="${nav[0]}" /> </li>

			</c:when>
			<c:otherwise>

				<li><a href="${nav[1] }"><spring:message code="${nav[0]}" /></a></li>
			</c:otherwise>

		</c:choose>


		<c:set value="${nav_i+1}" var="nav_i" scope="page" />

	</c:forEach>
</ol>


<%-- 
<div class="page-header">
	<h1>
		${pg_hd} <span class="label label-info"></span>
	</h1>
</div> --%>

		