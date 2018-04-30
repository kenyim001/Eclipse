package Test1;

public class Car {
	private Engineer eg;
		public Car(){
			System.out.println("car()");
		}
		public Car(Engineer eg) {
		System.out.println("Engineer(eg)");
			this.eg = eg;
		}
		@Override
		public String toString() {
			return "Car [eg=" + eg + "]";
		}
		

}
