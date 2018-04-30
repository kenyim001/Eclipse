$(document).ready(function(){
	 $("#queryFormId").on("click",".btn-search",searchUser);	 	    
});

function searchUser(){
	  var params={"name":$("#searchNameId").val()}
	  var url="userMsg.do"
		  $.post(url,params,function(map){
			  var result=map.data.user;
			  setSearchUser(result)
		  });
}
function setSearchUser(result){
	 var tBody=$("#hotelMsg");
	 tBody.empty();
	 for(var i in result){
		 var tr=$('<tr></tr>')
		 var tds='<td>'+((result[i].valid)?"有效":"无效")+'</td>'
		 +'<td>'+result[i].orderNumber+'</td>'
		 +'<td>'+result[i].name+'</td>'
		 +'<td>'+result[i].gender+'</td>'
		 +'<td>'+result[i].idnumber+'</td>'
		 +'<td>'+result[i].telephone+'</td>'
		 tr.append(tds);
		 tBody.append(tr);
	 }
	
}
