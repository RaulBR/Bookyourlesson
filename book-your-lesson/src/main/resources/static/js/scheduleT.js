

var obj = "";
var state="";
var fullName="";


function submitButton(Input){
		var currentForm=$(Input).parents('form')[0];
		console.log("status????? "+$(currentForm).find('input[name="status"]').val());
	    	 $(function(){
	    		if($(currentForm).find('input[name="status"]').val()=="free"){
	    			
	    				$('#myModalStudents').modal('show'); 
		    			state="student";
			}
	    		else{
		$('#myModalStatus').modal('show');
		state="satus";
	    		}
	
	    	 });
	    obj=currentForm;
	};	

	function statusSave(objInput){
		var id="";
	 $(function(){
		 
		 var currentForm= obj;
		
		 var stuId = $(objInput).parents('div')[0];
		
		 var dayName = $(currentForm).find('input[name="dayName"]').val();
		 var hour    = $(currentForm).find('input[name="startHour"]').val();
		 var currentButton='#button'+dayName+hour;
		 if(state=="student"){
			 var formData=$(obj).serialize();
			 var studId=$(stuId).find('select[name="studentId"]').val();
			 
			
			 
			
		 $(currentForm).find('input[name="status"]').val("booked");
		 
		 $(currentForm).find('input[name="studentId"]').val(studId);
		console.log(formData);

	 	
	 	
		 
		 		 $.getJSON("/schedule/saveDated",formData.replace("free","booked"),
				 function(data){
		 			 	if(data>0){
				  				  
				$(currentButton).html("");
				$(currentButton).html('<p><input class="btn btn-primary" name="status" role="button" value="booked" title="Show appointment actions" onclick="submitButton(this)" readonly></p>');
			 	$(currentForm).find('input[name="id"]').val(data);
			 	id=JSON.stringify(data);
			 	
			 	$(currentButton).append('<input type="hidden" name="id" value="'+id+'">');
			 	
			 	
			 	getName(studId,dayName,hour);
			 
			 	
			 	}
			 	
			 	
			  });
		 $('#myModalStudents').modal('hide');
		
		
		 }
		 else if (state="status"){
			 $(obj).find('input[name="status"]').val($(stuId).find('select[name="addStatus"]').val());
			 // aici am modificat
			var studId=$(stuId).find('select[name="studentId"]').val(); 
			$(currentForm).find('input[name="studentId"]').val(studId);	 
			// aci am terminat modificarea
			 
			 var formData=$(obj).serialize();
			
			 
			 console.log("data: "+formData);
			 
			 var currentButton='#button'+dayName+hour;
			
			 console.log("currentButton: "+currentButton);
			 
				
				 
				 
				 
			 if($(stuId).find('select[name="addStatus"]').val()=="free"){
				
				$.getJSON("/schedule/remove", formData ,
				  function(data){
					
				  if(data==1){
					  
					 
					  
				  	$(currentButton).html("");
				  	$(currentButton).html('<p><input  align="center" "id="setButton" name="status" class="btn btn-default" role="button" calss="btn" value="free" class="btns" onClick="submitButton(this)" readonly/></p>');
//				  	var buttonId='#buttonPlaceHolder'+dayName+hour;
				  var name='#namePlaceHolder'+dayName+hour;
				  console.log("name "+name);
				  		$(name).html("");
				  			 }
								});
			 }
			 else{
				$.getJSON("/schedule/edit-schedule", formData ,
				  function(data){
					
					
					if(data.status=="notFree"){
						$(currentButton).html("");
						$(currentButton).html('<p><input class="btn btn-default" name="status" role="button" value="notFree" title="Show appointment actions" onclick="submitButton(this)" readonly></p>');
	  				}
					else if(data.status=="booked"){
						$(currentButton).html("");
						$(currentButton).html('<p><input class="btn btn-primary" name="status" role="button" value="booked" title="Show appointment actions" onclick="submitButton(this)" readonly></p>');
		 			}
		 			else if(data.status=="absent"){
						$(currentButton).html("");
						$(currentButton).html('<p><input class="btn btn-danger" name="status" role="button" value="absent" title="Show appointment actions" onclick="submitButton(this)" readonly></p>');
					}
					else if(data.status=="pending"){
						$(currentButton).html("");
						$(currentButton).html('<p><input class="btn btn-info" name="status" role="button" value="pending" title="Show appointment actions" onclick="submitButton(this)" readonly></p>');
					}
					else if(data.status=="done"){
						$(currentButton).html("");
						$(currentButton).html('<p><input class="btn btn-success "name="status"  role="button" value="done" title="Show appointment actions" onclick="submitButton(this)" readonly></p>');
					}
	 				

						
				 	
					
				
				});
				
				
				
			 };


			
			 
			 
		
	 $('#myModalStatus').modal('hide');
		 };
	 });
	 
	 
	
	 };	
	


    
function getName(id,dayName,hour){

	
	var defaultReturnValue = "No Name";
    var returnValue = defaultReturnValue;
	$.getJSON("/student/searchByID", { id:id },
			function(data){
		
		
	
		var name= '#namePlaceHolder'+dayName+hour;
	   console.log(name);
		$(name).html('');
		$(name).append('<p>'+data.name+" "+data.sirName+'</p>');
	});
	

};

function statusCancel(obj){
	$('#myModalStatus').modal('hide');
	 $('#myModalStudents').modal('hide');
};


