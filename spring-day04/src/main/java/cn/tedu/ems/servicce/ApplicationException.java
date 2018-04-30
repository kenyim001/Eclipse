package cn.tedu.ems.servicce;
/**
 * 
 * 自定义异常类
 * @author kenyim
 *
 */


public class ApplicationException extends RuntimeException {

	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}

}
