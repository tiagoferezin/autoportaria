<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
	<jsp:include page="../head.jsp" />
</head>
<body>
	</br>
	<c:if test="${not empty mensagemErro }">
		<div class="container">

			<div class="alert alert-danger">${mensagemErro }</div>

		</div>
	</c:if>

	<c:if test="${not empty mensagemInfo }">
		<div class="container">

			<div class="alert alert-info">${mensagemInfo }</div>

		</div>
	</c:if>

	<section class="header" id="secao-header"> <jsp:include
		page="../header.jsp" /> </section>

	<h1>Olá Mundo!!!</h1>

	<section class="footer" id="secao-footer"> <jsp:include
		page="../footer.jsp" /> </section>

	<script type="text/javascript" src="${path}/static/js/navbar.js"></script>
	 <!-- Compiled and minified JavaScript -->
    </body>
</html>