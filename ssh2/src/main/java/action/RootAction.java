package action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RootAction {

	private String name;
	private JsonResult result;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JsonResult getResult() {
		return result;
	}
	public void setResult(JsonResult result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "RootAction [name=" + name + ", result=" + result + "]";
	}
	
	public String execute(){
		name="Tom";
		
		result=new JsonResult("Hello world");
		return "success";
	}
	
}
