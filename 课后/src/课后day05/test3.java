package 课后day05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.w3c.dom.ls.LSInput;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
 * 并对集合排序，然后输出每个员工信息。
 * 
 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
 * 输出每个员工的信息。
 * 
 * @author Xiloer
 *
 */

public class test3 {
		public static void main(String[] args) throws ParseException {
			String a="张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;张四,25,男,5000,2006-02-16;李六,26,女,6000,2007-12-21;";
			String [] b=a.split(";");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			List<Emp> emp=new ArrayList<Emp>();
			for (int i = 0; i < b.length; i++) {
				String [] c=b[i].split(",");
				String name=c[0];
				int age=Integer.parseInt(c[1]);
				String gender=c[2];
				int sal=Integer.parseInt(c[3]);
				Date hiredate=sdf.parse(c[4]);
				Emp e=new Emp(name,age,gender,sal,hiredate);
				emp.add(e);
			}
			for ( Emp e:emp) {
				System.out.println(e);
			}
			
			for(Emp e:emp){
			Calendar cal=Calendar.getInstance();
			cal.setTime(e.getHiredate());
			cal.add(Calendar.MONTH, 3);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			String f=sdf.format(cal.getTime());
			System.out.println(e.getName()+f);
			
			}
			//按照入职时间排序
		
			System.out.println("按照入职时间从晚到早排序:");
			Comparator<Emp> com = new Comparator<Emp>(){
				public int compare(Emp e1, Emp e2) {
					System.out.println(e1.getHiredate().getTime()-e2.getHiredate().getTime());
					long time = e2.getHiredate().getTime()-e1.getHiredate().getTime();
					return time>0?1:-1;
				}			
			};
			Collections.sort(emp,com);
			for(Emp e : emp){
				System.out.println(e);
			}
			
	}
}
