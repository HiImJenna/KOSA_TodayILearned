<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript">
		
		$(document).ready(function(){
			
			$('#empListBtn').click(function(){
				test();
			});
			
			
			//삭제
			$(document).on("click",".delete",function(){
				
	            let empno = $(this).attr("value2");

				$.ajax({
					type : "delete",
					contentType : 'application/json',
					url  : "emp/"+empno,
					success : function(data){ 
						test();
					} 
				})
			});			
		});
				
		
		function empupdateconfirm(me){			
			empupdateok(me);
		}

		//수정 처리
		function empupdateok(me){
			var tr = $(me).closest('tr');
			var data = JSON.stringify({
						"empno":tr.find("td:eq(0)").children().val(),
						"ename":tr.find("td:eq(1)").children().val(),
						"sal":tr.find("td:eq(2)").children().val(),
					   });
			$.ajax({
				type: "put",
				url:  "emp",
				data:  data,
				dataType: 'text',
				contentType: 'application/json;charset=utf-8',
				success : function(data){  
							 test();
				} 
			})
		}


		
	
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		function createTable(data, way){
			$('#menuView').empty();
			var opr="<table id='fresh-table' class='table'><tr>"+way+"</tr><thead><tr>"+
			    "<th>EMPNO</th>"+
            	"<th>ENAME</th>"+
            	"<th>SAL</th>"+
            	"<th>EDIT</th><th>DELETE</th></tr></thead><tbody>";
			$.each(data,function(index,emp){
				opr += "<tr><td>"+emp.empno+
				"</td><td>"+emp.ename+
				"</td><td>"+emp.sal+
				"</td><td><input type='button' onclick='empupdate(this)' value='수정' class ='update'  value2="+emp.empno+
				"></td><td><input type='button' value='삭제' class ='delete' value2="+emp.empno+"></td></tr>";
			});
			opr+="<tr><td colspan='10'><button class='btn btn-primary float-end'onclick='createinput(this)' type='button'>사원 등록</button></td></tr></tbody></table>";
			$('#menuView').append(opr);
		}	
		
		
		//수정폼 양식
		function empupdate(me){
			var tr = $(me).closest('tr')
			var empno = Number(tr.children().html());
			tr.empty();
			
			$.ajax({
				type : "get",
				url:"emp/"+empno,
			
				data: {},
				 success : function(data) {
					
		               var td = "<td><input type='text' value='"+data.empno +"' readonly></td>";
		                 td +="<td><input type='text' value='"+data.ename +"'></td>";
		                 td +="<td><input type='text' value='"+data.sal +"'></td>";
		                 td +="<td colspan='2'><input type='button'onclick='empupdateconfirm(this)' value='완료' value2="+data.empno+" /></td>";
		                 $(tr).append(td); 
		           }

			})
		}
		
/* 		//수정 폼
	      function empupdate(me){
	            var tr = $(me).closest('tr')
	            const empno = Number(tr.children().html());
	            tr.empty();
	            
	            $.ajax({
	               type : "get",
	               url:"emp/"+empno,
	               success : function(data) {
	                   var td = "<td><input type='text' value='"+data.empno +"' readonly></td>";
	                     td +="<td><input type='text' value='"+data.ename +"'></td>";
	                     td +="<td><input type='text' value='"+data.sal +"'></td>";
	                     td +="<td colspan='2'><input type='button'onclick='empupdateconfirm(this)' value='완료' value2="+data.empno+" /></td>";
	                     $(tr).append(td); 
	               }
	            });
	         } */
	      
	      
		//등록 폼
		function createinput(me){
			var tr = $(me).closest('tr');
			tr.empty();
			var td = "<td><input type='text'></td>";
			td +="<td><input type='text'></td>";
			td +="<td><input type='text'></td>";
			td +="<td><input type='button'onclick='empinsert(this)' value='완료'/></td>";
			td +="<td><input type='button'onclick='cancel(this)' value='취소'/></td>";
			$(tr).append(td); 
		}
		
		
		//취소버튼
		function cancel(me){
			var tr = $(me).closest('tr');
			tr.empty();
			tr.append("<td colspan='10'><button class='btn btn-primary float-end'onclick='createinput(this)' type='button'>사원 등록</button></td>");
		}
		
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		

		
		
		//등록 처리
		function empinsert(me){
			var tr = $(me).closest('tr');
			var data = JSON.stringify({
						"empno":tr.find("td:eq(0)").children().val(),
						"ename":tr.find("td:eq(1)").children().val(),
						"sal":tr.find("td:eq(2)").children().val(),
					   });
			
			$.ajax({
				type : "POST",
				url:   "emp",
				data:   data,
				dataType: 'text',
				contentType : 'application/json',
				success : function(data){  
					test();
				} 
			})
		}	
		
		//조건검색
       // 검색
       $('#keyword').keyup(function(){
          console.log($('#keyword').val());
          const number = $('#keyword').val();
              $.ajax(
                    {  
                      type : "get",
                      url  : "emp/" + number,
                      success : function(data){ 
                         console.log(data);
                         $('#exp').empty();
                         createTable(data, "");
                      } 
                    })    
          });       
		
		
		
		function test() {
				  $.ajax({  
	                     type : "get",
	                     url  : "emp",
	                     success : function(data){ 
	                    	 $('#exp').empty();
	           
	                        console.log(data);
	                        createTable(data, "Emp 전체 리스트");
	                     }
	                   });
		}

		
	
	</script>


</head>
<body>


	<hr>
	<div class="wrapper">
		<div class="fresh-table toolbar-color-azure full-screen-table"
			style="align-content: center;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-6">
						<fieldset>
							<legend>JSON</legend>
							<input type="button" value="empList" id="empListBtn">
						</fieldset>
					</div>
					<div class="col-sm-6"></div>
				</div>

				<hr>
				<div id="exp"></div>
				<span id="menuView"></span>
			</div>
		</div>
	</div>


	<div class="col"></div>
</body>
</html>