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
			//调用B的F1()方法
			waiter.f1();
			
		}
		}