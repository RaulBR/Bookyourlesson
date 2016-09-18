window.addEventListener("load",function(event){
	var myForm=document.getElementById("form1");
	myForm.addEventListener("submit",onFormSumitted);
	
	function onFormSumitted(ev){
		var emailInput=document.getElementsByClassName("email")[0];
		var userEmail=emailInput.value;
		var valid=true;
		ev.preventDefault();
		if(userEmail===""){
			alert("Invalid data! you bastard! add your email and SSN");
			valid=false;
		}
		
		if(userEmail.indexOf("@")===-1){
			
			alert("You bastard! invald email");
				valid=false;
		}
		if(!valid){
			emailInput.classList.add("error");
			
		}	
		//alert("you submited the form");
		return false;
		
		
	}
	var date = new Date();
var n = date.toDateString();


document.getElementById('time').innerHTML = n 
});