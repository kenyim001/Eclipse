package 课后day06;

import java.io.File;

public class test4 {
		public static void main(String[] args) {
			File dir=new File(".");
			File [] subs=dir.listFiles();
			for(File a:subs){
				if(a.isFile()){
					System.out.println("文件");
				}else{
					System.out.println("目录");
				}System.out.println(a.getName());
			}
		}
}
