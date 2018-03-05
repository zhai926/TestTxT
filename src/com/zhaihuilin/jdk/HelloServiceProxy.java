package com.zhaihuilin.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  代理类 提供真实对象的绑定和代理方法
 * Created by zhaihuilin on 2018/2/28  10:45.
 */
public class HelloServiceProxy implements InvocationHandler {

    private  Object target;

    /**
     * 通过代理对象调用方法首先进入这个方法
     * @param proxy  代理对象
     * @param method  被调用的方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result =null;

        //反射前调用
        System.out.println("我准备说新年好！");

        //执行方法，相当于调用HelloServiceImpl类的sayHello方法
        result=method.invoke(target,args);

        //反射后调用
        System.out.println("我已经说过新年好了！");

        return result;

    }

    /**
     * 绑定一个委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target=target;

        //取得代理对象，jdk代理需要提供接口
        /**
         * 有三个参数
         *  1.第一个参数是类加载器
         *  2.第二个参数是接口（代理对象挂在哪个接口下）
         *  3.第三个参数是this代表当前HelloServiceProxy类，换句话说是使用HelloServiceProxy的代理方法作为对象的代理执行者。
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
