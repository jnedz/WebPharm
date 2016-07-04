/*function validateLogin(login) {
    var reurl = /^(?=.{3,20})[a-z][a-z0-9]*[._-]?[a-z0-9]+$/;
    return reurl.test(url);
}

function validateForm()
{
    // Validate Login
    var login = $("#frlogin").val();
    if (validateLogin(login)) { } else {
        alert("Please enter a valid login");
    }

    // Validate Name
    var name = $("#frname").val();
    if (name!=="" || name!==null) { } else {
        alert("Please enter only alphanumeric values");
    }

    // Validate Password
    var password = $("#frpassword").val();
    if ((/^(?=.{3,20})[a-z][a-z0-9]*[._-]?[a-z0-9]+$/.test(password)) || password=="" || password==null) { } else {
        alert("Please enter a valid password");
    }
  return false;
}
*/


function validateForm() {
    var x1 = document.forms["myForm"]["login"].value;
    if (x1.length>=20 || x1.length<=3) {
        alert("Name must be filled out (3-20 symbols)");
        return false;
    }
    var x2 = document.forms["myForm"]["password"].value;
    if (x2.length>=25 || x2.length<=3) {
        alert("password must be filled out (3-25 symbols)");
        return false;
    }
    var x3 = document.forms["myForm"]["firstName"].value;
    if (x3.length>=20 || x3.length<=2) {
        alert("first name must be filled out in correct formate");
        return false;
    }
    var x4 = document.forms["myForm"]["lastName"].value;
    if (x4.length>=20 || x4.length<=2) {
        alert("last name must be filled out in correct formate");
        return false;
    }
    
    var x5 = document.forms["myForm"]["dateOfBirthday"].value;
    if ( x5.length == 10 ){} else{
        alert("date name must be filled out in correct formate");
        return false;
    }

}
///^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$/) { } else {
