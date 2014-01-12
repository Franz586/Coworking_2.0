$("#saveUser").validate({
			showErrors: function(errorMap, errorList) {
			 
				// Clean up any tooltips for valid elements
				$.each(this.validElements(), function (index, element) {
					var $element = $(element);
					 
					$element.data("title", "") // Clear the title - there is no error associated anymore
					.removeClass("error")
					.tooltip("destroy");
				});
				 
				// Create new tooltips for invalid elements
				$.each(errorList, function (index, error) {
					var $element = $(error.element);
					 
					$element.tooltip("destroy") // Destroy any pre-existing tooltip so we can repopulate with new tooltip content
					.data("title", error.message)
					.addClass("error")
					.tooltip(); // Create a new tooltip based on the error messsage we just set in the title
				});
			},
			 
			submitHandler: function(form) {
				console.log("AJAX Register");
	            var data = $(this).serializeObject();
	            $.ajax({
	            	type: 'POST',
	                url: "saveUser",
	                contentType: 'application/json',
	                data: JSON.stringify(data),
	                //dataType: 'json',
	                success: function(retorn) {
	                	console.log(retorn);
	                	//var result = JSON.parse(retorn).result; // Parsea el resultado a variable legible
	                	//Actualitza un div concret (navbar right)
	                	//$("#userInfo").load("resources/menuPrivat.jsp");
	                	                    	
	                	$(document.body).load("home.html", function(){
	                		$('.dropdown-toggle').dropdown();
	                	});
	                }
				});
	            return false;
			}
		});