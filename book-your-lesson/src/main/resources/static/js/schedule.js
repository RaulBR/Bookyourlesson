jQuery(document).ready(function(){
    	//var test = "{$hourList}";
    	// console.log(test);
    		var date = new Date();
    		var day = date.getDate(),
    			month = date.getMonth(),
    			year = date.getFullYear();
    			
    		var currDate = (day < 10 ? '0' : '') + day + '.' + (month < 10 ? '0' : '') + month + '.' + year;
    		//console.log(currDate);
    	});
    	
    	
    	 function submitButton(objInput){
    	 $(function(){
  
 var currentButton = $(objInput).parents('div')[0];
 var currentForm = $(objInput).parents('form')[0];


if($(currentForm).find('input[name="btn"]').val()=="Book Lesson"){
$.getJSON("/schedule/saveDated", $(currentForm).serialize() ,
  function(data){
  if(data>0){
  $(currentButton).html("");
  
 	 $(currentForm).find('input[name="id"]').val(data);
  			$(currentButton).html('<p><input id="setButton" class="btn btn-info" role="button"  name="btn" value="Pending"  class="btns" onClick="submitButton(this)" readonly/></p>');
 
 	}else if(data<0){
 	$('#myModal').modal('show');   
 	}
 	else {
 	$(currentButton).html("");
  			$(currentButton).html('<p><input id="setButton" class="btn btn-info" role="button"  name="btn" value="Pending" class="btns"  onClick="submitButton(this)" readonly/></p>');
 		
 	}
 	
  });
}
	

		else if($(currentForm).find('input[name="btn"]').val()=="Pending"){
		
		$.getJSON("/schedule/remove", $(currentForm).serialize() ,
  function(data){
  if(data==1){
  	$(currentButton).html("");
  			$(currentButton).html('<p><input  "id="setButton" class="btn btn-default" role="button" name="btn" value="Book Lesson" class="btns" onClick="submitButton(this)" readonly/></p>');
 		
 
 	}else {
  $(currentButton).html("");
  			$(currentButton).html('<p><input id="setButton" class="btn btn-info" role="button"  name="btn" value="Pending" class="btns"  onClick="submitButton(this)" readonly/></p>');
 
 	}
 	 });
}
 		 


});
  
	 
    
};
    	 
    