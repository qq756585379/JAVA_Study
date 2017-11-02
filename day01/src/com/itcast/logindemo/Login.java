package com.itcast.logindemo;

import com.itcast.entity.User;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = input.nextLine();
        System.out.println("请输入密码");
        String pwd = input.nextLine();

        DoLogin dl = new DoLogin();
        User user = dl.findUser(name, pwd);
        if (user != null) {
            System.out.println("欢迎回来！" + user.getName());
        } else {
            System.out.println("登录失败");
        }
    }

}
