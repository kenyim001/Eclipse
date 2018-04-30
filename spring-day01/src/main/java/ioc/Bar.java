package ioc;

public class Bar {
	private Foo foo;

	public Bar(Foo foo) {
		System.out.println("Bar(foo)");
		this.foo = foo;
	}

	public Bar() {
		System.out.println("Bar()");
	}

	@Override
	public String toString() {
		return "Bar [foo=" + foo + "]";
	}
	
}
