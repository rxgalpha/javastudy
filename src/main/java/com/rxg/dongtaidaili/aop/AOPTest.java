package com.rxg.dongtaidaili.aop;

import com.rxg.dongtaidaili.aop.factory.BeanFactory;

public class AOPTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();
		try {
			Object bean = beanFactory.getBean("com.rxg.dongtaidaili.aop.service.UserServiceImpl");
			System.out.println(bean.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
