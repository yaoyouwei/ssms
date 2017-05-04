package com.forwave.service.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.forwave.pojo.User;
import com.forwave.service.IUserService;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IUserService userService;

    
    @Rollback(false) //控制回滚
    public void testSaveUser() throws Exception {
        
        List<User> users = userService.getUserListFromRemote();
        for(User user:users){
        	userService.saveUser(user);//更新
        }
        
    }
  
}
