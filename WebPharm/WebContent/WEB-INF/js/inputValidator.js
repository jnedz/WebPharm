function getdetails(obj) {
	
 
     var x1 = document.forms["F" + obj.id]["quantity"].value;
       
     var x2 = document.forms["F" + obj.id]["count"].value;
     

     if ( !(/^\d+$/.test(x1)) || x1 <= 0 || x1>x2) {
      alert("quantity must be only numbers: over zerro and less than count from pharmacies");
      return false;
     }
     
    else{
//     alert("OK");
      document.forms["F"+obj.id].submit();
      
     }
        
        
    }
