package �κ�day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * �������ַ���:
 * ����:����;����:����;����:����;����:����;����:mike;����:jerry;����:jackson;ǰ��:green;ǰ��:nick;����:Ǯ��;����:alice
 * ���������ַ���Ȼ��ͳ��ÿ��ְλ�ܹ�������?
 * ʹ��Map����ͳ�ƵĽ��������key:ְλ,valueΪ��ְλ����
 * Ȼ��ֱ������ְλ������(keySet),��ְλ����(entrySet)
 * @author Xiloer
 *
 */
public class test5 {
		public static void main(String[] args) {
			Map<String,Integer> map=new HashMap<String,Integer>();
			String a="����:����;����:����;����:����;"
					+ "����:����;����:mike;����:jerry;����"
					+ ":jackson;ǰ��:green;ǰ��:nick;����:"
					+ "Ǯ��;����:alice";
			String [] abc=a.split(";");
			for(String ab:abc){
				String [] info=ab.split(":");
				for (int i = 0; i < info.length; i++) {
					System.out.print(info[i]+"  ");
				}
				
				if(map.containsKey(info[0])){
					//��ְλ�Ѿ�ͳ�ƹ�
					map.put(info[0], map.get(info[0])+1);
					System.out.println();
				}
				else{
					map.put(info[0], 1);
					System.out.println("111"+map);
				}
			}
			System.out.println(map);
			Set<String> key=map.keySet();
			System.out.println(key);
			Set<Entry<String,Integer>> entrySet = map.entrySet();
			for(Entry<String,Integer> e : entrySet){
				System.out.println(e.getKey()+":"+e.getValue());
			}
			}
		}

