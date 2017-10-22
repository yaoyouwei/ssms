package com.yaoyouwei.service;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yaoyouwei.entity.User;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-security.xml","classpath:spring-aop.xml"})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IUserService userService;

    @Test
    @Rollback(false) //控制回滚
    public void queryUser() throws Exception {
        
        User user = new User();
        user.setId("01");
        user.setName("Alan");
        user.setDelFlag(0);
        user.setLoginId("Alan");
        List<User> userList = userService.queryUser(user);
        for(User u:userList){
        	System.out.println(u);
        }
    }
    
    @Test
    @Rollback(false) //控制回滚
    public void queryUserByLoginId() throws Exception {
        User user = userService.queryUserByLoginId("Alan");
        System.out.println(user);
    }
    
    @Test
    @Rollback(false) //控制回滚
    public void queryUserById() throws Exception {
    	User user = userService.queryUserById("01");
    	System.out.println(user);
    }
  
}
