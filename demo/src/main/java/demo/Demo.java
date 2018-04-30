package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Scanner in=new Scanner(System.in);
		System.out.println("输入类名");
		String className=in.nextLine();
		//动态(运行期间)加载类到内存中
		Class cls=Class.forName(className);
		System.out.println(cls);
		System.out.println(cls.getName());
		
		//动态创建对象
		Object obj=cls.newInstance();
		System.out.println(obj);
		
		
		//动态获取类中声明的方法信息
		cls.getDeclaredMethods();
		System.out.println(obj);
		
		//动态获取声明的方法
		Method[] methods=cls.getDeclaredMethods();
		for(Method method:methods){
			System.out.println(method);
		}
	}
}
