package �κ�day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class test4 {
	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("����",99);
		map.put("����",98);
		map.put("��ѧ",97);
		map.put("��ѧ",96);
		map.put("Ӣ��",95);
		
		
		System.out.println(map.get("����"));
		
		Set<String> keya=map.keySet();
			for(String ke1y:keya){
				System.out.println(ke1y);
			}
			map.put("��ѧ", 99);
			map.remove("Ӣ��");
			
		Set<Entry<String,Integer>> abc=map.entrySet();
		for(Entry<String,Integer> entry :abc)
		System.out.println(entry);
		
		Collection<Integer> ced=map.values();
		for(Integer values:ced){
			System.out.println(values);
		}
		
	}
}
