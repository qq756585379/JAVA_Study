package com.itheima.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID() {
        //得到随机的一个字符串
        return UUID.randomUUID().toString();
    }

/*
    public static void main(String[] args) {
       System.out.println(getUUID());
	}
*/

}
