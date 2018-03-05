package com.zhaihuilin.jdk;

/**
 * Created by zhaihuilin on 2018/2/28  10:57.
 */
public class HelloServiceMain {

    public static void main(String[] args) {

        //1. 创建实现代理接口对象
        HelloServiceProxy  helloServiceProxy =new HelloServiceProxy();

        //2. 获取代理对象
        HelloService  object= (HelloService) helloServiceProxy.bind(new HelloServiceImpl());

        //3. 调用服务方法
        object.sayHello("詹三");
    }
}
