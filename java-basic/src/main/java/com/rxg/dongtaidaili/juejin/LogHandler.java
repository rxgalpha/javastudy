package com.rxg.dongtaidaili.juejin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{

	Object target;
	public LogHandler(Object target) {
		this.target = target;
	}
	public void before(){
		System.out.println("执行before");
	}
	public void after(){
		System.out.println("执行after");
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(target, args);
		System.out.println(method.getName());
		after();
		return result;
	}
}
