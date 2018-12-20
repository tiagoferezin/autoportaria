<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo}</title>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
	
	<jsp:include page="../head.jsp" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css">


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
		
		
	<main class="pt-5 mx-lg-5">
	<div class="container-fluid mt-5">

		<div class="card mb-4 wow fadeIn animated"
			style="visibility: visible; animation-name: fadeIn;">

			<div class="card-body d-sm-flex justify-content-between">
				<h4 class="mb-2 mb-sm-0 pt-1">
					<a href="#">Home</a> <span>/</span> <span>${titulo }</span>
				</h4>
			</div>

		</div>

		<div class="row wow fadeIn animated"
			style="visibility: visible; animation-name: fadeIn;">
			<div class="col-md-9 mb-4">
				<div class="card">
					<div class="card-body">

						<section class="container" id="secao-pessoas">
							<jsp:include page="tabelaPessoa.jsp" />
						</section>

					</div>
				</div>
			</div>
		</div>

		<jsp:include page="modalAlterar.jsp" />

		<jsp:include page="modalConfirmarExclusao.jsp" />

	</div>
	</main>

	<section class="footer fixed-bottom" id="secao-footer"> <jsp:include
		page="../footer.jsp" /> </section>

	<script type="text/javascript" src="${path}/static/js/navbar.js"></script>
<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

	<script
		src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.flash.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>


	<!-- Popper JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="${path}/static/js/pessoas.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

</body>
</html>