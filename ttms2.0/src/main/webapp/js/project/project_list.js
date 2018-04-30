$(document).ready(function(){
$("#queryFormId").on("click",".btn-search",doGetObjects);	
$("#queryFormId").on("click",".btn-valid,.btn-invalid",doValidById);
//页面加载完成执行此方法
//1.发起ajax请求(findObjects.do)
//2.将返回的结果填充到content位置
  doGetObjects();
});
//获取项目信息
function doGetObjects(){
  var url="findPageObjects.do";//findPageObject(Project project,PageObject object)
  //获得查询参数
  var params=getQueryFormData();
  var pageCurrent=$("#pageId").data("pageCurrent");
  if(pageCurrent){params.pageCurrent=pageCurrent};
  console.log(params.name+"/"+params.valid+"/"+pageCurrent);
  $.post(url,params,function(result){//map{"list":[{},{}],"pageObject":{"pageCount":2,...}}
	//设置表格tabody中的内容
	setTableRows(result.list);//map中的list(根据key取值list)
	//设置分页
	setPagination(result.pageObject);
  });
}
//获得查询表单中的数据
function getQueryFormData(){
	var params={
	"name":$("#searchNameId").val(),
	"valid":$("#searchValidId").val()
	}
	return params;
}
//将从服务端获得的列表数据填充的表格中
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
/**启动/禁用*/
function doValidById(){

  //1.判定触发的是启用还是禁用按钮(根据类选择器)
  var state;//定义一个状态值,表示状态
  if($(this).hasClass("btn-valid")){
	  state=1;//启用(将选中的记录的valid修改为1)
  }else{
	  state=0;//禁用
  }
  //2.获得选中的checkbox对应的id值(id是记录的唯一标识)
  var checkedIds=getCheckedIds();
  if(checkedIds==''){
	 alert("至少选择一个");
	 return;
  }
  console.log("checkedIds="+checkedIds);
  var params={"checkedIds":checkedIds,
		      "valid":state};
  //3.获得的数据通过ajax发送异步请求到服务器然后
  //执行更新操作
  var url="doValidById.do";
  $.post(url,params,function(){
	  doGetObjects();
  })
}
function getCheckedIds(){
	var checkedIds='';
	//获得tbody对象中名字为checkedItem的input对象
	$('tbody input[name="checkedItem"]')
	//迭代input对象
	.each(function(){
		//判定这个input对象是否是选中的input
		if($(this).is(":checked")){//$(this).prop("checked")
			//将选中的checkbox的值拼接为字符串
			if(checkedIds==''){
			checkedIds+=$(this).val();
			}else{
			checkedIds+=","+$(this).val();
			}//"1,2,3,4,5";
		};
	})
	return checkedIds;
}










