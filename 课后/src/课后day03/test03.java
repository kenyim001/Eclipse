package ¿Îºóday03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test03 {
	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		date=sdf.parse(str);
		System.out.println(date);
		long t=date.getTime();
		System.out.println(t);
		long week=t/24l/60/60/1000/7;
		System.out.println(week);
	}
}
