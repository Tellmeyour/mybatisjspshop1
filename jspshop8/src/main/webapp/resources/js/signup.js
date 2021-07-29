let idFlag = false;
let pwFlag = false;
let submitFlag = false;

// input이 포커스됐다가 취소되면 함수실행
$(document).ready(function(){
	$("#userid").blur(function(){
		checkId("first");
	});
	
	$("#pswd1").blur(function(){
		checkPswd1();
	}).keyup(function(event) {
        checkShiftUp(event);
    }).keypress(function(event){
		checkCapslock(event);
	}).keydown(function(event) {
        checkShiftDown(event);
    });
    
    
	$("#pswd2").blur(function(){
		checkPswd2();
	}).keyup(function(event) {
        checkShiftUp(event);
    }).keypress(function(event){
		checkCapslock2(event);
	}).keydown(function(event) {
        checkShiftDown(event);
    });

	$("#btnjoin").click(function(event){
		submitClose();
		if(idFlag && pwFlag){
			mainSubmit();
		} else {
			setTimeout(function(){
				mainSubmit();	
			}, 700);
		}		
	});
	
});

function mainSubmit(){
	
	if(!checkUnrealInput()){
		submitOpen();
		return false;
	}
	
	if(idFlag && pwFlag){
		try{
			$("#join_form").submit();
		} catch (e){
			$("#join_form").submit();
		}
	} else { 
		submitOpen();
		return false;
	} 
}

function submitOpen() {
    $("#btnJoin").attr("disabled",false);
}

function submitClose(){
	submitFlag = true;
	$("#btnJoin").attr("disabled",true);
}


