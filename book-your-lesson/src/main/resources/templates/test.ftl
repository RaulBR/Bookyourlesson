
[#ftl]
[#import "/spring.ftl" as spring /]
<!DOCTYPE html>
<html lang="en">

  <head>
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
