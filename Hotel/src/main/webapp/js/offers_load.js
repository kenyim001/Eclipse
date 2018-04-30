//页面加载时Ajax异步请求加载房间记录
$(function(){
	getPageObjects();
});


//加载Offers
function getPageObjects(){
	var url="offers.do";
	var params={"pageCurrent":$(".pages").data("pageCurrent")};
	$.post(url,params,function(result){
		if(result.state==1){
			var list=result.data.offers;
			fillOffers(list);
			var pageObject=result.data.pageObject;
			setPages(pageObject);
			
		}else{
			alert(result.message);
		}
	});
}

//填充页面
function fillOffers(list){
	$(".showoffers").empty();
	for(var i=0;i<list.length;i++){
		console.log(list[i].roomStyle);
		$(".showoffers").append(
		'<div class="col-md-4 offers-left">'+
			'<div class="area">'+
				'<h3 class="roomStyle">'+list[i].roomStyle+'</h3>'+
				'<div class="img">'+
					'<p class="imgmsg">点击放大</p>'+
					'<img src="'+list[i].url+'" class="img-responsive" alt=""/>'+
				'</div>'+
				'<div>'+
					'<div>'+
						'<p>'+
							'<span class="bedStyle">'+list[i].bedStyle+'</span>：<span class="description">'+list[i].description+'</span>'+
						'</p>'+
						'<p class="pricearea">'+
							'现在预订，每晚只需￥<span class="price">'+list[i].originalPrice+'</span>'+
						'</p>'+
					'</div>'+
				'</div>'+
			'</div>'+
			'<a class="hvr-shutter-in-horizontal" href="javascript:;">预订</a>'+
			'<div>'+
				'<input type="hidden" class="hidden_roomStyle" value="'+list[i].roomStyle+'"/>'+
				'<input type="hidden" class="hidden_bedStyle" value="'+list[i].bedStyle+'"/>'+
				'<input type="hidden" class="hidden_price" value="'+list[i].originalPrice+'"/>'+
			'</div>'+
		'</div>'
		);
	}
	
	$(".showoffers").append('<script type='+'"text/javascript" '+'src="js/offers_pic.js"/>');
	$(".showoffers").append('<script type='+'"text/javascript" '+'src="js/offers.js"/>');
}


