package com.heima.ui;

import java.util.Scanner;

import com.heima.bean.Student;
import com.heima.dao.StudentDao;

public class StudentUI{

	static Scanner scan=new Scanner(System.in);
	static StudentDao dao=new StudentDao();
	
	public static void main(String[] args) {
		System.out.println("��ѡ������� a)�����û�  b)��ѯѧ��  c)ɾ��ѧ��");
	
	String op=scan.next();
	
	
	if ("a".equalsIgnoreCase(op)) {
		addStudent();
	}else if("b".equalsIgnoreCase(op)){
		findStudentByExamId();
	}else if("c".equalsIgnoreCase(op)){
		removeStudentByname();
	}else if("c".equalsIgnoreCase(op)){
		System.out.println("û�д��ֲ���");
	}
	}
	private static void removeStudentByname() {
		System.out.println("������ѧ��������");
		String name=scan.next();
		boolean flag=dao.delete(name);
		if(flag)
			System.out.println("--------ɾ���ɹ�--------");
		else
			System.out.println("--------ɾ�� ���ɹ�--------");

	}

	private static void findStudentByExamId() {
		System.out.println("����׼��֤��");
		String examid=scan.next();
		Student stu=dao.findByExamId(examid);
		
		if(stu !=null)
			System.out.println(stu);
		else
			System.out.println("��ѧ��������");
	}

	private static void addStudent() {
		Student s=new Student();
		System.out.println("���������� ");
		String name=scan.next();
		s.setName(name);
		
		System.out.println("����������֤��");
		String idcard=scan.next();
		s.setIdcard(idcard);
		
		System.out.println("������׼��֤��");
		String examid=scan.next();
		s.setExamid(examid);
		
		System.out.println("�������ַ ");
		String location=scan.next();
		s.setLocation(location);
		
		System.out.println("��������� ");
		String grade=scan.next();
		s.setGrade(Float.parseFloat(grade));
		
		boolean flag=dao.add(s);
		
		if(flag)
			System.out.println("------���ӳɹ�--------");
		else
			System.out.println("------���Ӳ��ɹ�-------");
	}
}