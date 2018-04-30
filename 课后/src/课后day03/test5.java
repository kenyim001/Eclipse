package 课后day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test5{
	public static void main(String[] args) throws ParseException {
		String rex="\\d{17}[dXx]";
		String a="";
		do{
		System.out.println("身份证");
		Scanner sc=new Scanner(System.in);
		 a=sc.nextLine();
		}while(a.matches(rex));
		String bir=a.substring(6,14);
		System.out.println(bir);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new  Date();
		date=sdf.parse(bir);
		System.out.println(date);
		Calendar cl=Calendar.getInstance();
		cl.setTime(date);
		System.out.println(sdf1.format(date));
		cl.add(Calendar.YEAR, 20);
		date=cl.getTime();
		System.out.println(sdf1.format(date));
		cl.add(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
		date=cl.getTime();
		System.out.println(sdf1.format(date));
	}
	}
