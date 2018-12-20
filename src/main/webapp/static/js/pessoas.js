/**
 * 
 */

$(document).ready(function() {

	aplicarListaners();
	

});

var limparModalEditar = function() {
	$('#idPessoa').val('');
	$('#primeiroNome').val('');
	$('#nomeMeio').val('');
	$('#sobrenome').val('');
	$('#rg').val('');
	$('#cpf').val('');
};
var aplicarListaners = function() {
	
	$('#tabela-pessoas').DataTable({
		dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
        destroy: true
	});
	
	$('#modalAlterar').on('hide.bs.modal', limparModalEditar);

	$('.btn-editar').click(function() {
		var idPessoa = $(this).parents('tr').data('id');
		var url = "pessoa/" + idPessoa;

		$.get(url).done(function(pessoa) {
			$('#idPessoa').val(pessoa.idPessoa);
			$('#primeiroNome').val(pessoa.primeiroNome);
			$('#nomeMeio').val(pessoa.nomeMeio);
			$('#sobrenome').val(pessoa.sobrenome);
			$('#rg').val(pessoa.rg);
			$('#cpf').val(pessoa.cpf);
			$('#tipoPessoa').val(pessoa.tipoPessoa);

			$('#modalAlterar').modal('show');
		});
	});

	$('.btn-deletar').click(function() {
		
		var idPessoa = $('.btn-deletar-tabela').parents('tr').data('id');

		$.ajax({
			url : "pessoa/" + idPessoa,
			type : 'DELETE',
			success : function(result) {
			
				$('tr[data-id="' + idPessoa + '"]').remove();
			}
		});

		$('#modalConfirmarExclusao').modal('hide');
	});

	$('#btn-salvar').click(function() {

		var url = "pessoa";
		var dadosPessoa = $('#form-pessoa').serialize();

		$.post(url, dadosPessoa).done(function(pagina) {

			$('#secao-pessoa').html(pagina);
			aplicarListaners();

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalAlterar').modal('hide');
		});

	});

};