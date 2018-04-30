package cn.tedu.dongtai.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler{
	private Object target;
	
	public Object newProxy(Object target){
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader() , target.getClass().getInterfaces(), this);
	}
	
	
	public Object invoke(Object proxy, Method method, Object[] arg2) throws Throwable {
		long t1=System.currentTimeMillis();
		System.out.println(t1);
		Object result=method.invoke(target, arg2);
		long t2=System.currentTimeMillis();
		System.out.println(method.getName()+":"+(t2-t1));		
		return result;
	}

}
