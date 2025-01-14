<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/content.css">
<script type="text/javascript" src="../resources/js/join.js"></script>
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
					<table border=0 cellpadding=10 cellspacing=0 >
						<form action="writeOk" method="post" name="writeForm" onSubmit="return writeCheck();">
						<tr>
							<td align=right><span class="content_text">아이디 :</span></td>
							<td><input type="text" name="bid" class="input_box_readonly" value="${mdto.mid}" readonly> </td>
						</tr>
						<tr>
							<td align=right><span class="content_text">작성자 :</span></td>
							<td><input type="text" name="bname" class="input_box_readonly" value="${mdto.mname}" readonly> </td>
						</tr>
						<tr>
							<td align=right><span class="content_text">제목 :</span></td>
							<td><input type="text" name="btitle" class="input_box" style="width:500px;"> </td>
						</tr>
						<tr>
							<td align=right><span class="content_text">내용 :</span></td>
							<td><textarea rows="10" cols="70" name="bcontent" class="input_box"></textarea>
							
						</tr>																	
					
						<tr>
							<td colspan=2 align=center>
								<br><br>
								<input type="submit" value="작성완료" class="content_btn" >
								<input type="button" value="작성취소" class="content_btn" onclick="javascript:location.href='list';">
							</td>
							
						</tr>
						</form>
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