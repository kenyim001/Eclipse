package �κ�day04;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * ͨ������̨����3������(yyyy-MM-dd��ʽ)��Ȼ��ת��
 * ΪDate��������
 * ���ϣ�Ȼ��Ըü������������������ڡ�
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
