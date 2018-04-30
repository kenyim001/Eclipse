package �κ�day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* ����:
* ����,25,��,5000,2006-02-15;����,26,Ů,6000,2007-12-24;...
* Ȼ��ÿ��Ա����Ϣ������Emp���󡣲����뵽һ�������С�
* Ȼ��ѭ�����ϣ����ÿһ��Ա����Ϣ(���ʹ��toString���ص��ַ���)
* Ȼ�����ÿ��Ա����ת����ʽ���ڡ�
* ת����ʽ����Ϊ:��ְ3���µĵ�������
* 
* @author Xiloer
*
*/
public class test9 {
		public static void main(String[] args) throws ParseException {
			String a= "����,25,��,5000,2006-02-15;����,26,Ů,6000,2007-12-24";
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
	
	
	
