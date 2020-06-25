package com.rxg.dongtaidaili;

/**
 * 目标对象实现类，实现Calculator接口
 */
public class CalculatorImpl implements Calculator {

	//加
	@Override
	public int add(int a, int b) {
		int result = a + b;
		return result;
	}

	//减
	@Override
	public int subtract(int a, int b) {
		int result = a - b;
		return result;
	}

	//乘法、除法...
}
