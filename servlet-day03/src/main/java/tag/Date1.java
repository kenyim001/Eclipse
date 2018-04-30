package tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Date1 extends SimpleTagSupport{
	private String pattern;
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		System.out.println("Pattern()");
		this.pattern = pattern;
	}
	
	public void doTag() throws JspException, IOException {
		PageContext pctx=(PageContext)getJspContext();
		JspWriter out=pctx.getOut();
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	out.print(sdf.format(date));
	}
}
