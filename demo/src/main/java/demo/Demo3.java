package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(System.in);
		System.out.println("class:");
		String className=in.nextLine();
		Class cls=Class.forName(className);
		Object obj=cls.newInstance();
		//动态查找全部的方法
		Method[] methods=cls.getDeclaredMethods();
		//检查每个方法，是否包含指定的注解
		for(Method method:methods){
			//查找method上是否包含TEST注解
			Object ann=method.getAnnotation(Test.class);
			//如果ann不是null,则说明 包含Test注解
			if(ann!=null){
				//执行找到的方法
				method.invoke(obj);
			}
		}
	}
}
