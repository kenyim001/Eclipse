package �κ�day04;
/**
 * ����һ��List���ϣ������Ԫ��0-9
 * ������ת��Ϊһ��Integer���鲢�������ÿһ��Ԫ��
 * @author Xiloer *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class test5 {
		public static void main(String[] args) {
			List<Integer> ls=new ArrayList<Integer>();
			for (int i = 0; i <= 9; i++) {
				ls.add(i);
			}
			System.out.println(ls);
			Integer[] array = ls.toArray(new Integer[0]);
			for (int num:array) {
				System.out.print(num);
			}
			
			}
		
}
