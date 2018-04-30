package annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {
		@Value("������δ��")
		private String name;
		
		@Value("#{config.pageSize}")
		private int pageSize;
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		@Override
		public String toString() {
			return "car [name=" + name + ", pageSize=" + pageSize + "]";
		}
		
}
