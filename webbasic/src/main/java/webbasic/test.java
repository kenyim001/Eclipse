package webbasic;

import java.util.Scanner;



public class test {
		public static void main(String args[] ) {
			System.out.println("你有几钱？");
			Scanner sc=new Scanner(System.in);
			int money=sc.nextInt();
			System.out.println("单价几钱？");
			sc=new Scanner(System.in);
			int price=sc.nextInt();
			System.out.println("几个瓶兑几个？");
			int bot=sc.nextInt();
			System.out.println("几个盖兑几个？");
			int li=sc.nextInt();
			int bottle=0;
			int lid=0;
			int total=0;
			
		
			int[] intArray = { money,price, bottle, lid, total ,li,bot};  
			lidmax0(intArray);
			chack(intArray);
			System.out.println(intArray[4]);
			} 
		
		/**合计*/
		public static int[] chack(int[] intArray){
			if(intArray[3]>=4){
				lidmax(intArray);
				chack(intArray);
			}else if(intArray[2]>=2){
				lidmax1(intArray);
				chack(intArray);
			}
			return intArray;
		}
		
		/**钱可以买几个*/
		public static   int[] lidmax0(int[] intArray){
			for (;  intArray[0]>0; intArray[0]-= intArray[1]) {
				lidmax5(intArray);
				System.out.println("lidmax0:"+intArray[4]);
			}
			return  intArray;
		 }
		/**计算盖子可以兑换几个*/
		public static   int[] lidmax(int[] intArray){
			System.out.println("lidmax:"+intArray[3]);
			intArray[3]-=intArray[5];
			lidmax5(intArray);
			System.out.println("lidmax:"+intArray[4]);
			return  intArray;
		 }
		
		public static   int[] lidmax1(int[] intArray){
			System.out.println("lidmax1:"+intArray[2]);
			intArray[2]-=intArray[6];
			lidmax5(intArray);
			System.out.println("lidmax1:"+intArray[4]);
			return  intArray;
		 }
		
		public static   int[] lidmax5(int[] intArray){
			intArray[2]++;
			intArray[4]++;
			intArray[3]++;
			return  intArray;
		 }
} 
