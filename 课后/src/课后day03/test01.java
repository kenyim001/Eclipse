package ¿Îºóday03;

import java.util.Date;

public class test01 {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		long time=date.getTime();
		time +=3L*24*60*60*1000;
		date.setTime(time);
		System.out.println(date);
	}
}
