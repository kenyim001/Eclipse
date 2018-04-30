package 课后day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class test4 {
	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("物理",99);
		map.put("语文",98);
		map.put("数学",97);
		map.put("化学",96);
		map.put("英语",95);
		
		
		System.out.println(map.get("物理"));
		
		Set<String> keya=map.keySet();
			for(String ke1y:keya){
				System.out.println(ke1y);
			}
			map.put("化学", 99);
			map.remove("英语");
			
		Set<Entry<String,Integer>> abc=map.entrySet();
		for(Entry<String,Integer> entry :abc)
		System.out.println(entry);
		
		Collection<Integer> ced=map.values();
		for(Integer values:ced){
			System.out.println(values);
		}
		
	}
}
