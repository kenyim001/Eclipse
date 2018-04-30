package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDao implements Serializable {
		
		public List<Emp> findAll(){
			//ģ���ѯ���е�Ա��
			List<Emp> list =new ArrayList<Emp>();
			Emp e1=new Emp();
			e1.setEmpno(1);
			e1.setEname("��ɮ");
			e1.setJob("�쵼");
			e1.setSal(9000.0);
			list.add(e1);
			
			Emp e2=new Emp();
			e2.setEmpno(2);
			e2.setEname("���");
			e2.setJob("�곤");
			e2.setSal(5000.0);
			list.add(e2);
			
			Emp e3=new Emp();
			e3.setEmpno(3);
			e3.setEname("����");
			e3.setJob("ְԱ");
			e3.setSal(6000.0);
			list.add(e3);
			
			return list;
		}

		public void save(Emp e) {
			System.out.println("����Ա��"+e.getEname());
			
		}
}