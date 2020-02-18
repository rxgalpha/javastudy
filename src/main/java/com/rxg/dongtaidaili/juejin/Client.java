package com.rxg.dongtaidaili.juejin;

import java.lang.reflect.Proxy;

import com.rxg.dongtaidaili.Calculator;
import com.rxg.dongtaidaili.CalculatorImpl;

public class Client {

	public static void main(String[] args) {
		Calculator calc = new CalculatorImpl();
		Calculator proxy = (Calculator)Proxy.newProxyInstance(calc.getClass().getClassLoader(), calc.getClass().getInterfaces(),
				new LogHandler(calc));
		proxy.add(1, 2);
		proxy.subtract(3, 1);
	}
}
