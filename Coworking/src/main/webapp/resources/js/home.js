$(document).ready(function() {
	
	$('#espais').on('click', 'li', /*function() {
		console.log("HOLA");
		$.post('/ajaxsample/home/espais', $(this).serialize(), function (centres) {
			$('#llistaEspais').append(
					'<li><a href = "#">' + centres.nom + '</a></li>'
			);
		});
//		e.preventDefault();
	});
	*/
		
		function(){
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


$(function(){
	$.ajax({
		url: '/home/espais',
		success: function(projects){
			console.log(projects);
			
			for(var i=0;i<projects.length;i++){
				var project = projects[i];
				$('#projects').append('<div class="col-md-6"><h2>' + project.name + '</h2><p>' + project.description + '</p></div>');
			}
		}
	});
});