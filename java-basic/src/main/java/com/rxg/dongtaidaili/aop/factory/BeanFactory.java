package com.rxg.dongtaidaili.aop.factory;

import com.rxg.dongtaidaili.aop.anotation.MyTransactional;
import com.rxg.dongtaidaili.aop.utils.ConnectionUtils;
import com.rxg.dongtaidaili.aop.utils.TransactionManager;

public class BeanFactory {

	public Object getBean(String name) throws Exception {
		//得到目标类的Class对象
		Class<?> clazz = Class.forName(name);
		//得到目标对象
		Object bean = clazz.newInstance();
		//得到目标类上的@MyTransactional注解
		MyTransactional myTransactional = clazz.getAnnotation(MyTransactional.class);
		//如果打了@MyTransactional注解，返回代理对象，否则返回目标对象
		if (null != myTransactional) {
			ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
			TransactionManager txManager = new TransactionManager();
			txManager.setConnectionUtils(new ConnectionUtils());
			//装配通知和目标对象
			proxyFactoryBean.setTxManager(txManager);
			proxyFactoryBean.setTarget(bean);
			Object proxyBean = proxyFactoryBean.getProxy();
			//返回代理对象
			return proxyBean;
		}
		//返回目标对象
		return bean;
	}
}
