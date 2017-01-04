
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
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script type="text/javascript">
  
  function doSearch(){
  
  $.getJSON("http://localhost:8080/teacher/search",{ CHARS:$('#searchBox').val() },
  function(data){
 	
 	$('#result').text('');
 	for(var index in data){
 	$('#result').append('<p>' +data[index].name +' '+data[index].sirName+ '</p>');
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
   $(function(){
  $("#myBtn").on('click',function(){
    var self=$(this);
    if(self.val()=="Show")     {
   	 self.val("Hide");  
    }
    else {
   	 self.val("Show");
    }
});
});
  </script>
  <link rel="icon" type="image/png" href="images/negru.png">
  </head>
  <body>
  
  
  <h3>Seacher</h3>
  <input type="text" onKeyUp="doSearch();" id="searchBox"/>
  <div id="result">
    search result
  </div>
  <p><input id="textbox" type="text" />
  <button id="submit">submit</button></p>
  <div id="display"></div>
  <input id="myBtn" type="button" value="Show" />
  
  
 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
  <!--  <script src="js/bootstrap.js"></script>  -->
  </body>
</html>
