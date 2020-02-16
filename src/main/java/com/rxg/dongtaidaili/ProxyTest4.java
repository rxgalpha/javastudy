package com.rxg.dongtaidaili;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Advice {
	void beforeMethod(Method method);
	void afterMethod(Method method);
}

class MyLogger implements Advice {

	@Override
	public void beforeMethod(Method method) {
		System.out.println(method.getName() + "方法执行开始...");
	}

	@Override
	public void afterMethod(Method method) {
		System.out.println(method.getName() + "方法执行结束...");
	}
}

public class ProxyTest4 {
	public static void main(String[] args) throws Throwable {
		CalculatorImpl target = new CalculatorImpl();
		Calculator calculatorProxy = (Calculator) getProxy(target, new MyLogger());
		calculatorProxy.add(1, 2);
		calculatorProxy.subtract(2, 1);
	}

	private static Object getProxy(final Object target, Advice logger) throws Exception {
		/*代理对象的方法最终都会被JVM导向它的invoke方法*/
		Object proxy = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),/*类加载器*/
				target.getClass().getInterfaces(),/*让代理对象和目标对象实现相同接口*/
				(proxy1, method, args) -> {
					logger.beforeMethod(method);
					Object result = method.invoke(target, args);
					System.out.println(result);
					logger.afterMethod(method);
					return result;
				}
		);
		return proxy;
	}
}
