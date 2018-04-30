package 课后day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test6 {
		public static void main(String[] args) throws ParseException {
			String rex="\\d{17}[\\dXx]";
			String a="";
			do{
			System.out.println("身份证");
			Scanner sc=new Scanner(System.in);
			a=sc.nextLine();
			}while(!a.matches(rex));
		
		String b=a.substring(6, 14);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		date=sdf.parse(b);
		
		
		
		}
}
