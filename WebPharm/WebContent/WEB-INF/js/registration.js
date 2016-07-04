
function show_form() 
{ 
var d = document;  
var a = d.getElementById('div_form').style.display; 
d.getElementById('div_form').style.display = (a == 'none')?'block':'none'; 
d.getElementById('sp_sel').innerHTML = (a == 'none')?'<img src="img/close.png" alt="Close" width="10" height="10" style="vertical-align: center">':'Registration';  
} 


function show_form2() 
{ 
var d = document;  
var a = d.getElementById('div_form2').style.display; 
d.getElementById('div_form2').style.display = (a == 'none')?'block':'none'; 
d.getElementById('sp_sel2').innerHTML = (a == 'none')?'<img src="img/close.png" alt="Close" width="10" height="10" style="vertical-align: center">':'Enter';  
} 
