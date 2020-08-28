<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			
		$('#area').submit(function(event){
			event.preventDefault();
			console.log("ajax ȣ����");
			
			  var formData = $("form[name=recArea]").serialize();
			
			$.ajax({
			    url: '${pageContext.request.contextPath}/restful/area.json',
			    type: 'post',
			    dataType:"json",
			    data: formData,
			    success: function (data) {	    	
			    		console.log(data);
			            alert("������ ������ ���������� ������ �� ����");
			            $('body').attr("");
			            document.write(data);
			        }
				});
			})
		})
	</script>
		
	</head>
	<body>
		
		<form id="area" name="recArea" action="${pageContext.request.contextPath}/area">
			����:<input type="text" name="width"/><br/>
			����:<input type="text" name="height"/><br/>
			<input type="submit" value="�Է�"/>
		</form>
		
	</body>
</html>