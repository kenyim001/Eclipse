package �κ�day06;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test2 {
		public static void main(String[] args) throws IOException {
			Scanner sc=new Scanner(System.in);
			System.out.println("������Ҫ�������ļ�������:");
			String fileName=sc.nextLine();
			File file=new File(fileName);
			if(!file.exists()){
				file.createNewFile();
				
			}else{int index=1;
			
			String name = fileName.substring(0, fileName.indexOf("."));
			String postfix = fileName.substring(fileName.indexOf(".")+1);
			while(true){
				fileName=name+"����"+index+"."+postfix;
				System.out.println(fileName);
				file = new File(fileName);
				if(!file.exists()){
					file.createNewFile();
					break;
				}
				index++;
			}
			}
			System.out.println("�ļ��������!");
		}
}
