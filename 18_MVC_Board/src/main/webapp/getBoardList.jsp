<%@page import="java.util.List"%>
<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- DB데이타 조회하고 조회된 데이타를 화면 출력 --%>
<%
	//세션에 저장된 목록 가져와서 사용
	List<BoardVO> boardList 
		= (List<BoardVO>) session.getAttribute("boardList");
	
	//2. 화면에 표시(HTML 태그작성)
%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	h1, h3 { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>

<div id="container">
	<h1>글목록</h1>
	<h3>테스트님 환영합니다... <a href="logout.do">Log-out</a></h3>
	
	<!-- 검색을 위한 폼 -->
	<form action="getBoardList.do" method="post">
	<table class="border-none">
		<tr>
			<td>
				<select name="searchCondition">
					<option value="TITLE">제목
					<option value="CONTENT">내용
				</select>
				<input type="text" name="searchKeyword">
				<input type="submit" value="검색">
			</td>
			
		</tr>
	</table>
	</form>
	
	<!-- 데이타 표시 -->
	<form>
	<table>
		<tr>
			<th width="100">번호</th>
			<th width="200">제목</th>
			<th width="150">작성자</th>
			<th width="150">등록일</th>
			<th width="100">조회수</th>
		</tr>
		
		<% for (BoardVO board : boardList) { %>
		<tr>
			<td class="center"><%=board.getSeq() %></td>
			<td>
				<a href="getBoard.do?seq=<%=board.getSeq() %>">
					<%=board.getTitle() %>
				</a>
			</td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate() %></td>
			<td class="center"><%=board.getCnt() %></td>
		</tr>
		<% } %>
	</table>
	</form>
	<p class="center"><a href="insertBoard.jsp">새글등록</a></p>
	
</div>

</body>
</html>






