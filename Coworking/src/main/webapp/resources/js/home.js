var api = "localhost/ajaxsample/";
var popoverVisible = false;


$(function() {
	
	//Link Management
	$(document).on('click', '.loader', function(){
		 $('#content').load($(this).attr('href'));
		 /* Per recarregar diverses zones que no necessariament son content (div central) (exemple: pestanyes)
		  * $(this).attr("data-destination");
		  */ 
		 return false;
	});
	
		
	//Amaga el popover quan fem click a qualsevol lloc
		$("#login").click(function(e) {
			if (popoverVisible == true) {
				$("#login").popover('hide');
				//$("#login").popover('destroy');
				popoverVisible = false;
				e.stopPropagation();
			}
	        
		});
	
	//Funció pel Login
        $("#login").submit(function() {
            var data = $(this).serializeObject();
            $.ajax({
            	type: 'POST',
                url: "login",
                contentType: 'application/json',
                data: JSON.stringify(data),
                //dataType: 'json',
                success: function(retorn) {
                	//var result = JSON.parse(retorn).result; // Parsea el resultado a variable legible
                	//Actualitza un div concret (navbar right)
                	//$("#userInfo").load("resources/menuPrivat.jsp");
                	                    	
                	$(document.body).load("home.html", function(){
                		$('.dropdown-toggle').dropdown();
                	});
                },
                error: function(e) {
                	if (popoverVisible == false) {
	                	
	                	$("#login").popover({
	                		placement : 'bottom',
	                		title : 'Error',
	                	    content : 'Usuari o Contrasenya Incorrecte',
	                	    trigger : 'manual'
	                	});
	                    $("#login").popover('show');
	                    popoverVisible = true;
	                    e.stopPropagation();
	                    
                	}
                }
            });
 
            return false;
        });
        
    });


 
    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
	
