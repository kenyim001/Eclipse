package ¿Îºóday04;

import java.util.Date;

public class Emp{
	private String name;
	private  int age;
	private String gender;
	private int sal;
	private Date hiredate;
	
	public Emp(String name, int age, String gender, int sal,Date hiredate){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.sal = sal;
		this.hiredate=hiredate;
	}
	
	
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getSal() {
		return sal;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + ", gender=" + gender + ", sal=" + sal + ", hiredate=" + hiredate
				+ "]";
	}
}

