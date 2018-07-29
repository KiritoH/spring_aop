package com.yww.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyJdkProxy implements InvocationHandler {

    private UserDao userDao;

    public MyJdkProxy(UserDao userDao){
        this.userDao = userDao;
    }

    //jdk动态代理要对实现接口的类进行代理
    public Object createProxy(){
        /**
         * 传三个参数
         * 1. 类的加载器  getClass().getClassLoader()
         * 2. 实现的接口  getClass().getInterfaces()
         * 3. 一个接口    InvocationHandler接口(可以用匿名内部类来new出来,也可以直接实现接口)
         */
        //代理传过来的类
        Object proxy = Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
        return proxy;

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if ("save".equals(method.getName())){
            System.out.println("权限校验....");
            return method.invoke(userDao,args);
        }
        //照常执行该方法
        return method.invoke(userDao,args);
    }
}
