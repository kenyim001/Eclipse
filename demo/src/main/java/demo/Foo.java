package demo;

public class Foo {
	public int add(int a,int b){
		return a+b;
	}
	public String where(){
		System.out.println("call who");
		return "谁";
	}
	public String test(){
		System.out.println("call test()");
		return "who";
	}
	
	private int add(int a){
		return a++;
	}
	
	private int test(int a){
		return a+1;
	}
}
