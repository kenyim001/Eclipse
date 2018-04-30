package �κ�day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class test4 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ����������:");
		String dateStr = scanner.nextLine();

		System.out.println("������һ������������:");
		int days = Integer.parseInt(scanner.nextLine());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//����������ת��ΪDate
		Date date = sdf.parse(dateStr);
		
		//����Calendar����ʱ��
		Calendar calendar = Calendar.getInstance();
		//��ʾ��������
		calendar.setTime(date);
		//���������
		calendar.add(Calendar.DAY_OF_YEAR, days);
		//�������������ǰ
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		//����Ϊ��������
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		//ת��ΪDate
		date = calendar.getTime();
		//�����������
		System.out.println("��������:"+sdf.format(date));
		
	}
}
