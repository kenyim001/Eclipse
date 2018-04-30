package demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class demo2 {
		public static void main(String[] args) throws Exception{
			Scanner in=new Scanner(System.in);
			System.out.println("类名：");
			String clssName=in.nextLine();
			System.out.println("方法名:");
			String methodName=in.nextLine();
			
			//动态加载类
			Class cls=Class.forName(clssName);
			//动态创建对象 
			Object obj=cls.newInstance();
			//动态查找一个方法 
			Method method=cls.getDeclaredMethod(methodName,int.class);
			//打开方法访问限制
			method.setAccessible(true);
			
			//动态调用无参数方法 
			Object val=method.invoke(obj,8);
			
			//展示返回值 
			System.out.println(val);
		}
}
