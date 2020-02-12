package com.rxg.javastudy;

public class TestRemoveDebug {

    public static void main(String[] args) throws Exception {
        int a = 1;
        int b = 2;
        int c = a + b;
        while(true) {
	        c= c*4;
	        System.out.println("===:"+c);
	        Thread.sleep(2000);
        }
    }
}
