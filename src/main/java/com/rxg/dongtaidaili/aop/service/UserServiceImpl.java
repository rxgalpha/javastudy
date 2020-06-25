package com.rxg.dongtaidaili.aop.service;

import com.rxg.dongtaidaili.aop.anotation.MyTransactional;

@MyTransactional
public class UserServiceImpl implements UserService {
	@Override
	public void getUser() {
		System.out.println("service执行...");
	}
}



