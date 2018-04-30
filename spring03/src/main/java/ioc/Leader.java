package ioc;

import org.springframework.stereotype.Component;

@Component("leader")
public class Leader {
		private Waiter wt;
		
		public void setWt(Waiter wt){
			System.out.println("setWt()");
			this.wt=wt;
		}

		public Leader() {
			System.out.println("Leader()");
		}

		@Override
		public String toString() {
			return "Leader [wt=" + wt + "]";
		}
		
		
}
