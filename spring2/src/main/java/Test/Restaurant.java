package Test;

public class Restaurant {
			public Waiter waiter;
			public void setWaiter(Waiter waiter){
				System.out.println("setWaiter()");
				this.waiter=waiter;
			}
			public Restaurant(){
				System.out.println("Restaurant()");	
				}
		public void execute(){
			System.out.println("execute()");
			//����B��F1()����
			waiter.f1();
			
		}
		}