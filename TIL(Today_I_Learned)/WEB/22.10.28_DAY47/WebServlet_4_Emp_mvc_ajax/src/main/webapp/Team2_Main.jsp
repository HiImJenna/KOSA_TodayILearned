<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Team Enjo2!!</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/style.css" rel="stylesheet" />
        
        <script type="text/javascript">

			     		window.onload = function(){
				   			 document.getElementById("submit").addEventListener("click",function(){
				   				 let data = document.getElementById("submit").value;
				   			      sendData(data);
				   			 });
			   			}

			         	let httpReq=null;
			        	
			        	function getInstance(){
			        		  if(window.XMLHttpRequest){
			        			  httpReq = new XMLHttpRequest();
			        		  }else if(window.ActiveXObject){
			        			  httpReq = new ActiveXObject("Msxml2.XMLHTTP");
			        		  }else{
			        			 throw new Error("AJAX 지원하지 않습니다"); 
			        		  }
			        		return httpReq;  
			        	}
			        	
			        	
			        	function handlerStateChange(){
			        		 if(httpReq.readyState == 4){
			        			 if(httpReq.status >= 200 && httpReq.status < 300){
			        				 document.getElementById("EMP").innerHTML = httpReq.responseText;
			        			 }
			        		 }
			        	}
			        	
			        	
			        	function sendData(data){
			        		httpReq = getInstance();
			        		httpReq.onreadystatechange = handlerStateChange;  // x >> ()
			        		httpReq.open("POST","Servlet?EMP=" + data); //<form 태그 구성 method=  action=
			        		httpReq.send(); // form submit 버튼 클릭
			        	}
			        	
	             </script>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- ********* Sidebar *********-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">Menu</div>
                <jsp:include page="/Team2_Module/left.jsp"></jsp:include>
            </div>
            
            <!-- ****************** Page content wrapper ******************-->
            <div id="page-content-wrapper">
            
                <!-- ********* Top navigation *********-->
	             <jsp:include page="/Team2_Module/top.jsp"></jsp:include>
	             <jsp:include page="/Team2_Module/main.jsp"></jsp:include>  
	             <p id="EMP"></p>
	             
	             <!--********* EMP 전체조회하기 *********-->
	             <div style="background-color: white;">
	             <input type = "submit" id= "submit" value="Click me!">
	             
                </div>
            </div>
        </div>
        
        
        
        
        
        
        
        
        
        <!-- ****************************************************** -->
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
