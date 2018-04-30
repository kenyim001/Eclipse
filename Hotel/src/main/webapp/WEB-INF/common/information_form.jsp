<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$('.datepicker').datepicker({
    format: 'yyyy/mm/dd',
    autoclose: true//选中自动关闭
})
</script>
<form  class="form-horizontal" role="form" id="editFormId">
	<div class="form-group">
	    <div class="col-sm-10">
	    	<span style="color:red">*</span><span>姓名：</span>
			<input type="text" class="form-control required" name="name" id="nameId"  placeholder="请输入姓名">
	    </div>
	</div>
	<div class="form-group">
	    <div class="col-sm-10">
	    	<span style="color:red">*</span><span>性别：</span>
			<select class="form-control required" name="gender" id="genderId">
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
	    </div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
			<span style="color:red">*</span><span>身份证：</span><span id="IDNumberId_error"></span>
			<input type="text" class="form-control required" name="IDNumber" id="IDNumberId" placeholder="请输入身份证号">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span style="color:red">*</span><span>手机号：</span><span id="telephoneId_error"></span>
		<input type="text" class="form-control required" name="telephone" id="telephoneId" placeholder="请输入手机号">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span>邮箱：</span><span id="emailId_error"></span>
		<input type="text" class="form-control"  name="email" id="emailId" placeholder="请输入邮箱">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span style="color:red">*</span><span>入住时间：</span>
		<input type="text" class="form-control datepicker required"  name="checkin" id="checkinId" placeholder="请输入住时间">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span style="color:red">*</span><span>离店时间：</span>
		<input type="text" class="form-control datepicker required"  name="checkout" id="checkoutId" placeholder="请输离店时间">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span>人数：</span><span id="personCountId_error"></span>
		<input type="text" class="form-control"  name="personCount" id="personCountId" placeholder="请输人数">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span>备注：</span>
		<textarea class="form-control" name="remarks" id="remarksId"></textarea>
		</div> 
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span>您选择的是：</span>
		<span>房型：</span>
		<input type="text" class="roomStyle_form"  name="roomStyle" id="roomStyle_form" readonly>
		<span>床型：</span>
		<input type="text" class="bedStyle_form"  name="bedStyle" id="bedStyle_form" readonly>
		</div> 
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span>每晚价格(￥)：</span>
		<input type="text" class="price_form"  name="originalPrice" id="price_form" readonly>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
		<span>预计总价：</span>
		<input type="text" class="totalprice_form"  name="totalPrice" id="totalprice_form" readonly>
		</div>
	</div>
</form>

<c:url var="url" value="/js/information_form.js"></c:url>
<script type="text/javascript" src="${url}"></script>

