package 课后day06;

import java.beans.IndexedPropertyChangeEvent;
import java.io.File;
import java.util.Scanner;

public class test3 {
		public static void main(String[] args) {
			System.out.println("请输入");
			Scanner sc=new Scanner(System.in);
			String dirName=sc.nextLine();
			File dir=new File(dirName);
			if(!dir.exists()){
				dir.mkdir();
			}else{
				 int Index=1;
				 while(true){
					 String name=dirName+"_副本"+Index;
					 System.out.println(name);
					 dir=new File(name);
					 if(!dir.exists()){
						 dir.mkdir();
						 break;
					 }Index++;
				 }
			}
			System.out.println("创建完成");
		}
}
