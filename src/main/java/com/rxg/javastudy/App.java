package com.rxg.javastudy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map hm = new HashMap();
        System.out.println(hm);
        Map chm = new ConcurrentHashMap<>();
        System.out.println(chm.toString());
    }
}
