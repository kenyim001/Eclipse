
$(function(){
	$("#IDNumberId").blur(checkIDNumber);
	$("#emailId").blur(checkEmail);
	$("#telephoneId").blur(checkTelephone);
	$("#personCountId").blur(checkPersonCount);
	
	console.log("qqqq");
})

	
	
	
	//身份证格式检查
	function checkIDNumber(){
		if(!$("#IDNumberId").val()){
			$("#IDNumberId_error").html("");
			return;
		}
		var pattern = /(^\d{15}$)|dfdf(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
		if(!pattern.test($("#IDNumberId").val())){
			$("#IDNumberId_error").html("身份证输入有误");
			return false;
		}else{
			$("#IDNumberId_error").html("");
			return true;
		}
	}
	
	
	//邮箱格式检查
	function checkEmail(){
		if(!$("#emailId").val()){
			$("#emailId_error").html("");
			return;
		}
		var pattern = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if(!pattern.test($("#emailId").val())){
			$("#emailId_error").html("邮箱输入有误");
		}else{
			$("#emailId_error").html("");
		}
	}
	
	//手机格式检查
	function checkTelephone(){
		if(!$("#telephoneId").val()){
			$("#telephoneId_error").html("");
			return;
		}
		var pattern = /^1[34578]\d{9}$/;
		if(!pattern.test($("#telephoneId").val())){
			$("#telephoneId_error").html("号码输入有误");
			return false;
		}else{
			$("#telephoneId_error").html("");
			return true;
		}
	}
	
	//人数格式检查
	function checkPersonCount(){
		if(!$("#personCountId").val()){
			$("#personCountId_error").html("");
			return;
		}
		if(isNaN($("#personCountId").val())){
			$("#personCountId_error").html("人数输入有误");
		}else{
			$("#personCountId_error").html("");
		}
	}
	
	
	
	
	
	
	
