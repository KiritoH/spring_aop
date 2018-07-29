package com.yww.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringDmo6 {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Test
    public void demo(){
        studentDao.find();
        studentDao.delete();
        studentDao.save();
        studentDao.update();


        customerDao.find();
        customerDao.save();
        customerDao.update();
        customerDao.delete();
    }
}
