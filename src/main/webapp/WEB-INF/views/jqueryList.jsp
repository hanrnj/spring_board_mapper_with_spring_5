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
			function makeList() {
				
				var htmls="";
				
				var html = "<tr><td>번호</td><td>이름</td><td>제목</td><td>날짜</td><td>히트</td></tr>";
				$("#table_List").append(html); //자식 태그 가져오는거
				
			<c:forEach var="boardVO" items="${jqueryList}">
				htmls += '<tr>';
				htmls += '<td>' + '${boardVO.bId}' + '</td>';
				htmls += '<td>' + '${boardVO.bName}' + '</td>';
				htmls += '<td>';
				<c:forEach begin="1" end="${boardVO.bIndent}">
					htmls += '-';
				</c:forEach>
				htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + '${boardVO.bId}' + '">' + '${boardVO.bTitle}' + '</a></td>';
				htmls += '<td>${boardVO.bDate}</td>';
				htmls += '<td>${boardVO.bHit}</td></tr>';
				
			</c:forEach>
				
				$("#table_List").append(htmls);
			}

		</script>
		
		<script>
			$(function(){
				makeList();
			});
		</script>

	</head>
	<body>
	
		<table id="table_List" width="500" cellpadding="0" cellspacing="0" border="1">

		</table>
		
	</body>
</html>