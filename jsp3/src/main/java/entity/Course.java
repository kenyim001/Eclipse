package entity;

import java.io.Serializable;

public class Course implements Serializable {
	//��������
		private Integer courseId;
		private String name;
		private Integer days;
		
		//Bean����
		//1.ȥ��get/setʣ�µĵ��ʣ�����ĸСд
		//2.ͨ��get/set��������������������
		
		public Integer getCourseId() {
			return courseId;
		}
		public void setCourseId(Integer courseId) {
			this.courseId = courseId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getDays() {
			return days;
		}
		public void setDays(Integer days) {
			this.days = days;
		}
		
}
