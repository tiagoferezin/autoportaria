<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<table id="tabela-pessoas" class="display" style="width: 100%">
	<thead>
		<tr>
			<th>Nome Completo</th>
			<th>Tipo</th>
			<th>CPF</th>
			<th>RG</th>
			<th>Data de Entrada</th>
			<th>Editar</th>
			<th>Deletar</th>

		</tr>
	</thead>

	<tbody>

		<c:forEach items="${listaPessoas }" var="pessoa">
			<tr data-id="${pessoa.idPessoa }">
				<td>${pessoa.nomeCompleto }</td>
				<td>${pessoa.tipoPessoa }</td>
				<td>${pessoa.cpf }</td>
				<td>${pessoa.rg }</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${pessoa.dataCriacao.time}" /></td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button"
						class="btn btn-danger btn-deletar-tabela" data-toggle="modal"
						data-target="#modalConfirmarExclusao">Deletar</button></td>
			</tr>
		</c:forEach>

	</tbody>

	<tfoot>
		<tr>
			<th>Nome Completo</th>
			<th>Tipo</th>
			<th>CPF</th>
			<th>RG</th>
			<th>Data de Entrada</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modalAlterar" style="float: right;">Cadastrar</button>
			</td>
		</tr>
	</tfoot>

</table>
