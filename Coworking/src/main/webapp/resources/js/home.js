

$(document).ready(function() {
	
	
	//INUTIL, Funciona por el atributo que le añadimos al model desde el otro lado
	$('#espais').on('click', 'li', function(){
		$.ajax({
				url: '/home/espais',
				success: function(centres){
					console.log(centres);
					
					for(var i=0;i<centres.length;i++){
						var centre = centres[i];
						$('#llistaEspais').append('<li><a href = "#">' + centre.nom + '</a></li>');
					}
				}
		});
	});
	
	
	// Carga los espacios de la página inicial
	
	
});
	
