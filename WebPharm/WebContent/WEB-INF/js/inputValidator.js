function getdetails(obj) {
        alert(obj.id);
        
        
        alert(document.forms["F"+obj.id]["quantity"].value);
       if (validateForm()){
    	   //alert(document.forms["F0"]);
    	   document.forms["F0"].submit();
       }
       
       else {
    	   
    	   alert("OOPS");
       }
        
        
    }


/*$(function () {

	    $("input[type=submit]").click(function () {
alert("1");
	    var id = $(this).attr('id');



	    var name = $(this).attr('name');

  });

	})*/

function validateForm() {
	
	

		
	var x1 = document.forms["1"]["quantity"].value;
	
	
	var x2 = document.forms["1"]["count"].value;


	if ( !(/^\d+$/.test(x1)) || x1 <= 0 || x1>x2) {
		alert("quantity must be only numbers: over zerro and less than count from pharmacies");
		return false;
	}

}