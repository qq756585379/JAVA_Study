package com.itheima.g_annotation.a_ioc;

import org.springframework.stereotype.Component;

// @Component取代 <bean class="">
// @Component("userServiceId")取代 <bean id="" class="">

@Component("userServiceId")
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("g_annotation.a_ioc add user");
    }

}
