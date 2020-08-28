<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			function getAjaxList() {
				
				var url = "restful/after.json";
				
				$.ajax({
					url: url,
					type: 'GET',
					cache: false,
					dataType:"json",				
					success:function(result){
						console.log(result);
						
						var htmls="";
						$("#table_List").html("");
						
						var html = "<tr><td>번호</td><td>이름</td><td>제목</td><td>날짜</td><td>히트</td></tr>";
						$("#table_List").append(html);
							
						$(result).each(function(){
							
							htmls += '<tr>';
							htmls += '<td>' + this.bId + '</td>';
							htmls += '<td>' + this.bName + '</td>';
							htmls += '<td>';
							for(var i=0; i < this.bIndent; i++){
								htmls += '-';
							}
								
							htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + this.bId + '">' + this.bTitle + '</a></td>';
							htmls += '<td>' + this.bDate + '</td>';
							htmls += '<td>' + this.bHit + '</td>';
							htmls += '</tr>'
						});
							htmls += '<tr>'
							htmls += '<td colspan="5"> <a href="write_view">글작성</a> </td>'
							htmls += '</tr>'
							
						$("#table_List").append(htmls);
					},
					error: function (request, status, error){
						alter("실패");
						console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				});
			}

		</script>
	<script type="text/javascript">
		$(document).ready(function(){
			getAjaxList();
		});
			
		
	</script>


	</head>
	<body>
	
		<table id="table_List" width="500" cellpadding="0" cellspacing="0" border="1">

		</table>
		
	</body>
</html>