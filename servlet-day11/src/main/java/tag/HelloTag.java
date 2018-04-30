package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	private int qty;
	private String msg;
	
	public HelloTag(){
		System.out.println("HelloTag()");
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		System.out.println("setQty()"+qty);
		this.qty = qty;
	}

	public String getMsg() {
	
		return msg;
	}

	public void setMsg(String msg) {
		System.out.println("setMsg()"+msg);
		this.msg = msg;
	}

	public void doTag() throws JspException, IOException {
		System.out.println( "doTag();");
		
		//ͨ���̳���SImpleTagSupport�ṩ�ķ���
		//�����pageContext
		PageContext pctx=(PageContext)getJspContext();
		//PageContext �ṩ�˻������������������ķ���
		JspWriter out=pctx.getOut();
		for(int i=0;i<qty;i++){
			out.print(msg+"<br/>");
		}
	}

}
