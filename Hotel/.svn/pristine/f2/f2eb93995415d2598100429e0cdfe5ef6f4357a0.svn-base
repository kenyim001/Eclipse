	//身份证格式检查
	$(function(){
		$("#idnumber").blur(function(){
			var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
			
			if(!pattern.test($("#idnumber").val())){
				$("#idnumbercheck").html("身份证输入有误");
			}else{
				$("#idnumbercheck").html("");
			}
		});
	});

	//邮箱格式检查
	$(function(){
		$("#email").blur(function(){
			var pattern = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			if(!pattern.test($("#email").val())){
				$("#emailcheck").html("邮箱输入有误");
			}else{
				$("#emailcheck").html("");
			}
		});
	});
	
	//手机格式检查
	$(function(){
		$("#phone").blur(function(){
			var pattern = /^1[34578]\d{9}$/;
			if(!pattern.test($("#phone").val())){
				$("#phonecheck").html("号码输入有误");
			}else{
				$("#phonecheck").html("");
			}
		});
	});
	
	
	
	
	
	
	
