package ioc;

public class a {
	private IB b;
	
	public void setB(IB b) {
		System.out.println("setb()");
		this.b = b;
	}
	public a() {
		System.out.println("a()");
	}
	public void service(){
		System.out.println("a's service()");
		b.f1();
		
	}
}
