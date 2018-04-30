package cn.tedu.ssh1.action;

public class MseeageAction {
	private String message;
	public String getMessage(){
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute(){
		message="ok";
		return "success";
	}
}
