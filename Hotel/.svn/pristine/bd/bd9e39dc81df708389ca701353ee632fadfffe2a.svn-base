$(function(){
	findNoVacancyRoom();
	$("#modal-dialog").on("click",".ok",saveInformation);
	
	$(".hvr-shutter-in-horizontal").click(showModal_Information);
	
	//当模态框隐藏时在.ok上绑定的事件执行解绑动作
	$("#modal-dialog").on("hidden.bs.modal",function(){
		$(this).off('click','.ok');
		console.log("解除事件");
		
	});
});


//根据查询是否还有剩余空闲房间来判定某类房间是否已被约满
function findNoVacancyRoom(){
	$(".hvr-shutter-in-horizontal").each(function(){
		var a=$(this);
		var roomStyle=$(this).next().children().eq(0).val();
		/*$(".roomStyle").data("roomStyle",roomStyle);*/
		var bedStyle=$(this).next().children().eq(1).val();
		/*$(".bedStyle").data("bedStyle",bedStyle);*/
		/*var originalPrice=$(this).next().children().eq(2).val();*/
		/*$(".price").data("originalPrice",originalPrice);*/
		
		var params={
				"roomStyle":roomStyle,
				"bedStyle":bedStyle
				}
		var url="doFindVacancyRoomNo.do";
		$.post(url,params,function(result){
			if(result.state==1){
				
				//有空房则弹出modal框
				/*a.click(function(){
					var url="information_form.do";
					$("#modal-dialog .modal-body").load(url,function(){
						$("#roomStyle_form").val(roomStyle);
						$("#bedStyle_form").val(bedStyle);
						$("#price_form").val(originalPrice);
						
						$("#modal-dialog").modal("show");
					});
				});*/
				
			}else{
				a.html("已满").css("color","#ccc");
			}
		
		})
		
	})
}



//显示预订的才可以弹出Modal
function showModal_Information(){
	console.log($(this).text());
	if($(this).html()=="预订"){
		var roomStyle=$(this).next().children().eq(0).val();
		var bedStyle=$(this).next().children().eq(1).val();
		var originalPrice=$(this).next().children().eq(2).val();
		var url="information_form.do";
		$("#modal-dialog .modal-body").load(url,function(){
			$("#roomStyle_form").val(roomStyle);
			$("#bedStyle_form").val(bedStyle);
			$("#price_form").val(originalPrice);
			
			$("#modal-dialog").modal("show");
		});
	}
}





//提交预订信息
function saveInformation(){
		console.log("提交预订信息");
		var requirements=checkIDNumber()+checkTelephone()+$("#editFormId").valid();
		if(requirements==3){
			var userUrl="doInsertUserInformation.do";
			var userParams=getFormUserParams();
			$.post(userUrl,userParams,function(result){
				if(result.state==1){
					submitRoomInfo();
					console.log("chengogng")
				}else{
					alert("预订失败");
				}
			});
		}
	}

//提交room信息
function submitRoomInfo(){
	var roomUrl="doUpdateRoomInformation.do";
	var roomParams=getFormRoomParams();
	$.post(roomUrl,roomParams,function(data){
		if(data.state==1){
			alert("预订成功");
			console.log("chengogng22")
			$("#modal-dialog").modal("hide");
			findNoVacancyRoom();
		}else{
			alert("预订失败");
		}
	});
	
}


//获取Form中User的参数
function getFormUserParams(){
	var userParams={
			"name":$("#nameId").val(),
			"gender":$("#genderId").val(),
			"IDNumber":$("#IDNumberId").val(),
			"telephone":$("#telephoneId").val(),
			"email":$("#emailId").val(),
			"remarks":$("#remarksId").val()
	};
	return userParams;
}

//获取Form中Room的参数
function getFormRoomParams(){
	var roomParams={
			"checkin":$("#checkinId").val(),
			"checkout":$("#checkoutId").val(),
			"personCount":$("#personCountId").val(),
			"roomStyle":$("#roomStyle_form").val(),
			"bedStyle":$("#bedStyle_form").val(),
			"IDNumber":$("#IDNumberId").val()
	};
	return roomParams;
}


/*
//获取空闲房间号
function getVacancyRoomNo(){
	//绑定数据
	var roomStyle=$(this).next().children().eq(0).val();
	$(".roomStyle").data("roomStyle",roomStyle);
	var bedStyle=$(this).next().children().eq(1).val();
	$(".bedStyle").data("bedStyle",bedStyle);
	var originalPrice=$(this).next().children().eq(2).val();
	$(".price").data("originalPrice",originalPrice);

	
	var params={
			"roomStyle":$(".roomStyle").data("roomStyle"),
			"bedStyle":$(".bedStyle").data("bedStyle")
	}
	
	var url="doFindVacancyRoomNo.do";
	
	$.post(url,params,function(result){
		if(result.state==1){
			console.log("doFindVacancyRoomNo:"+result.data.length+" 第一个: "+result.data[0]);
			$("#modal-dialog .modal-body").data("roomNo",result.data[0]);
			console.log($("#modal-dialog .modal-body").data("roomNo"));
			
			//有空房则弹出modal框
			showModal();
			
		}else{
			alert(result.message);
		}
	});
}

//有空房则弹出modal框
function showModal(){
	var url="information_form.do";
	$("#modal-dialog .modal-body").load(url,function(){
		$("#roomStyle_form").val($(".roomStyle").data("roomStyle"));
		$("#bedStyle_form").val($(".bedStyle").data("bedStyle"));
		$("#price_form").val($(".price").data("originalPrice"));
		
		console.log($("#editFormId").data("roomNo"));
		
		$("#modal-dialog").modal("show");
		
	});
}
*/








