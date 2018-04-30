package action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")

public class DocAction {

		public String execute(){
			System.out.println("doc action");
			return "success";
		}
}
