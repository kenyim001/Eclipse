package �κ�day06;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {
	public static void main(String[] args) throws ParseException {
		File file=new File("myfile.txt");
		String name=file.getName();
		System.out.println("����:"+name);
		
		long length=file.length();
		System.out.println(" ��С:"+length+"�ֽ�");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		long lastModified =file.lastModified();
		String a=sdf.format(new Date(lastModified));
	System.out.println("����޸ļ�"+new Date(lastModified ));
		System.out.println(sdf.format(new Date(lastModified )));
		Date date= sdf.parse("19840923");
		System.out.println(date);
	}
}
