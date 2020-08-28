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
			console.log("ajax 호출전");
			
			  var formData = $("form[name=recArea]").serialize();
			
			$.ajax({
			    url: '${pageContext.request.contextPath}/restful/area.json',
			    type: 'post',
			    dataType:"json",
			    data: formData,
			    success: function (data) {	    	
			    		console.log(data);
			            alert("데이터 전송이 성공적으로 끝났을 때 실행");
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
			가로:<input type="text" name="width"/><br/>
			세로:<input type="text" name="height"/><br/>
			<input type="submit" value="입력"/>
		</form>
		
	</body>
</html>