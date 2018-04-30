package 课后day06;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {
	public static void main(String[] args) throws ParseException {
		File file=new File("myfile.txt");
		String name=file.getName();
		System.out.println("名字:"+name);
		
		long length=file.length();
		System.out.println(" 大小:"+length+"字节");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		long lastModified =file.lastModified();
		String a=sdf.format(new Date(lastModified));
	System.out.println("最后修改间"+new Date(lastModified ));
		System.out.println(sdf.format(new Date(lastModified )));
		Date date= sdf.parse("19840923");
		System.out.println(date);
	}
}
