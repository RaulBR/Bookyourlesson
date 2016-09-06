window.addEventListener("load", function(event) {
	var week = document.getElementById("2");
	myForm.addEventListener("submit",onFormSubmitted);

	function onFormSubmitted(ev){
		var emailInput = document.getElementsByClassName("email-input")[0];
		var userEmail = emailInput.value;
		var valid = true;

		ev.preventDefault();