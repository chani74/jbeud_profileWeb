<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/content.css">
<link rel="stylesheet" href="../resources/css/board.css">
<title>Profile of Eunchan</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
<div class=body_main>
	<table border=0 cellpadding=20 cellspacing=0>
	<tr>
		<td align=center><span class="title_text01">DEVELOPER EUNCHAN's PROFILE</span></td>
	</tr>
	<tr>
		<td align=center><span class="title_text02">이은찬입니다. 개발자의 꿈을 꾸는 23년차 IT 기획자입니다.</span></td>
	</tr>
	<tr>
		<td align=center >
			<table border=0 cellpadding=8 cellspacing=0 >
				<tr>
				<td align=center class="content_box">
					<table border=0 cellpadding=5 cellspacing=0 width=100%>
					
						<tr class="board_title_tr">
							<th align=center class='board_title_td' width="8%">번호</th>
							<th align=center class='board_title_td' width="10%">아이디</th>
							<th align=center class='board_title_td' width="10%">이름</th>
							<th align=center class='board_title_td' width="50%">제목</th>
							<th align=center class='board_title_td' width="12%">등록일</th>
							<th align=center class='board_title_td' width="10%">조회수</th>
						</tr>
						<c:forEach items="${bDtos }" var="bDto">
						<tr class="board_content_tr">
							<td align=center class="board_content_td">${bDto.bnum }</td>
							<td align=center class="board_content_td">${bDto.bid }</td>
							<td align=center class="board_content_td">${bDto.bname }</td>
							<td align=center class="board_content_td">
								<a href="viewContent?bnum=${bDto.bnum }&page=${criteria.getPageNum()}" class="board_link">
								<c:choose>
									<c:when test="${fn:length(bDto.btitle)>25 }">${fn:substring(bDto.btitle,0,25) }...</c:when>
									<c:otherwise>${bDto.btitle }</c:otherwise>
								</c:choose>
								</a>
							</td>
							<td align=center class="board_content_td">${fn:substring(bDto.bdate,0,10) }</td>
							<td align=center class="board_content_td">${bDto.bhit }</td>
						</tr>
						</c:forEach>
						
						<tr class="board_title_tr">
							<th colspan=6 align=center class='board_title_td' >
								<div class="page_link_wrap">
								<ul class="page_link" >
								<c:if test="${pageDto.prev }">
									<li><a href="list?page=1" >《</a></li>
									<li><a href="list?page=${pageDto.startPage-1}"  >〈</a></li> 
								</c:if> 
								<c:forEach  var="num" begin="${pageDto.startPage }" end="${pageDto.endPage }">
									<c:choose>
										<c:when test="${ num == criteria.getPageNum() }"><li><a href="#" class="active">${num }</a></li></c:when>
										<c:otherwise><li><a href="list?page=${num }" >${num }</a></li></c:otherwise>
									</c:choose>									
								</c:forEach>
								<c:if test="${pageDto.next }">
									<li><a href="list?page=${pageDto.endPage+1}"  >〉</a></li>
									<li><a href="list?page=${pageDto.realEndPage}" >》</a></li>
								</c:if>
								</ul>
								</div>
							</th>
							
						</tr>						<tr>
							<td colspan=6 align=right>
								
								<input type=button value="글쓰기" class="content_btn" onclick="javascript:location.href='write';">
							</td>
							
						</tr>						
					</table>
				
				</td>
				</tr>
				
			</table>
						
	
		</td>
	</tr>
	</table>
	</div>
	
	<%@ include file="include/footer.jsp" %>
</body>
</html>