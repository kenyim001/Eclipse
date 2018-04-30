package ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class UserBean {
	@Value("°²µÏ")
		private String name;
	@Value("#{config.pageSize}")
		private String PageSize;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPageSize() {
			return PageSize;
		}
		public void setPageSize(String pageSize) {
			PageSize = pageSize;
		}
		@Override
		public String toString() {
			return "UserBean [name=" + name + ", PageSize=" + PageSize + "]";
		}
}
