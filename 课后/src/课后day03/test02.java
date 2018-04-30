package ¿Îºóday03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test02 {
	public static void main(String[] args) {
		Date date=new Date();
		SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sft.format(date);
		System.out.println(str);
	}
}
