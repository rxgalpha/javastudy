package com.rxg.zhixingshunxu;

public class Food {
    static{
        System.out.println("Food类静态代码块");
    }
    Food(String s){
        System.out.println(s+"静态变量初始化");
    }
}
