package �κ�day04;
/* ����һ��List����(ArrayList,LinkedList����)
* ���Ԫ��"one","two","three","four"��
* ��ȡ���ϵڶ���Ԫ�ز������
* �����ϵ�����Ԫ������Ϊ"3"
* �ڼ��ϵڶ���λ���ϲ���Ԫ��"2"
* ɾ�����ϵ�����Ԫ�ء�
* @author Xiloer
*/
import java.util.LinkedList;
import java.util.List;

public class test3 {
		public static void main(String[] args) {
			List<String> list=new LinkedList<String>();
			list.add("one");
			list.add("two");
			list.add("three");
			list.add("four");
			System.out.println("list:"+list);
			String e=list.get(1);
			System.out.println(e);
			list.set(2, "3");
			System.out.println(list);
			list.add(1, "2");
			System.out.println(list);
			list.remove(2);
			System.out.println(list);
			
			
		} 
}
