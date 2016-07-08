function validateForm() {
	var x1 = document.forms["1"]["quantity"].value;
	var x2 = document.forms["1"]["count"].value;

//	if ( x1 !== /^\d+$/ || x1 <= 0 || x1>x2) {
	if ( x1 <= 0 || x1>x2) {
		alert("quantity must be only numbers: over zerro and less than count from pharmacies");
		return false;
	}

}