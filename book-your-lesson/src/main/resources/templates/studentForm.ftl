
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
  </head>
  [#escape x as x?html]
  <body>
  <nav class="navbar navbar-dark bg-primary">
	 <div class="nav navbar-nav">
   		 <div class="container" lass="logout">
 		 <a class="navbar-brand" class="logout" color="white" href="/logout"> <font color="white">Home</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/vehicle/list"> <font color="white"> Vehicles</font></a>
  		 <a class="navbar-brand" class="logout" color="white" href="/teacherList"> <font color="white"> Instructors</font></a>
 		 
  		</div>
  	</div>
	</nav>
  <h1> Register Student </h1>
 [#if errors??]
    <div>
        <ul>
            [#list errors as error]
            <br>
                <b style="color:red">
                [#if error.field??]${error.field}: [/#if]${error.defaultMessage}
                </b>
            [/#list]
        </ul>
    </div>
[/#if]
  <form action="/student/userSave" class="sexy-form"  method="POST" >
  
		[#if student??]
  			<input type="hidden" name="id" value="${student.id}" />
  		[/#if]
  


  </div>
    <div class="form-group">
    	<label for="text">Name:</label>
    		<input type="text" class="form-control" name="name" [#if student??]value="${student.name}"[/#if]>
 	 </div>
   <div class="form-group">
    <label for="text">Sir Name</label>
    <input type="text" class="form-control" name="sirName" [#if student??]value="${student.sirName}"[/#if]>
  </div>
  </div>
   <div class="form-group">
    <label for="text">Email</label>
    <input type="email" class="form-control" name="email" [#if student??]value="${student.email}"[/#if]>
  </div>
    <div class="form-group">
    <label for="text">CNP</label>
    <input type="text" class="form-control" name="cnp"  [#if student??]value="${student.cnp}"[/#if]>
  </div>
   <div class="form-group">
    <label for="text">Phone Number</label>
    <input type="text" class="form-control" name="phoneNumber"  [#if student??]value="${student.phoneNumber}"[/#if]>
  </div>
     [#if teachers??]
        <div class="form-group">
    <label for="text">Teacher</label> 
    <select name="teacherId"  class="form-control">
  [#list teachers as teacher]
    <option value="${teacher.id!''}">${teacher.sirName!''} ${teacher.name!''}</option>
  
      [/#list]
  </select>
     </div>
        [/#if]
  
   <div class="form-group">
    <label for="text">category</label>
  
   
    <select name="Category"  class="form-control">
    <option value="B">Category <b>B</b></option>
    <option value="A">Category <b>A</b></option>
    <option value="C">Category <b>C</b></option>
  </select>
  </div>
  
   <div class="form-group">
    <label for="text">Medical Papers</label>  
    <select name="medPaper"  class="form-control" [#if student??]value="${student.medPaper?c}"[/#if]>
    <option value="true"> <b>Yes</b></option>
    <option value="false"> <b>No</b></option>
   
  </select>
  </div>
 [#if edit??][#else]
  
 	<div class="form-group" >
    <label for="text">User</label>
    <input type="text" class="form-control" name="user" >
  </div>
  <div class="form-group">
    <label for="text">Pasword</label>
    <input type="password" class="form-control" name="pass">
  </div>

  <div class="form-group">
    <label for="text">Repede Password</label>
    <input type="password" class="form-control" name="pass2">
  </div>
[/#if]
 
  <input class="btn btn-success" role="button" type="submit" value="Submit" >
</form>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    
    
  </body>
</html>
[/#escape]


