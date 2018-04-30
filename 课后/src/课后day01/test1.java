package ¿Îºóday01;

import java.util.Random;

public class test1 {
	public static void main(String[] args) {
		String str="HelloWorld";
		Random a=new Random(33);
		for (int i = 0; i < 10; i++) {
            System.out.print(a.nextInt(10) + " ");
        }
		test1(str);
		test2(str);
		test3(str);
		
		test4(str);
		
		test5(str);
		String str2="  Hello   ";
		test6(str2);
		test7(str);
		test8(str);
		test9(str);
	}

	
public static void test1(String str){
	System.out.println(str.length());
 }
public static void test2(String str){
	System.out.println(str.indexOf('o'));
}

public static void test3(String str){
	System.out.println(str.indexOf(5,'o'));
}


public static void test4(String str){
	System.out.println(str.substring(0, 5));
}

public static void test5(String str){
	System.out.println(str.substring(5, 10));
}

public static void test6(String str){
	System.out.println(str.trim());
}

public static void test7(String str){
	System.out.println(str.charAt(5));
}

public static void test8(String str){
	System.out.println(str.startsWith("h")&&str.endsWith("ld"));
}

public static void test9(String str){
	System.out.println(str.toUpperCase());
	System.out.println(str.toLowerCase());
}



}
