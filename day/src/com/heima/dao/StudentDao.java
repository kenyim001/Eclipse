package com.heima.dao;

import javax.print.Doc;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.heima.bean.Student;
import com.heima.util.JaxpUtils;

public class StudentDao {

	public boolean add(Student student){
		Document document=JaxpUtils.getDocument();
		Element root=document.getDocumentElement();
		Element stu=document.createElement("student");
		Element nameE1=document.createElement("name");
		Element locationE1=document.createElement("location");
		Element gradeE1=document.createElement("grade");
		
		stu.setAttribute("examid",student.getExamid());
		stu.setAttribute("idcard", student.getIdcard());
		
		nameE1.setTextContent(student.getName());
		locationE1.setTextContent(student.getLocation());
		gradeE1.setTextContent(student.getGrade()+"");
		
		stu.appendChild(nameE1);
		stu.appendChild(locationE1);
		stu.appendChild(gradeE1);
		
		root.appendChild(stu);
		
		JaxpUtils.write2xml(document);
		return true;
		  
		
	}
	public boolean delete(String name){
		
		Document document=JaxpUtils.getDocument();
		
		NodeList n1=document.getElementsByTagName("name");
		
		for (int i = 0; i < n1.getLength(); i++) {
			
			Node n=n1.item(i);
			if(n.getTextContent().equals(name)){
				n.getParentNode().getParentNode().removeChild(n.getParentNode());
				JaxpUtils.write2xml(document);
				
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public Student findByExamId(String examid) {
		
	Document document=JaxpUtils.getDocument();
	
	NodeList n1=document.getElementsByTagName("student");
	
	for (int i = 0; i < n1.getLength(); i++) {
		Element stuNode =(Element) n1.item(i);
		
		if(stuNode.getAttribute("examid").equals(examid)){
			Student s=new Student();
			s.setExamid(examid);
			s.setIdcard(stuNode.getAttribute("idcard"));
			s.setName(stuNode.getElementsByTagName("name").item(0).getTextContent());
			s.setLocation(stuNode.getElementsByTagName("location").item(0).getTextContent());
			s.setGrade(Float.parseFloat(stuNode.getElementsByTagName("grade").item(0).getTextContent()));
			
			return s;
		}
	}
		
		return null;
	}
}
