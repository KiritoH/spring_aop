package com.yww.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//需要引入CGlib开发包或者Spring开发包
public class MyCGlibProxy implements MethodInterceptor {

    private ProductDao productDao;

    public MyCGlibProxy(ProductDao productDao) {
        this.productDao = productDao;
    }


    public Object createProxy(){
        //1. 创建核心类
        Enhancer enhancer = new Enhancer();
        //2. 设置父类
        enhancer.setSuperclass(productDao.getClass());
        //3. 设置回调
        enhancer.setCallback(this);
        //4. 生成代理
        Object proxy = enhancer.create();

        return proxy;
    }


    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())){
            System.out.println("权限校验...");
            return methodProxy.invokeSuper(proxy,args);
        }
        //通过它调用其父类的方法,相当于原封不动调用其方法
        return methodProxy.invokeSuper(proxy,args);
    }
}
