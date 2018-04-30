package ¿Îºóday06;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class test6 {
	public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();
		for(int i= 0;set.size() < 6;i++) {
			Random a=new Random();
			int b=a.nextInt(32)+1 ;
			set.add(b);
		}
		for(int b:set)
		System.out.println(b);
	}
	
}
