/**
 * 
 */

function joinCheck() {

	if (document.joinForm.mid.value.length==0) {
		alert("아이디는 필수 입력사항입니다.	");
		document.joinForm.mid.focus();
		return false;
	}
	if (document.joinForm.mid.value.length<=3) {
		alert("아이디는 최소 4자 이상입니다.");
		document.joinForm.mid.focus();
		return false;
	}
	if (document.joinForm.mpw.value.length==0) {
		alert("비밀번호는 필수 입력사항입니다.	");
		document.joinForm.mpw.focus();
		return false;
	}
	if (document.joinForm.mpw.value.length<=4) {
		alert("비밀번호는 최소 5자 이상입니다.");
		document.joinForm.mpw.focus();
		return false;
	}
	if (document.joinForm.mpw.value!=document.joinForm.mpw2.value) {
		alert("입력하신 비빌번호가 일치하지 않습니다.");
		document.joinForm.mpw2.focus();
		return false;
	}
	if (document.joinForm.mname.value.length==0) {
		alert("회원이름은 필수 입력사항입니다.	");
		document.joinForm.mname.focus();
		return false;
	}		
	if (document.joinForm.memail.value.length==0) {
		alert("이메일은 필수 입력사항입니다2.	");
		document.joinForm.memail.focus();
		return false;
	}	
	
	return true;
	
}

function idcheck() {
		if(document.joinForm.mid.value.length == 0) {
				alert("아이디는 필수 입력사항입니다.");
				document.joinForm.mid.focus();
				return false;				
		}
		var url = "idcheck";
		var idvalue = document.getElementById("mid").value;
		
	    window.location.href = "idcheck?idcheck="+idvalue;
		
		
}