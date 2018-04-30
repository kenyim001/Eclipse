package cn.tedu.ssh1.vo;

import java.io.Serializable;

public class UserVo implements Serializable {
	private String name;
	private Integer age;
	private Double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "UserVo [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
	
}
