<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="../resources/css/header.css">
</head>
<body>
	<table width="100%" border=0 cellpadding=0 cellspacing="0">
	<tr class="header_line" height=50px align="center">
		<td width=55%>&nbsp;
			<c:choose>
				<c:when test="${sessionId != null }">
					LOGIN ID : <b> ${sessionId}</b>
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
			</c:choose>
		
		</td>
		<td width=5% ><a href="index" class="header_link"><span class="header_menu">HOME</span></a></td>
		<td width=2%>&nbsp;</td>
		<td width=5% >
		<c:choose>
			<c:when test="${sessionId != null }">
				<a href="logout" class="header_link"><span class="header_menu">LOGOUT</span></a>
			</c:when>	
			<c:otherwise>
				<a href="login" class="header_link"><span class="header_menu">LOGIN</span></a>
			</c:otherwise>
		</c:choose>
		</td>
		<td width=2%>&nbsp;</td>
		<td width=5% >
		<c:choose>
			<c:when test="${sessionId != null }">
				<a href="member" class="header_link"><span class="header_menu">MEMBER</span></a>
			</c:when>	
			<c:otherwise>
				<a href="join" class="header_link"><span class="header_menu">JOIN</span></a>
			</c:otherwise>
		</c:choose>
		</td>

		<td width=2%>&nbsp;</td>
		<td width=5% ><a href="profile" class="header_link"><span class="header_menu">PROFILE</span></a></td>
		<td width=2%>&nbsp;</td>
		<td width=5% ><a href="list" class="header_link"><span class="header_menu">BOARD</span></a></td>
		<td width=2%>&nbsp;</td>
		<td width=5% ><a href="contact" class="header_link"><span class="header_menu">CONTACT</span></a></td>
		<td width=4%>&nbsp;</td>
		
	</tr>
	<tr height="50px">
		<td colsapn=13>&nbsp;</td>
	</tr>	
	
	</table>
</body>
</html>