package �κ�day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ����һ��List���ϣ������10���������Ȼ������ü���
 * �����
 * @author Xiloer
 *
 */
public class test7 {
		public static void main(String[] args) {
			List<Integer> ls=new ArrayList<Integer>();
			for (int i = 0; i <=10; i++) {
				ls.add((int) (Math.random()*100));
			}
			System.out.println(ls);
			Collections.sort(ls);
			System.out.println(ls);
		}
}
