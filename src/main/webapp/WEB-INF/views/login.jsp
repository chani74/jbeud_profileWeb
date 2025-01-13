<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/content.css">
<script type="text/javascript" src="../resources/js/login.js"></script>
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
						<form action="loginOk" method="post" name="loginForm" onSubmit="return loginCheck();">
						<tr>
							<td align=right><span class="content_text">아이디 :</span></td>
							<td><input type="text" name="mid" class="input_box"></td>
						</tr>
						<tr>
							<td align=right><span class="content_text">패스워드 :</span></td>
							<td><input type="password" name="mpw" class="input_box"></td>
						</tr>
						
						<tr>
							<td colspan=2 align=center>
								<br><br>
								<input type=submit value="로그인" class="content_btn">
								<input type=button value="회원가입" class="content_btn" onclick="javascript:location.href='join';">
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