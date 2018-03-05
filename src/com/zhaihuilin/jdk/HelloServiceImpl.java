package com.zhaihuilin.jdk;

/**
 * 实现类
 * Created by zhaihuilin on 2018/2/28  10:43.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("新年好啊！"+name);
    }
}
