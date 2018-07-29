package com.yww.demo2;

import org.junit.jupiter.api.Test;

public class SpringDemo2 {


    @Test
    public void demo1(){

        ProductDao productDao = new ProductDao();
        productDao.save();
        productDao.delete();
        productDao.find();
        productDao.update();

        ProductDao proxy = (ProductDao) new MyCGlibProxy(productDao).createProxy();

        proxy.update();
        proxy.find();
        proxy.delete();
        proxy.save();
    }
}
