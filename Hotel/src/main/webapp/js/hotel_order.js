$(document).ready(function(){
	 $("#queryFormId").on("click",".btn-search",getPageObjects);
	 $("#queryFormId").on("click",".btn-valid,.btn-invalid",doUpdateValid);
	getPageObjects();
});

function getPageObjects(){
	

	var params=getQueryFormData();	
	
	if(params.name!='' && params.name!=null ||params.valid!='' && params.valid!=null){
		
		var url="findOrderNameMsg.do"
			$.post(url,params,function(map){	
				
				var result=map.data.idList;
			
				setSercahOrder(result);
				var pageObject=map.data.pageObject;
						
				setPages(pageObject)
			});	
	}else{
		
		var url="findOrderMsg.do"
	$.post(url,params,function(map){	
		
		var result=map.data.list;
		
		setOrder(result);
		var pageObject=map.data.pageObject;
			
		setPages(pageObject)
	});	
	}
}
function setSercahOrder(result){
	 var tBody=$("#hotelMsg");
	 tBody.empty();		 
	 for(var i in result){
		
		 var tr=$('<tr></tr>')
		tr.data("orderNumber",result[i].orderNumber)
		 var tds=
			 '<td><input type="checkbox" name="checkedItem" value="'+result[i].orderNumber+'"/></td>'
			 +'<td>'+((result[i].valid)?"有效":"无效")+'</td>'
			 +'<td>'+result[i].orderNumber+'</td>'
		      +'<td>'+result[i].name+'</td>'
		      +'<td>'+result[i].gender+'</td>'
		      +'<td>'+result[i].idnumber+'</td>'
		      +'<td>'+result[i].telephone+'</td>'
		      +'<td>'+new Date(result[i].checkin).toLocaleDateString()+'</td>'
		      +'<td>'+new Date(result[i].checkout).toLocaleDateString()+'</td>'
		      +'<td>'+result[i].discount+'</td>'
		      +'<td>'+((result[i].paymentStatus)?"已付":"未付")+'</td>'
		      +'<td>'+result[i].consumeCount+'</td>'
		      +'<td>'+result[i].originalPrice+'</td>'
		      +'<td>'+result[i].remarks+'</td>'
		         
		      tr.append(tds);
		      tBody.append(tr);
	 }
	
}
function getQueryFormData(){
	var params={
		"name":$("#searchNameId").val(),
		"valid":$("#searchValidId").val(),
		"pageCurrent":$(".pages").data("pageCurrent"),		
	}
	
	
	return params;
}



 function setOrder(result){
	
	 
	 var tBody=$("#hotelMsg");
	 tBody.empty();
	
	 
	 for(var i in result){
		
		 var tr=$('<tr></tr>')
		tr.data("orderNumber",result[i].orderNumber)
		 var tds='<td><input type="checkbox" name="checkedItem" value="'+result[i].orderNumber+'"/></td>'
			 +'<td>'+((result[i].valid)?"有效":"无效")+'</td>'
			 +'<td>'+result[i].orderNumber+'</td>'
		      +'<td>'+result[i].name+'</td>'
		      +'<td>'+result[i].gender+'</td>'
		      +'<td>'+result[i].idnumber+'</td>'
		      +'<td>'+result[i].telephone+'</td>'
		      +'<td>'+new Date(result[i].checkin).toLocaleDateString()+'</td>'
		      +'<td>'+new Date(result[i].checkout).toLocaleDateString()+'</td>'
		      +'<td>'+result[i].discount+'</td>'
		      +'<td>'+((result[i].paymentStatus)?"已付":"未付")+'</td>'
		      +'<td>'+result[i].consumeCount+'</td>'
		      +'<td>'+result[i].originalPrice+'</td>'
		      +'<td>'+result[i].remarks+'</td>'
		     
		     
		      tr.append(tds);
		      tBody.append(tr);
	 }
	 
 }
 function doUpdateValid(){
	 var state;
	 if($(this).hasClass("btn-valid")){
		 state=1;
	 }else{
		 state=0;
	 }
	 var checkedIds=getCheckedIds();
	    
	 var params={"checkedIds":checkedIds,"valid":state}; 
	     var url="updateValid.do"
	   $.post(url,params,function(result){
		   if(result.state==1){
			   getPageObjects();
		   }
	   })
	    	 
	     
		 
 }
 function getCheckedIds(){
	 var checkedIds='';
	 $('tbody input[name="checkedItem"]').each(function(){
		 if($(this).is(":checked")){
			 if(checkedIds==''){
				 checkedIds+=$(this).val();
			 }else{
		         checkedIds+=","+$(this).val();		 
			 }
		 }
	 });
	 return checkedIds;
 }
