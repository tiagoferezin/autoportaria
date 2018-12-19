<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modalAlterar" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-pessoa" method="post">
				<div class="modal-header">
				<h4 class="modal-title">Informações da Pessoa</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
				</div>
				<div class="modal-body">
					<label for="primeiroNome">Primeiro Nome: </label> <input id="primeiroNome"
						name="primeiroNome" class="form-control"> 
						<label for="nomeMeio">Nome do Meio: </label> <input id="nomeMeio"
						name="nomeMeio" class="form-control"> 
						<label for="sobrenome">Sobrenome: </label> <input id="sobrenome"
						name="sobrenome" class="form-control"> 
						<label for="cpf">CPF: </label> <input id="cpf"
						name="cpf" class="form-control">
						<label for="rg">RG: </label> <input id="rg"
						name="rg" class="form-control">
						<label for="tipoPessoa">Tipo: </label> 
						<select id="tipoPessoa" name="tipoPessoa" class="form-control">
						<c:forEach items="${listaTiposPessoa }" var="tipoPessoa">
							<option value="${tipoPessoa }">${tipoPessoa }</option>
						</c:forEach>
						</select>
					

					<input id="idPessoa" name="idPessoa" type="hidden"> <input id="csrf"
						name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-success">Salvar</button>
				</div>
			</form>
		</div>
	</div>
</div>