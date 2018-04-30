//设置页码
function setPages(pageObject){
	var pageCount=pageObject.pageCount;//总页数
	var pageCurrent=pageObject.pageCurrent;//当前页
	$(".pages").data("pageCount",pageCount);
	$(".pages").data("pageCurrent",pageCurrent);
	pageNumbers();
}

//分页页码
function pageNumbers(){
	var pageCount=$(".pages").data("pageCount");
	var pageCurrent=$(".pages").data("pageCurrent");
	$(".pageCurrent").empty();
	$(".num").empty();
	for(var i=1;i<=pageCount;i++){
		$(".num").append('&nbsp;<a>'+i+'</a>&nbsp;');
		
	}
	$(".pageCurrent").html("当前:"+pageCurrent+"/"+pageCount+"页");
}


//点击页码和首页等事件函数
$(function(){
	$(".pages").on("click",".first,.pre,.next,.last,.num a",changePageCurrent);
})

function changePageCurrent(){
	var pageCount=$(".pages").data("pageCount");
	var pageCurrent=$(".pages").data("pageCurrent");
	var className=$(this).attr("class");
	console.log(className);
	if(className=='first'){
		$(".pages").data("pageCurrent",1);
	}
	else if(className=='last'){
		$(".pages").data("pageCurrent",pageCount);
	}
	else if(className=='pre' && pageCurrent>1){
		$(".pages").data("pageCurrent",--pageCurrent);
		console.log(pageCurrent);
	}
	else if(className=='next' && pageCurrent<pageCount){
		console.log(pageCurrent);
		console.log("next");
		$(".pages").data("pageCurrent",++pageCurrent);
		console.log(pageCurrent);
	}
	else if("num"==$(this).parent().attr("class")){//页码
		$(".pages").data("pageCurrent",$(this).html());
	}
	getPageObjects();
}

