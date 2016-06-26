$(document).ready(function() {
        $('#userName').blur(function(event) {
                var name = $('#userName').val();
               $.get('GetUserServlet', {
                        userName : name
                }, function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
                });
            
               
                
        });
        
        

            $('#userSelect').change(function(event) {
            	
            	
            	
  alert("ddd"); $('form#form1').submit();
 // document.getElementById("form1").submit()
 /*               var userId = $("select#userSelect").val();
                
                alert("User ID :"+userId);
 */      

 });//change()               

        
            
        
});


