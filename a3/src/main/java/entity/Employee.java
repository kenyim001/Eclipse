package entity;

public class Employee {
		private int id;
		private String name;
		private Double salary;
		private int age;
		
		public Employee(int id, String name, Double salary, int age) {
			super();
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.age = age;
		}
		public Employee() {
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
		}
		
		
}
