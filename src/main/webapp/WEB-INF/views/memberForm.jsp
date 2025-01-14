<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/content.css">
<script type="text/javascript" src="../resources/js/join.js"></script>
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
					<table border=0 cellpadding=10 cellspacing=0 >
						<form action="modifyOk" method="post" name="joinForm" onSubmit="return joinCheck();">
						<tr>
							<td align=right><span class="content_text">아이디 :</span></td>
							<td><input type="text" name="mid" class="input_box_readonly" value="${mdto.mid}" readonly> </td>
						</tr>
						<tr>
							<td align=right><span class="content_text">패스워드 :</span></td>
							<td><input type="password" name="mpw" class="input_box"></td>
						</tr>
						<tr>
							<td align=right><span class="content_text">패스워드 확인 :</span></td>
							<td><input type="password" name="mpw2" class="input_box"></td>
						</tr>
						<tr>
							<td align=right><span class="content_text">이름 :</span></td>
							<td><input type="text" name="mname" class="input_box" value="${mdto.mname}"></td>
						</tr>																	
						<tr>
							<td align=right><span class="content_text">이메일 :</span></td>
							<td><input type="text" name="memail" class="input_box" value="${mdto.memail}"></td>
						</tr>
						<tr>
							<td align=right><span class="content_text">가입일 :</span></td>
							<td><input type="text" name="mdate" class="input_box_readonly" value="${mdto.mdate}" readonly></td>
						</tr>						
						<tr>
							<td colspan=2 align=center>
								<br><br>
								<input type="submit" value="정보수정" class="content_btn" >
								<input type="button" value="취소" class="content_btn" onclick="javascript:history.go(-1);">
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