// 아이디 유효성검사
function checkId(event){
	
	if(idFlag) return true;
	
	let userid = $("#userid").val();
	let oMsg = $("#idMsg");
	let contentType = "application/x-www-form-urlencoded; charset=UTF-8;";
	
	if ( userid == "" ){
		showErrorMsg(oMsg, "필수 정보입니다.");
		return false;
	}
	
	let isID = /^[a-z0-9][a-z0-9_\-]{4,12}$/;
	if (!isID.test(userid)){
		showErrorMsg(oMsg, "5~13자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
		return false;
	}
	
	// getmappring에서 쿼리스트링 어케 받아야하는지
	/* $.ajax({
		type : "GET",
		url : "/member/idConfirm/" + userid,
		contentType: contentType,
		success : function(result){
			if(result == "Y"){
				if(event == "first"){
					showSuccessMsg(oMsg, "멋진 아이디네요!");
				}
			}
			else{
				showErrorMsg(oMsg, "이미 사용중이거나 탈퇴한 아이디입니다.");
			}
		},
		error : function(error){
			alert("실패했습니다");
		}
	}); */
	
	idFlag = false;
	$.ajax({
		type : "GET",
		url : "/member/idConfirm?userid=" + userid,
		contentType: contentType,
		success : function(result){
			if(result == "Y"){
				if(event == "first"){
					showSuccessMsg(oMsg, "멋진 아이디네요!");
				} else{
					hideMsg(oMsg);
				}
				idFlag = true;
			}
			else{
				showErrorMsg(oMsg, "이미 사용중이거나 탈퇴한 아이디입니다.");
			}
		},
		error : function(error){
			alert("실패했습니다");
		}
	});
	
	return true;
}


// 비밀번호 검사
function checkPswd1(){
	if(pwFlag) return true;
	
	let pw = document.getElementById("pswd1").value;
	let userid = document.getElementById("userid").value;
	let oInput = $("#pswd1");
	let oMsg = $("#pswd1Msg");
	let oSpan = $("#pswd1Span");
	
	
	if( pw == "" ){
		showErrorMsg(oMsg, "필수 정보입니다.");
		setFocusToInputObject(oInput);
		return false;
	}
	
	if(isValidPasswd(pw) != true){
		showErrorMsg(oMsg, "8~25자 영문 대 소문자, 숫자를 사용하세요. (특수문자 사용가능)");
		setFocusToInputObject(oInput);
		return false;
	}
	
	pwFlag = false;
	$.ajax({
		type : "GET",
		url : "/user/pswdCheck?userid=" + escape(encodeURIComponent(userid)) + "&pw=" + escape(encodeURIComponent(pw)),
		success : function(data){
			if(data == 1){
				showSuccessMsg(oMsg, "안전");
				setFocusToInputObject(oInput);
			}else if(data == 2){
				showErrorMsg(oMsg, "8~25자 영문 대 소문자, 숫자, 특수문자를 사용하세요");
				return false;
			}
			pwFlag = true;
		},
		error : function(error){
			alert("실패했습니다.");
		}
	});

}

// 비밀번호 재확인
function checkPswd2(){
	
	let pswd1 = $("#pswd1");
	let pswd2 = $("#pswd2");
	let oMsg = $("#pswd2Msg");
	let oInput = $("#pswd2");
	
	
	if(pswd2.val() == ""){
		showErrorMsg(oMsg, "필수 정보입니다");
		setFocusToInputObject(oInput);
		return false;
	}
	
	if(pswd1.val() != pswd2.val()){
		showErrorMsg(oMsg, "비밀번호가 일치하지 않습니다");
		setFocusToInputObject(oInput);
		return false;
	}else{
		showSuccessMsg(oMsg, "일치합니다");
		return true;
	}
	
	return true;
	
}

// 가입하기 클릭시 모든 input 검사
function checkUnrealInput() {
    if (checkId('join')
        & checkPswd1()
        & checkPswd2()
    ) {
        return true;
    } else {
        return false;
    }
}


// 비밀번호 유효성 검사
function isValidPasswd(str){
	
	var cnt = 0;
	if (str == ""){
		return false;
	}
	
	// 공백이 포함돼있는지 아닌지
	let retVal = checkSpace(str);
	if (retVal){
		return false;
	}
	if(str.length < 8){
		return false;
	}
	
	// 똑같은 단어 계속 못쓰게끔
	for (var i = 0; i < str.length; ++i) {
        if (str.charAt(0) == str.substring(i, i + 1))
            ++cnt;
    }
	if(cnt == str.length){
		return false;
	}
	
	let isPW = /^[A-Za-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{8,16}$/;
	
	// let isPW = /^[a-z0-9][A-Za-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{8,26}$/;
	// let isPW = /^[a-z0-9][A-Za-z0-9][A-Za-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{8,26}$/;
	if(!isPW.test(str)){
		return false;
	}
	
	
	return true;
}



// input 포커스해주는 함수
function setFocusToInputObject(obj){
	if(submitFlag){
		 submitFlag = false;
         obj.focus();
	}
}


// 띄어쓰기 검사
function checkSpace(str) {
    if (str.search(/\s/) != -1) {
        return true;
    } else {
        return false;
    }
}



// 성공메시지 함수
function showSuccessMsg(obj, msg){
	
	obj.attr("class", "error_next_box_green");
	obj.html(msg);
	obj.show();
	
}

// 에러메시지 함수
function showErrorMsg(obj, msg){

	 obj.attr("class", "error_next_box");
     obj.html(msg);
     obj.show();
     
}

var isShift = false;
function checkShiftUp(e){
	if (e.which && e.which == 16) {
        isShift = false;
    }
}

function checkShiftDown(e) {
    if (e.which && e.which == 16) {
        isShift = true;
    }
}

// 캡스록 검사
function checkCapslock(e){
	
	let myKeyCode = 0;
	let myShiftKey = false;
	
	if(window.event){  // IE
		myKeyCode = e.keyCode;
		myShiftKey = e.shiftKey;
	}else if(e.which){  // netscape ff opera
		myKeyCode = e.which;
		myShiftKey = isShift;
	}
	
	let oMsg = $("#pswd1Msg");
	if((myKeyCode >= 65 && myKeyCode <= 90) && !myShiftKey){
		showErrorMsg(oMsg, "Caps Lock이 켜져 있습니다.");
	}else if ((myKeyCode >= 97 && myKeyCode <= 122) && myShiftKey) {
        showErrorMsg(oMsg,"Caps Lock이 켜져 있습니다.");
    } else{
		hideMsg(oMsg);
	}
	
}


function checkCapslock2(e){
	
	let myKeyCode = 0;
	let myShiftKey = false;
	 
	if(window.event){   // IE
		myKeyCode = e.keyCode;
		myShiftKey = e.shiftKey;
	}else if(e.which){  // netscape ff opera
		myKeyCode = e.which;
		myShiftKey = isShift;
	}
	
	let oMsg = $("#pswd2Msg");
	if((myKeyCode >= 65 && myKeyCode <= 90) && !myShiftKey){
		showErrorMsg(oMsg, "Caps Lock이 켜져 있습니다.");
	} else if ((myKeyCode >= 97 && myKeyCode <= 122) && myShiftKey) {
        showErrorMsg(oMsg,"Caps Lock이 켜져 있습니다.");
    } else{
		hideMsg(oMsg);
	}
	
}


function hideMsg(obj) {
    obj.hide();
}





   
   
   
   
   
   
   
      
   