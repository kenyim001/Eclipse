package cn.tedu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class TimingAspect {
	
	@Before("bean(sysRoleServiceImpl)")
	public void timeBefore(){
		long start=System.currentTimeMillis();
		System.out.println("start="+start);
	}
	
	@AfterReturning("bean(sysRoleServiceImpl)")
	public void returnMethod(){
		System.out.println("returnMethod正常");
	}
	
	@AfterThrowing("bean(sysRoleServiceImpl)")
	public void throwMethod(){
		System.out.println("出问题了");
	}
	
	//@Around
	
	@After("bean(sysRoleServiceImpl)")
	public void timeafter(){
		long end=System.currentTimeMillis();
		System.out.println("start="+end);
	}
}
