package ¿Îºóday05;

import java.util.Deque;
import java.util.LinkedList;

public class test2 {
	public static void main(String[] args) {
		Deque<Integer> de=new LinkedList<Integer>();
		de.push(1);
		de.push(2);
		de.push(3);
		de.push(4);
		de.push(5);
		while (de.size()>0) {
			System.out.println(de.pop());
			
		}
		System.out.println(de);
		
	}
}
