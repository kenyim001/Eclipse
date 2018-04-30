package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Restaurant {

		private Waiter wt;
		public Waiter getWt() {
			return wt;
		}
		@Autowired
		public void setWt(@Qualifier("wt") Waiter wt) {
			System.out.println("setWt()");
			this.wt = wt;
		}
		@Override
		public String toString() {
			return "Restaurant [wt=" + wt + "]";
		}
		public Restaurant(){
			System.out.println("Restaurant()");
			
		}
		
}
