
/**
 * 自己写的rooms相关js
 */
$(document).ready(function(){
	showRooms();
});

function showRooms(){
	var url="showRooms.do";
	$.post(url,function(result){
		//result是个map
		if(result.state==1){//成功，显示信息
			var map = result.data;
			$("#h3_rooms_sp1_business_bz").html("高级"+map.business.roomStyle);
			$("#h3_rooms_sp2_luxury_bz").html(map.luxury.roomStyle);
			$("#h3_rooms_sp3_flatlet_bz").html(map.flatlet.roomStyle);
		}else{
			alert(result.message);
		}
	});
}