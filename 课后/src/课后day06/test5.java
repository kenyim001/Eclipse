package �κ�day06;

import java.io.File;
import java.util.Scanner;

public class test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ��Ҫɾ�����ļ���Ŀ¼��:");
		String name = scanner.nextLine();
		File file = new File(name);
		if(!file.exists()){
			System.out.println("���ļ���Ŀ¼������!");
			return;
		}deleteFile(file);
		System.out.println("ɾ�����!");
	}


public static void deleteFile(File file){
	if(file.isDirectory()){
		for(File sub : file.listFiles()){
			//�ݹ�ɾ��
			deleteFile(sub);
		}
	}
	file.delete();
}
}