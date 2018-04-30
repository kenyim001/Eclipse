package ¿Îºóday02;

import java.util.Scanner;

public class test8 {
public static void main(String[] args) {
	System.out.println("111");
	Scanner sc=new Scanner(System.in);
	String a=sc.nextLine();
	String[] arr=a.split(";");
	Person[] arr1=new Person[arr.length];
	for (int i = 0; i < arr1.length; i++) {
		String[]  b=arr[i].split(",");
		String name=b[0];
		int age=Integer.parseInt(b[1]);
		String gender=b[2];
		int sal=Integer.parseInt(b[3]);
		Person p=new Person(name, age, gender, sal);
		arr1[i]=p;
	}
	for (int i = 0; i < arr1.length; i++) {
		System.out.println(arr1[i]);
	}
	
}
}
