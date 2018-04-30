package cn.tedu.hotel.common.web;

/**统一返回JSON的结果格式*/
public class JsonResult {
	public static final int SUCCESS=1;
	public static final int ERROR=0;
	private int state;
	private String message;
	private Object data;
	
	public JsonResult() {
		this.state=SUCCESS;
		this.message="ok";
	}
	
	public JsonResult(Object data) {
		this();
		this.data=data;
	}
	
	public JsonResult(Throwable e) {
		this.state=ERROR;
		this.message=e.getMessage();
	}
	
	public int getState() {
		return state;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
}
