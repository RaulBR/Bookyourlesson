
[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">
  <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
   
  	
    <title>bydl</title>
	<link rel="icon" type="image/png" href="/images/negru.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
	<link href="/js/sch.js" rel="sch">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <base href="" />
      <script type="text/javascript">
  
  function doSearch(){
  
  $.getJSON("/teacher/search",{ CHARS:$('#searchBox').val() },
  function(data){
 	
 	$('#dddd').html('');
 	var a=1;
 		$('#dddd').append(
   '<thead>'+
 	'<tr >'+
 	'<th>Number</th>'+
    '<th>Name</th>'+
  	'<th>Sir Name</th>'+
    '<th>Car</th>'+
   	'<th>Category</th>'+
   	'<th>Email</th>'+
   	[#if permision??]
   	'<th>Hire date</th>'+
   	'<th>CNP</th>'+
   	'<th>Schedule status</th>'+
   	'<th></th>'+
   	'<th></th>'+
   	[/#if]
   	'</thead>');
   	
 	for(var index in data){
 	$('#dddd').append('<tr>' +
 	
 	'<td>'+        a++                +'</td>'+
 	'<td>'+   data[index].name        +'</td>'+
 	'<td>'+   data[index].sirName     +'</td>'+
 	'<td>'+   data[index].category    +'</td>'+
 	'<td>'+   '<a class="btn btn-primary" href="/vehicle/list?teacherId='+   data[index].id      +'" role="button">Cars</a>'        +'</td>'+
 	'<td>'+   data[index].email       +'</td>'+
 				[#if permision??]
 	'<td>'+   data[index].hireDate    +'</td>'+
 	'<td>'+   data[index].cnp         +'</td>'+
 	
 	'<td > <form name="form1" action="/statistics/teacher" method="POST">'+
	  	   '<input type="hidden" name="teacherId" value="'+data[index].id+'">'+
	  		'<button  type="submit" class="btn btn-info" value="'+data[index].id+'"> :)</button>'+
	  		'</form></td>'+
	  		
	'<td ><form name="form1" action="/teacher/edit" method="POST">'+
	
	  		'<input type="hidden" name="id" value="'+data[index].id+'">'+
	  		'<button  type="submit" class="btn btn-info" value="'+data[index].id+'">EDIT</button>'+
	  		'</form></td>'+
	  		
	'<td ><form name="form1" action="/teacher/delete" method="POST">'+
	  		'<input type="hidden" name="id" value="'+data[index].id+'">'+
	  		'<button  type="submit" class="btn btn-info" value="'+data[index].id+'">DEL</button>'+
	  		'</form></td>'+
	  		[/#if]
 	 '</tr>');
 	 
 	}
 	
  });
  }
  $(function(){
  $("#submit").click(function(){
  var txt =$("#textbox").val();
  
  $("#display").html(txt);
  $("#textbox").val("");
  
  
  });
  
  
  });
  
  </script>
  </head>
  [#escape x as x?html]
  <body>
  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/schedule"> <font color="white">Home</font></a>
 		  <a class="navbar-brand" class="logout" color="white" href="/student/list?teacherId"> <font color="white"> Students</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/teacher/list"> <font color="white"> Instructors</font></a>
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white"> LogOut</font></a>
 		 
  		</div>
  	</div>
	</nav>
  <h1> Instructors</h1>
   [#if permision??]
 	<p><a href="/teacher"><input class="btn btn-info" role="button" value="ADD INSTRUCTOR" type="submit"  readonly></a>
 	<a href="/teacher/list"><input class="btn btn-info" role="button" value="LIST ALL INSTRUCTOR" type="submit"  readonly></a></p>
    
    	
    	
 
   
  
    
 	[/#if]
 	<p>Search:<input type="text" onKeyUp="doSearch();" id="searchBox"/>
 <table class="table" id="dddd">
  <thead>
     <tr >
  
  
    <th>Number</th>
    <th>Name</th>
    <th>Sir Name</th>
    <th>Car</th>
    <th>Category</th>
    <th>Email</th>
   	[#if permision??]
   	<th>Hire date</th>
   	<th>CNP</th>
   	<th>Schedule status</th>
   	<th></th>
   	<th></th>
   	</thead>
   	[/#if]
	 	  	 [#assign nr = 0]
	  		[#if teachers??]
	  		[#list teachers as teacher]
	  			 [#assign nr = nr +1 ]	
	  		  <tr>		
	  				<td > ${nr}  </td>		
	  		<td > 		${teacher.name}   </td>
	  		<td >	 ${teacher.sirName} </td>
	  		<td >	<a class="btn btn-primary" href="/vehicle/list?teacherId=${teacher.id}" role="button">Cars</a>
	  		<td >	 ${teacher.category} </td>
	  		<td >	 ${teacher.email} </td>
	  				[#if permision??]
	  		<td >	 ${teacher.hireDate} </td>
	  		<td >	 ${teacher.cnp} </td>
	  			<td >
	  			 <form name="form1" action="/statistics/teacher" method="POST">
	  				 <input type="hidden" name="teacherId" value="${teacher.id}">
	  			<button  type="submit" class="btn btn-info" value="${teacher.id}"> :)</button>
	  		</form>
	  		</td>
	  		<td >
	  			 <form name="form1" action="/teacher/edit" method="POST">
	  				 <input type="hidden" name="id" value="${teacher.id}">
	  			<button  type="submit" class="btn btn-info" value="${teacher.id}">EDIT</button>
	  		</form>
	  		</td>
	  		<td >
	  		 <form name="form1" action="/teacher/delete" method="POST">
	  				 <input type="hidden" name="id" value="${teacher.id}">
	  				 	<button  type="submit" class="btn btn-info" value="${teacher.id}">DEL</button>
	  		</form>
	  			</td>
	  			[/#if]
	  	
	  		
	  		
	  			[/#list]
	  			[/#if]
	  			 </tr>
	 
 
  
  </tbody>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.js"></script>
    
    
    
    
  </body>
</html>
[/#escape]
