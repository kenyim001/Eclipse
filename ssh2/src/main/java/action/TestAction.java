package action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class TestAction {
	public String execute(){
		System.out.println("test action");
		return "success";
	}
}
