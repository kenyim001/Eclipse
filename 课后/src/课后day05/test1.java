package ¿Îºóday05;


import java.util.LinkedList;
import java.util.Queue;

public class test1 {
		public static void main(String[] args) {
			Queue<Integer> qe=new LinkedList<Integer> ();
					qe.offer(1);
					qe.offer(2);
					qe.offer(3);
					qe.offer(4);
					qe.offer(5);
					System.out.println(qe.poll());
//					while(qe.size()>0){
//						System.out.println(qe.poll());
//					}
					System.out.println(qe);
		}
}
