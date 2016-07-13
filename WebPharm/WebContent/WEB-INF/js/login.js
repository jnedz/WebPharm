
$(document).ready(function() {
	
	var login = false;
	checkLogin();
	function checkLogin(){
	

	login?($('#login').hide(),$('#logout').show()):($('#login').show(),$('#logout').hide())
	}

	$("#form").submit(function(){
		
		alert($('#user').val());
		
	    login = true; // you have to apply this  line in success
	    checkLogin(); // you have to apply this  line in success
	    $('#myModal').modal('hide'); // you have to apply this  line in success
	   var formdatatest= $("#form").serializeArray()
	  $.ajax({
	   type: "POST",
	   url: "/your/url",
	    data: formdatatest,
	   success: function(html){    
		   
	   },
	   error:function()
	   {

	   }
	  });
	return false;
	});	
	
           
        
});


