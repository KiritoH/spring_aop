package com.yww.demo5;

public class StudentDaoImpl implements StudentDao {
    public void save() {
        System.out.println("学生保存...");
    }

    public void update() {
        System.out.println("学生修改...");
    }

    public void delete() {
        System.out.println("学生删除...");
    }

    public void find() {
        System.out.println("学生查询...");
    }
}
