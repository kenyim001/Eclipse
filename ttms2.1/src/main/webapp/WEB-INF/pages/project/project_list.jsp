<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<title>Insert title here</title>
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap-datepicker.min.css" />
<script type="text/javascript" src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${basePath}/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${basePath}/js/project/project_list.js"></script>
<script type="text/javascript" src="${basePath}/js/common/page.js"></script>
</head>
<body>
 <!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<h3>旅游管理系统</h3>
				<ol class="breadcrumb">
				  <li>产品管理</li>
				  <li>项目管理</li>
				  <li class="active">项目信息管理</li>
				</ol>
			</div>
			<div class="page-stats"></div>
		</div>
		<form method="post" id="queryFormId">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><input type="text" id="searchNameId" class="form-control"placeholder="公司名称"></li>
					<li><select id="searchValidId" class="form-control">
							<option value="">选择状态</option>
							<option value="1">启用</option>
							<option value="0">禁用</option>
					</select></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
					<li class='O2'><button type="button" class="btn btn-primary btn-add">添加</button></li>
					<li class='O3'><button type="button" class="btn btn-primary btn-invalid">禁用</button></li>
					<li class='O4'><button type="button" class="btn btn-primary btn-valid">启用</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
						   <th>选择</th>
							<th>项目编码</th>
							<th>项目名称</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="tbodyId">
					</tbody>
				</table>
				<%@include file="../common/page.jsp" %>
			</div>
		</form>
	</div>  
	
 <!-- Modal(模态框) -->
 <div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary ok">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- modal -->
</body>
</html>





