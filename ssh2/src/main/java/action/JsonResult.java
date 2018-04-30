package action;

public class JsonResult {
	public static final int SUCCESS=1;
	public static final int ERROR=0;
	
	private int state;
	private String message;
	private Object data;
	

	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public JsonResult(){

	}
	public JsonResult(Object data){
		state=SUCCESS;
		this.data=data;
	}
	
	public JsonResult(Throwable e){
		state=ERROR;
	}
}
