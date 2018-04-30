package ¿Îºóday02;

import java.util.Arrays;

public class Person {
	private String name;
	private  int age;
	private String gender;
	private int sal;
	
	public Person(String name, int age, String gender, int sal) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.sal = sal;
	}

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Person [mane=" + name + ", age=" + age + ", gender=" + gender + ", sal=" + sal + "]";
	}
	
	
}