package 课后day06;

import java.io.File;
import java.util.Scanner;

public class test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个要删除的文件或目录名:");
		String name = scanner.nextLine();
		File file = new File(name);
		if(!file.exists()){
			System.out.println("该文件或目录不存在!");
			return;
		}deleteFile(file);
		System.out.println("删除完毕!");
	}


public static void deleteFile(File file){
	if(file.isDirectory()){
		for(File sub : file.listFiles()){
			//递归删除
			deleteFile(sub);
		}
	}
	file.delete();
}
}