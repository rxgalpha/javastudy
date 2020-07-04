package com.rxg.zhixingshunxu;

public class Parent {
    static Food food = new Food("父类");
    static {
        System.out.println("父类静态代码块");
    }

    Parent(){
        System.out.println("父类构造");
    }
}
