package com.zhaihuilin;

import java.lang.reflect.Method;

/**
 * 反射技术
 * Created by zhaihuilin on 2018/2/28  10:35.
 */
public class RefleService {

    public void  sayHello(String name){
        System.out.println("你好，"+name);
    }


    public static void main(String[] args) {
        try {
          //通过反射创建   RefleService 对象
          Object service=   Class.forName(RefleService.class.getName()).newInstance();
          //获取服务方法
          Method method =service.getClass().getMethod("sayHello",String.class);
          //反射调用方法
          method.invoke(service,"张三");

            System.out.println(
                    service.getClass()
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }



































}
