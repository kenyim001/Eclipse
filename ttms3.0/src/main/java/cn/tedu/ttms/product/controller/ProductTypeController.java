package cn.tedu.ttms.product.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.product.entity.ProductType;
import cn.tedu.ttms.product.service.ProductTypeService;
import cn.tedu.ttms.util.JsonResult;

@Controller
@RequestMapping("/product/type/")
public class ProductTypeController {

	@Resource
	private ProductTypeService productTypeService;
	
	@RequestMapping("listUI")
	public String listUI() {
		return "product/product_type_list";
	}
	@RequestMapping("editUI")
	public String editUI() {
		return "product/product_type_edit";
	}
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		List<Map<String,Object>> map=
				productTypeService.findObjects();
		System.out.println("ProductTypeController.map="+map);
		return new JsonResult(map);
	}
	@RequestMapping("doFindTreeNodes")
	@ResponseBody
	public JsonResult doFindTreeNodes() {
		List<Map<String,Object>> map=
				productTypeService.findTreeNodes();
		System.out.println("ProductTypeController.map="+map);
		return new JsonResult(map);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(ProductType type) {
		productTypeService.saveObject(type);
		return new JsonResult();
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(ProductType type) {
		productTypeService.updateObject(type);
		return new JsonResult();
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		Map<String,Object> map=productTypeService.findObjectById(id);
		return new JsonResult(map);
	}
	@RequestMapping("doDeleteObjectById")
	@ResponseBody
	public JsonResult doDeleteObjectById(Integer id) {
		productTypeService.deleteObjectById(id);
		return new JsonResult();
	}
	
	
}
