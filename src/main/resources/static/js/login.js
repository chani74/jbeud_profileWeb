/**
 * 
 */

function loginCheck() {

	if (document.loginForm.mid.value.length==0) {
		alert("아이디는 필수 입력사항입니다.	");
		document.loginForm.mid.focus();
		return false;
	}
	if (document.loginForm.mid.value.length<=3) {
		alert("아이디는 최소 4자 이상입니다.");
		document.loginForm.mid.focus();
		return false;
	}
	if (document.loginForm.mpw.value.length==0) {
		alert("비밀번호는 필수 입력사항입니다.	");
		document.loginForm.mpw.focus();
		return false;
	}
	if (document.loginForm.mpw.value.length<=4) {
		alert("비밀번호는 최소 5자 이상입니다.");
		document.loginForm.mpw.focus();
		return false;
	}
	
	
	return true;
	
}