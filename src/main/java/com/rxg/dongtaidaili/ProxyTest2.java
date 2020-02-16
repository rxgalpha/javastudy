package com.rxg.dongtaidaili;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2 {
	public static void main(String[] args) throws Exception {
		/*
		 * 参数1：Calculator的类加载器（当初把Calculator加载进内存的类加载器）
		 * 参数2：代理对象需要和目标对象实现相同接口Calculator
		 * */
		Class calculatorProxyClazz = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
		//以Calculator实现类的Class对象作对比，看看代理Class是什么类型
		System.out.println(CalculatorImpl.class.getName());
		System.out.println(calculatorProxyClazz.getName());
		//打印代理Class对象的构造器
		Constructor[] constructors = calculatorProxyClazz.getConstructors();
		System.out.println("----构造器----");
		printClassInfo(constructors);
		//打印代理Class对象的方法
		Method[] methods = calculatorProxyClazz.getMethods();
		System.out.println("----方法----");
		printClassInfo(methods);

		Constructor constructor = calculatorProxyClazz.getConstructor(InvocationHandler.class);
		Calculator calculatorProxyImp = (Calculator) constructor.newInstance(new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return null;
			}
		});
		System.out.println(calculatorProxyImp.add(1, 2));
		System.out.println(calculatorProxyImp.subtract(3, 1));
	}

	public static void printClassInfo(Executable[] targets) {
		for (Executable target : targets) {
			// 构造器/方法名称
			String name = target.getName();
			StringBuilder sBuilder = new StringBuilder(name);
			// 拼接左括号
			sBuilder.append('(');
			Class[] clazzParams = target.getParameterTypes();
			// 拼接参数
			for (Class clazzParam : clazzParams) {
				sBuilder.append(clazzParam.getName()).append(',');
			}
			//删除最后一个参数的逗号
			if (clazzParams != null && clazzParams.length != 0) {
				sBuilder.deleteCharAt(sBuilder.length() - 1);
			}
			//拼接右括号
			sBuilder.append(')');
			//打印 构造器/方法
			System.out.println(sBuilder.toString());
		}
	}
}