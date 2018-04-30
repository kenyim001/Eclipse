package 课后day04;
/**
 * 创建一个集合，存放元素"1","$","2","$","3","$","4"
 *   使用迭代器遍历集合，并在过程中删除所有的"$"，
 *   最后再将删除元素后的集合使用新循环遍历，并输出每一个元素。
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

