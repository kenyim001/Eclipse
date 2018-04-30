package ioc;

public class Manager {
	private Computer cp;


	public void setCp(Computer cp) {
		System.out.println("setCP()");
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}


	public Manager() {
		System.out.println("manager()");
	}
	
		
}
