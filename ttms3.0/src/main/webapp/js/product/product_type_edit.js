var ztree,SUCCESS=1,typeId; 
var setting = {
	data : {
		    simpleData : {
			enable : true,
			idKey : "id",  //节点数据中保存唯一标识的属性名称
			pIdKey : "parentId",  //节点数据中保存其父节点唯一标识的属性名称
			rootPId : null  //根节点id
		}
	}
}
$(document).ready(function(){
	typeId=$('#container').data('typeId');
	if(typeId)doGetObjectById();
	$('#editTypeForm').on('click','.text-parentType',showTreeLayer);
	$('#typeLayer').on('click','.btn-cancle',hideTreeLayer);
	//选择菜单点击确定
	$('#typeLayer').on('click','.btn-confirm',setTreeNodeSelected);
	//点击返回
	$('#btn-return').click(doBack);
	//点击确定按钮提交
	$('#btn-save').click(doSaveOrUpdate);
});


/**根据id查找ProductType对象*/
function doGetObjectById(){
	var url = 'product/type/doFindObjectById.do';
	var params = {'id':typeId};
	$.post(url,params,function(result){
		if(result.state ==SUCCESS){
			doFillUpdateForm(result.data);
		}else{
			alert(result.message);
		}
	})
}

function doFillUpdateForm(type){
	$('#editTypeForm').data('parentId',type.parentId);
	$('#typeNameId').val(type.name);
	$('#parentNameId').val(type.parentName);
	$('#typeSortId').val(type.sort);
	$('#typeNoteId').html(type.note);
}

//返回
function doBack(){
	clearForm();
	var url = 'product/type/listUI.do';
	$('#container').load(url);
}

//清空表单数据
function clearForm(){
	$('#editTypeForm .dynamicClear').val('');
	$('#container').data('typeId','');
	$('#editTypeForm').data('parentId','');
}

function doSaveOrUpdate(){
	if($('#editTypeForm').valid()){
		var params = doGetFormValues();
		var typeId = $('#container').data('typeId');
		if(typeId)params.id=typeId;
		var url=typeId?'product/type/doUpdateObject.do':'product/type/doSaveObject.do';
		$.post(url,params,function(result){
			if(result.state == SUCCESS){
				alert('操作成功！');
				$('#container').load('product/type/listUI.do');
			}else{
				alert(result.message);
			}
		})
	}
}
//获取表单参数
function doGetFormValues(){
	var name = $('#typeNameId').val();
	var parentId = $('#editTypeForm').data('parentId');
	var sort = $('#typeSortId').val();
	var note = $('#typeNoteId').val();
	
	var params = {
			'name':name,
			'parentId':parentId,
			'sort':sort,
			'note':note
	}
	return params;
}
//显示选择菜单
function showTreeLayer(){
	$('#typeLayer').css('display','block');
	loadTypeTreeData();
}
//隐藏选择菜单
function hideTreeLayer(){
	$('#typeLayer').css('display','none');
}
//加载菜单树
function loadTypeTreeData(){
	var url = 'product/type/doFindTreeNodes.do';
	$.getJSON(url,function(result){
		if(result.state==SUCCESS){
			ztree = $.fn.zTree.init($("#typeTree"),setting,result.data);
		}else{
			alert(result.message);
		}
	})
}
//获取选择菜单选中项
function setTreeNodeSelected(){
	 var node = ztree.getSelectedNodes();
	 var parentId = node[0].id;
	 $('#typeLayer').css('display','none');
	 $('#parentNameId').val(node[0].name);
	 $('#editTypeForm').data('parentId',node[0].id);
}