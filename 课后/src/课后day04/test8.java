package 课后day04;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 通过控制台输入3个日期(yyyy-MM-dd格式)，然后转换
 * 为Date对象后存入
 * 集合，然后对该集合排序后输出所有日期。
 * @author Xiloer
 *
 */

public class test8 {
		public static void main(String[] args) throws ParseException {
			String a="2017-05-13";
			String b="2017-05-03";
			String c="2017-05-23";
			String [] e={a,b,c};
			for (int i = 0; i <3; i++) {
				System.out.println(e[i]);
			}
			
			SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
			List<Date> ls=new ArrayList<Date>();
			for (int i = 0; i < 3; i++) {
				Date date=d.parse(e[i]);
				ls.add(date);
			}
			System.out.println(ls);
			Collections.sort(ls);
			System.out.println(ls);
			
		}
 }
