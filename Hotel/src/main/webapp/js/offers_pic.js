$(function(){
	$(".img-responsive").stop().animate({"opacity":0.85},0);
	//鼠标悬浮时，图片变亮
	$(".img").hover(
			function(event){
				/*alert(event.target.nodeName);*/
				$(this).children().eq(1).stop().animate({"opacity":1});
				$(this).children().eq(0).fadeIn(800);
			},
			function(){
				$(this).children().eq(1).stop().animate({"opacity":0.85});
				$(this).children().eq(0).css("display","none");
			}
		);
});

//点击弹出大图
$(function(){
	showBigPic();
});

function showBigPic(){
	$(".img").click(function(){
		$(".picandbutton").fadeIn(400).css("display","block");
		var src=$(this).children().eq(1).attr("src");
		//放大图的src赋值
		$("#bigpic").attr("src",src);
	});
}


//设置弹出大图下面的按钮，鼠标悬浮变亮
$(function(){
	$(".button>img").stop().animate({"opacity":0.60});
	$(".button>img").hover(
			function(){
				$(this).stop().animate({"opacity":1});
			},
			function(){
				$(this).stop().animate({"opacity":0.60});
			}
		);
});

//设置弹出大图下面的按钮， 切换图片
$(function(){
	var n;
	var src;
	var dotpos;
	var suffix;
	var name;
	
	$(".btn").click(function(){
		if(!n){
			n=1;
			src=$("#bigpic").attr("src");
			dotpos=src.lastIndexOf(".");
			suffix=src.substr(dotpos);
			name=src.split(suffix);
		}
		
		var id=$(this).attr("id");
		
		if(id=="nextpic" && n<2){
			$("#bigpic").attr("src",name[0]+"-"+(++n)+suffix);
			return;
		}
		if(id=="prevpic" && n>2){
			$("#bigpic").attr("src",name[0]+"-"+(--n)+suffix);
			return;
		}else if(id=="prevpic" && n==2){
			$("#bigpic").attr("src",src);
			n--;
			return;
		}
		if(id=="closepic"){
			$(".picandbutton").css("display","none");
			n="";
			
			$(".overbody").css("display","none");
		}
	});
});

//除大图区域外其它区域变暗
$(function(){
	$(".img").click(function(){
			$(".overbody").css("display","block");
			$(".overbody").stop().animate({"opacity":0.60},0);
	});
});