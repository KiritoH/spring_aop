package com.yww.demo4;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_2.xml")
public class SpringDemo4 {

/*
    @Resource(name = "customerDao")
    private CustomerDao customerDao;
*/


    @Resource(name = "customerDaoProxy")
    private CustomerDao customerDao;

    @Test
    public void demo1(){
        customerDao.find();
        customerDao.save();
        customerDao.update();
        customerDao.delete();

    }
}
