package com.yww.demo;

import org.junit.jupiter.api.Test;

public class SpringDemo1 {
    @Test
    public void demo1(){

        UserDao userDao = new UserDaoImpl();


        userDao.save();
        userDao.update();
        userDao.delete();
        userDao.find();

        //代理该类(注意该对象是UserDaoImpl)
        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
