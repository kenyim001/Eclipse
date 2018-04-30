package ioc;

public class Restaurant {
	private Waiter waiter;

	public Restaurant(Waiter waiter) {
		System.out.println("Restaurant(waiter)");
		this.waiter = waiter;
	}

	@Override
	public String toString() {
		return "Restaurant [waiter=" + waiter + "]";
	}

	/*public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	public Restaurant() {
		System.out.println("Restaurant()");
	}

	public void Service(){
		System.out.println("Service()");
	}
	*/
}
