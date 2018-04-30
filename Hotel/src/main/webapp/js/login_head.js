 $(document).ready(function(){
	if($('#logout').html()=="欢迎"){
		console.log($('#logout').html());
		$('#login1').show();
		$('.logout').hide();
		
	}else{
		console.log($('#logout').html());
		$('#login1').hide();
		$('.logout').show();
	}
 })
 