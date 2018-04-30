var SUCCESS = 1;

doGetObjects()

//条件查询
$('#formHead').on('click','.btn-search',doGetObjects)
//新增
$('#formHead').on('click','.btn_add',showAddRolePage)
//修改
$('#formHead').on('click','.btn_update',showEditRolePage)

//显示修改角色页面
function showEditRolePage(){
	var selectedOptions = getCheckedIds();
	if(selectedOptions.length==0){
		alert('请选择要修改的选项！');
		return;
	}
	if(selectedOptions.length>1){
		alert('只能选择一项进行修改！');
		return;
	}
	$('#container').data('roleId',selectedOptions[0]);
	$('#container').load('role/editRoleUI.do');
}

//显示新增页面
function showAddRolePage(){
	var url = 'role/editRoleUI.do';
	$('#container').load(url);
}

function doGetObjects(){
	var params = getParams();
	var currentPage=$("#pagination").data('curPage');
	if(currentPage){
		params.pageCurrent=currentPage
	}
	var url = 'role/findObjects.do';
	$.post(url,params,function(result){
		if(result.state==SUCCESS){
			 setTableRows(result.data.list);
			 setPagination(result.data.pageObj);
		}else{
			alert(result.message);
		}
	})
}

//获取条件查询条件
function getParams(){
	var roleName = $('#roleName').val();
	var params = {'name':roleName}
	return params;
}

//初始化列表页面
function setTableRows(list){
	var tBody=$('tbody');
	tBody.empty();
	var tds='<td><input type="checkbox" class="checkbox" name="checkedItem" value="[id]"></td>'+
	        '<td>[roleId]</td>'+
	        '<td>[name]</td>'+
	        '<td>[note]</td>';
	for(var i in list){
	    var tr=$('<tr></tr>');
	    tr.append(tds.replace('[id]',list[i].id)
	    		  .replace('[roleId]',list[i].id)
	    		  .replace('[name]',list[i].name)
	    		  .replace('[note]',list[i].note));
	    
	    tBody.append(tr);
	}
}

//获得选中的id，然后拼接成字符串
function getCheckedIds(){
	var checkedIds = new Array();
	$('tbody input[name="checkedItem"]').each(function(){
		if($(this).is(':checked')){  //或者用prop('checked')
			checkedIds.push($(this).val());
		}
	})
	return checkedIds;
}