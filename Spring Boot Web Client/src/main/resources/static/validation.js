function validateBooking() {
	var bId = document.getElementById("bookingId").value;
	var cId = document.getElementById("customerId").value;
	var regNo = document.getElementById("regNo").value;
	var date = document.getElementById("date").value;
	if (bId == '') {
		alert('Please enter a valid booking ID.');
		return false;
	} 
	else if (cId = '') {
		alert('Please enter a valid customer ID.');
		return false;
	}
	else if (regNo = '') {
		alert('Please enter a valid registration number.');
		return false;
	}
	else if (date = '') {
		alert('Please enter a valid date.');
		return false;
	}
	else {
		return true;
	}
}