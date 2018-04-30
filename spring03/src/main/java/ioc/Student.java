package ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component	
@Scope
@Lazy(true)

public class Student {
		public Student(){
			System.out.println("Student()");
		}
		@PostConstruct
		public void init(){
			System.out.println("init()");
		}
		@PreDestroy
		public void destroy(){
			System.out.println("destroy()");
		}
		
}
