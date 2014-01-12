$(document).ready(function() {
	
	$('#saveContact').submit(function(e) {
		$.post('/ajaxsample/contact/save', $(this).serialize(), function (contact) {
			$('#contactTableResponse').last().append(
					'<tr>' +
						'<td>' + contact.id + '</td>' +
						'<td>' + contact.firstName + '</td>' +
						'<td>' + contact.lastName + '</td>' +
						'<td>' + contact.age + '</td>' +
					'</tr>'
			);
		});
		
		clearInputs();
		e.preventDefault();
	});
	
});

function clearInputs() {
	$('input[id*="Input"]').each(function () {
		$(this).val('');
	});
}