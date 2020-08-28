<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>성적입력</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		
	$('#grade').submit(function(event){
		event.preventDefault();
		console.log("ajax 호출전");
		
		  var queryString = $("form[name=inputGrade]").serialize();
		
		$.ajax({
		    url: '${pageContext.request.contextPath}/restful/inputGrade.json',
		    type: 'post',
		    dataType:"json",
		    data: queryString,
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
<%
	String path = request.getContextPath();
%>
<p>ajax 성적 입력</p>

	<form name="inputGrade" id="grade" action="<%=path%>/outputGrade">
		국어:<input type="text" name="kor"><br>
		수학:<input type="text" name="math"><br>
		영어:<input type="text" name="eng"><br>
		<input type="submit" name="입력">
	
	</form>

</body>
</html>