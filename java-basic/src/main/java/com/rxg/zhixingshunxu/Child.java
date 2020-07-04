package com.rxg.zhixingshunxu;

public class Child extends Parent{
    static Food fff = new Food("子类");

    static {
        System.out.println("子类静态代码块");
    }

    Child(){
        System.out.println("子类构造");
    }

    public static void main(String[] args) {
        new Child();
    }
}
