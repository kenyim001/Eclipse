package �κ�day04;

import java.util.ArrayList;
import java.util.List;
/**
 * ����һ��List���ϲ����Ԫ��0-9
 * Ȼ���ȡ�Ӽ�[3,4,5,6]
 * Ȼ���Ӽ�Ԫ������10��
 * Ȼ�����ԭ���ϡ�
 * ֮��ɾ�������е�[7,8,9]
 * @author Xiloer
 *
 */

public class test4 {
	public static void main(String[] args) {
		List<Integer> a=new ArrayList<Integer>();
		for (int i = 0; i <=9; i++) {
			a.add(i);
		}
		System.out.println(a);
		List<Integer> sub =a.subList(3, 7);
		System.out.println(sub );
		for (int i = 0; i <sub.size(); i++) {
			sub.set(i, sub.get(i)*10);
		}
			System.out.println(a);
			a.subList(7, 10).clear();
			System.out.println(a);
	}
}
