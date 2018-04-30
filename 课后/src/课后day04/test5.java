package 课后day04;
/**
 * 创建一个List集合，并添加元素0-9
 * 将集合转换为一个Integer数组并输出数组每一个元素
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
