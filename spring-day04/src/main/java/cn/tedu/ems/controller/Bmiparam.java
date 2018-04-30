package cn.tedu.ems.controller;
	/**
	 * 用于封装请求参数属性名与请求参数名一样
	 * 类型要一致(spring会帮我们做类型转换)
	 * 并且提供相应的get/set方法
	 * @author kenyim
	 *
	 */
public class Bmiparam {
	private double height;
	private double weight;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
