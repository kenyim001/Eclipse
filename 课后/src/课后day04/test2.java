package �κ�day04;
/**
 * ����һ�����ϣ����Ԫ��"1","$","2","$","3","$","4"
 *   ʹ�õ������������ϣ����ڹ�����ɾ�����е�"$"��
 *   ����ٽ�ɾ��Ԫ�غ�ļ���ʹ����ѭ�������������ÿһ��Ԫ�ء�
 * @author Xiloer
 *
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class test2 {
		public static void main(String[] args) {
			Collection<String> c1=new ArrayList<String>();
			c1.add("1");
			c1.add("$");
			c1.add("2");
			c1.add("$");
			c1.add("3");
			c1.add("$");
			c1.add("4");
				Iterator<String> is=c1.iterator();
				while(is.hasNext()){
					String str=is.next();
					if("$".equals(str)){
						is.remove();
					}
				}
				for(String str:c1){
					System.out.println(str);
				}
			}
			
		}

