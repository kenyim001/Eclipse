package �κ�day06;

import java.io.File;

public class test4 {
		public static void main(String[] args) {
			File dir=new File(".");
			File [] subs=dir.listFiles();
			for(File a:subs){
				if(a.isFile()){
					System.out.println("�ļ�");
				}else{
					System.out.println("Ŀ¼");
				}System.out.println(a.getName());
			}
		}
}
