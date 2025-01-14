/**
 * 
 */

function writeCheck() {
	if ( document.writeForm.btitle.value.length == 0 ) {
		alert("제목은 반드시 입력해 주세요.");
		document.writeForm.btitle.focus();
		return false;	
	}

	if ( document.writeForm.bcontent.value.length <= 10 ) {
		alert("내용은 10글자 이상 입력해 주세요.");
		document.writeForm.bcontent.focus();
		return false;	
	}

	
	
}