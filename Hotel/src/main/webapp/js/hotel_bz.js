/**
 * 自己写的首页相关js
 */
$(function(){
	showIndex();
	/*orderClick();*/
});
function showIndex(){
	var url="showIndex.do";
	$.post(url,function(result){
		//result是个map
		if(result.state==1){//成功，显示信息
			var map = result.data;
			$("#h2_normal_sp1_bz").html("逸林"+map.normal.roomStyle);
			$("#h4_business1_sp1_bz").html(map.business.roomStyle+"￥"+map.business.originalPrice);
			$("#h4_luxury1_sp1_bz").html(map.luxury.roomStyle+"￥"+map.luxury.originalPrice);
			$("#h4_flatlet1_sp1_bz").html(map.flatlet.roomStyle+"￥"+map.flatlet.originalPrice);
		}else{
			alert(result.message);
		}
	});
}


/**
 * 预订信息
 *//*
function orderClick(){
	var url="details.do";
	var params = {"roomStyle":$("#h2_normal_sp1_bz").html()};
	$.post(url,params,function(result){
		
		window.location.herf="showDetails.do";
		orderShow();
	});
}

function orderShow(){
	var url="showDetails.do";
	$.post(url,function(result){
		
		console.log("orderShow:"+result.data);
		
	});
}*/


