package ioc;

public class Manager {
	private Compiler cp;
		public Manager(){
			System.out.println("Manager()");
		}
		public Manager(Compiler cp) {
			System.out.println("Manager(cp)");
			this.cp = cp;
		}
		@Override
		public String toString() {
			return "Manager [cp=" + cp + "]";
		}
		
}
