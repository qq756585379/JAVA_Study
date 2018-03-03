package com.itheima.g_annotation.b_web;

import org.springframework.stereotype.Repository;

@Repository("studentDaoId") //按名称注入
public class StudentDaoImpl implements StudentDao {

    @Override
    public void save() {
        System.out.println("dao");
    }

}
