package 课后day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 例如:
* 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
* 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
* 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
* 然后输出每个员工的转正仪式日期。
* 转正仪式日期为:入职3个月的当周周五
* 
* @author Xiloer
*
*/
public class test9 {
		public static void main(String[] args) throws ParseException {
			String a= "张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24";
			String [] arr=a.split(";");
			List<Emp> ls=new ArrayList<Emp>();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			for(String data:arr){
				String[] empInfo=data.split(",");
				String name=empInfo[0];
				 int age=Integer.parseInt(empInfo[1]);
				 String gender=empInfo[2];
				int sal=Integer.parseInt(empInfo[3]);
				Date hiredate=sdf.parse(empInfo[4]);
				Emp e=new Emp( name, age, gender, sal,hiredate);
				ls.add(e);
			}
			for(Emp e:ls){
			System.out.println(e);
		}
		for(Emp e : ls){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(e.getHiredate());
			calendar.add(calendar.MONTH, 3);
			calendar.set(Calendar.DAY_OF_WEEK, calendar.FRIDAY);
			System.out.println(e.getName()+sdf.format(calendar.getTime()));
		}
  }
}
	
	
	
