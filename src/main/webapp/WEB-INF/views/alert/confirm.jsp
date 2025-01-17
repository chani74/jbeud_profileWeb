<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alert</title>
</head>
<body>

	<script type="text/javascript">
		var msg="${msg}";
		var url="${url}";
		result = confirm(msg);
		if ( result ) {
			location.href=url;
		} else {
			history.go(-1);
		}
	</script>	
	
</body>
</html>