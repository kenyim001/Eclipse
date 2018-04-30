var SUCCESS = 1;
var TypeObject = {
	id : "typeTable",
	table : null,
	layerIndex : -1
};
TypeObject.initColumn = function() {
	var columns = [
			{
				field : 'selectItem',
				radio : true
			},
			{
				title : '分类id',
				field : 'id',
				visible : false,
				align : 'center',
				valign : 'middle',
				width : '80px'
			},
			{
				title : '分类名称',
				field : 'name',
				align : 'center',
				valign : 'middle',
				sortable : true,
				width : '180px'
			},
			{
				title : '上级分类',
				field : 'parentName',
				align : 'center',
				valign : 'middle',
				sortable : true,
				width : '180px'
			},
			{
				title : '排序号',
				field : 'sort',
				align : 'center',
				valign : 'middle',
				sortable : true,
				width : '100px'
			}]
	return columns;
};
$(document).ready(function(){
	$('#formHead').on('click','.btn-add,.btn-update',doLoadEditUI)
	$('#formHead').on('click','.btn-delete',doDeleteById)
	doGetObjects();
})
//显示新增菜单页面
function doLoadEditUI(){
	var url = 'product/type/editUI.do';
	if($(this).hasClass("btn-update")){
		var selected = $('#typeTable').bootstrapTreeTable('getSelections');
		if (selected.length == 0) {
	        alert("请选择一条记录");
	        return false;
	    } 
		$('#container').data('typeId',selected[0].id);
	}
	$('#container').load(url);
}
function doDeleteById(){
	var selected = $('#typeTable').bootstrapTreeTable('getSelections');
	if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } 
	var typeId = selected[0].id
	var params = {'id':typeId};
	var url = 'product/type/doDeleteObjectById.do';
	$.post(url,params,function(result){
		if(result.state==SUCCESS){
			alert('删除成功！');
			doGetObjects();
		}else{
			alert(result.message);
		}
	})
}
function doGetObjects() {
	var colunms = TypeObject.initColumn();
	var table = new TreeTable(TypeObject.id,"product/type/doFindObjects.do", colunms);
	table.setExpandColumn(2);
	table.setIdField("id");
	table.setCodeField("id");
	table.setParentCodeField("parentId");
	table.setExpandAll(false);
	table.init();
	TypeObject.table = table;
}