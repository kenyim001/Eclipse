package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	@Autowired
	@Qualifier("cp")
		private Computer cp;

		public Computer getCp() {
			return cp;
		}
		
//		@Autowired
//		//找类型为ByType 为computer的类型
//		public void setCp(@Qualifier("cp") Computer cp) {
//			System.out.println("setCp()");
//			this.cp = cp;
//		}

		public Manager() {
			System.out.println("Manager()");
		}

		@Override
		public String toString() {
			return "Manager [cp=" + cp + "]";
		}
		
		
}
