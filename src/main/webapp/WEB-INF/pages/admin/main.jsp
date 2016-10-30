<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/WEB-INF/pages/mainTemplate/header.jsp"%>


<c:forEach items="${users}" var="u">

${u.getName()}

</c:forEach>


<%@ include file="/WEB-INF/pages/mainTemplate/footer.jsp"%>

