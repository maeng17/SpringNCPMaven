<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		border-collapse: collapse;
	}
	th,td {
		padding: 5px;
		width: 200px;
	}
	#currentPaging {
		border: 1px solid #ccc;
		margin: 5px;
		padding: 5px 8px;
		color: red;
		cursor: pointer;
	}
	#Paging {
		color: black;
		margin: 5px;
		padding: 5px;
		cursor: pointer;	
	}
</style>
</head>
<body>
	<input type="hidden" id="pg" value="${pg }" ><br><br>
	
	<a href=""><img src="../image/cat.jpg" width="30" height="30"></a>
	<table border="1" frame="hsides" role="rows" id="userListTable">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		
		<!-- 동적처리 -->
	</table>
	
	<!-- 페이징처리 -->
	<div id="userPagingDiv" style="width: 630px; text-align: center; margin-top: 10px;">
	<!-- 동적처리 -->
	</div>
	
	<script type="text/javascript" src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/list.js"></script>
	<script type="text/javascript">
		function userPaging(pg){
			location.href="/mini/user/list?pg=" + pg;
		}
	</script>
</body>
</html>