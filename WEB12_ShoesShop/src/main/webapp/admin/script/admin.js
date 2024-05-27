function loginCheck(){
	if(document.loginForm.userid.value == "" ){
		alert("아이디를 입력하세요");
		document.loginForm.userid.focus();
		return false;
	}else if (document.loginForm.pwd.value == "" ){
		alert("패스워드를 입력하세요");
		document.loginForm.pwd.focus();
		return false;
	}else{
		return true;
	}
}

function go_search(command){
	var url = "shop.do?command=" + command + "&page=1";
	document.frm.action = url;
	document.frm.submit();
}

function go_detail(pseq){
	location.href="shop.do?command=adminProductDetail&pseq=" + pseq;
}

function go_wrt(){
	location.href="shop.do?command=adminProductWriteForm";
}

function cals(){
	var value1 = document.productWriteFrm.price1.value;
	var value2 = document.productWriteFrm.price2.value;
	if( value1 == "" || value2 == "" ){
		return;
	}else{
		document.productWriteFrm.price3.value = value2 - value1;
	}
}

function go_save(){
	var theForm = document.productWriteFrm;
	if(theForm.kind.value == ""){
		alert('상품 분류를 선택하세요');
		theForm.kind.focus();
	} else if(theForm.name.value == ""){
		alert('상품명을 입력하세요');
		theForm.name.focus();
	} else if(theForm.price1.value == ""){
		alert('원가를 입력하세요');
		theForm.price1.focus();
	} else if(theForm.price2.value == ""){
		alert('판매가를 입력하세요');
		theForm.price2.focus();
	} else if(theForm.content.value == ""){
		alert('상품상세를 입력하세요');
		theForm.content.focus();
	} else if(theForm.image.value == ""){
		alert('상품이미지를 입력하세요');
		theForm.image.focus();
	} else {
		theForm.action = "shop.do?command=adminProductWrite";
		theForm.submit();
	}
}

function go_mod(pseq){
	var url="shop.do?command=adminProductUpdateForm&pseq=" + pseq;
	location.href = url;
}

function go_update(){
	var theForm = document.productWriteFrm;
	if(theForm.kind.value == ""){
		alert('상품 분류를 선택하세요');
		theForm.kind.focus();
	} else if(theForm.name.value == ""){
		alert('상품명을 입력하세요');
		theForm.name.focus();
	} else if(theForm.price1.value == ""){
		alert('원가를 입력하세요');
		theForm.price1.focus();
	} else if(theForm.price2.value == ""){
		alert('판매가를 입력하세요');
		theForm.price2.focus();
	} else if(theForm.content.value == ""){
		alert('상품상세를 입력하세요');
		theForm.content.focus();
	} else {
		theForm.action = "shop.do?command=adminProductUpdate";
		theForm.submit();
	}
}

function go_order_save(){
	var theResult = document.frm.result;
	var count=0;
	
	if(theResult.length == undefined){
		if(theResult.checked == true) count++;
	} else{
		for (var i=0; i<theResult.length; i++)
			if(theResult[i].checked == true)
				count++;
	}
	
	if(count ==0){
		alert("주문처리할 항목을 선택해주세요.")
	} else{
		document.frm.action = 'shop.do?command=adminOrderSave';
		document.frm.submit();
	}
}

function go_rep(){
	if(document.frm.reply.value==""){
		alert("답변내용을 입력하세요");
		document.frm.reply.focus();
	} else{
		document.frm.action = "shop.do?command=adminQnaReplyUpdate";
		document.frm.submit();
	}
}