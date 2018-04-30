$(document).ready(function(){
	   //页面加载完成执行此方法
	   //1.发起ajax请求(findObjects.do)
	   //2.将返回的结果填充到content位置
	    doGetObjects();
});
//获取项目信息
function doGetObjects(){
	   var url="findPageObjects.do";
	   var params=getQueryFormData();
	   var pageCurrent=$("#pageId").data("pageCurrent");
	   if(pageCurrent){params.pageCurrent=pageCurrent};
	   console.log(params.name+"/"+params.valid+"/"+pageCurrent);
	   $.post(url,params,function(result){
		setTableRows(result.list);
		setPagination(result.pageObject);	
	   });
   }
	

	   function getQueryFormData(){
		   var params={
				   "name":$("#searchNameId").val(),
				   "valid":$("#searchValidId").val()
		   }
		   return params;
	   }
	   
	   
	   function setTableRows(list){
		   var tBody=$('#tbodyId');
	   tBody.empty();
	
	   var temp='<td><input type="checkbox" name="checkedItem" value="[id]"></td>'
       +'<td>[code]</td>'
       +'<td>[name]</td>'
       +'<td>[beginDate]</td>'
       +'<td>[endDate]</td>'
       +'<td>[valid]</td>'
       +'<td>修改</td>'
	   //追加新的数据
	   for(var i in list){//循环一次取一行数据(对应一对tr对象)
	   var tr=$('<tr></tr>');//创建一对tr对象
       tr.append(temp
       .replace('[id]',list[i].id)
       .replace('[code]',list[i].code)		        
       .replace('[name]',list[i].name)
       .replace('[beginDate]',
    	new Date(list[i].beginDate).toLocaleDateString())
       .replace('[endDate]',new Date(list[i].endDate).toLocaleDateString())
       .replace('[valid]',list[i].valid?'启用':'禁用')
        );
       tBody.append(tr);//将tr对象追加tbody
	   }
   }