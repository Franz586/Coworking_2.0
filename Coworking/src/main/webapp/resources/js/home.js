var api = "localhost/ajaxsample/";
var popoverVisible = false;


$(function() {
	
	//Link Management
	$(document).on('click', '.loader', function(){
		 console.log($(this));
		 $('#content').load($(this).attr('href'));
		 /* Per recarregar diverses zones que no necessariament son content (div central) (exemple: pestanyes)
		  * $(this).attr("data-destination");
		  */ 
		 return false;
	});
	
		
	//Amaga el popover quan fem click a qualsevol lloc
		//$(document).on('click', function(e) {
	        //$("#login").popover('hide');
	        
		//}); 
	
	//Funció pel Login
        $("#login").submit(function() {
        	console.log("AJAX Login");
            var data = $(this).serializeObject();
            $.ajax({
            	type: 'POST',
                url: "login",
                contentType: 'application/json',
                data: JSON.stringify(data),
                //dataType: 'json',
                success: function(retorn) {
                	console.log(retorn);
                	var result = JSON.parse(retorn).result;
                    if (result.loguejat) {
                    	//Actualitza un div concret (navbar right)
                    	
                    	//$("#userInfo").load("resources/menuPrivat.jsp");
                    	
                    	$(document.body).load("home.html", function(){
                    		$('.dropdown-toggle').dropdown();
                    	});
                    
                        //location.href="postLogin";
                    } else {
                    	
                    }
                },
                error: function() {
                	console.log("error");
                	$("#login").popover({
                		placement : 'bottom',
                		title : 'Error',
                        content : 'Usuari o Contrasenya Incorrecte',
                	});
                    $("#login").popover('show');
                }
            });
 
            return false;
        });
        
      //Funció pel Logout
        $("#logout").submit(function() {
        	console.log("AJAX Logout");
            var data = $(this).serializeObject();
            $.ajax({
            	type: 'POST',
                url: "logout",
                contentType: 'application/json',
                data: JSON.stringify(data),
                //dataType: 'json',
                
                success: function(retorn) {
                	$(document.body).load("home.html", function(){
                		$('.dropdown-toggle').dropdown();
                	});
                },
                error: function() {
                	console.log("error");
                	
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
	
