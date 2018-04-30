package action;

import java.util.Arrays;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class BeanAction {
	
	
	private String name;
	private int age;
	private double salary;
	private String[] friends;
	
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
	public String[] getFriends() {
		return friends;
	}
	public void setFriends(String[] friends) {
		this.friends = friends;
	}
	@Override
	public String toString() {
		return "BeanAction [name=" + name + ", age=" + age + ", salary=" + salary + ", friends="
				+ Arrays.toString(friends) + "]";
	}

	public String execute(){
		name="李小龙";
		age=18;
		salary=10.0;
		friends=new String[]{"熊大","小鸡"};
		return "success";
				
	}	
}
