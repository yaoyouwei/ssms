package com.yaoyouwei.service;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yaoyouwei.entity.User;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IUserService us;
    
    @Test
    @Rollback(false) //控制回滚
    public void testSelectPage() throws Exception {
    	Page<User> p = new Page<User>(2,5);
    	Page<User> page = us.selectPage(p);
    	//EntityWrapper<User> ew = new EntityWrapper<User>();
    	List<User> users = page.getRecords();
    	for(User u:users){
    		System.out.println(u);
    	}
    	
    }

    
    @Test
    @Rollback(false) //控制回滚
    public void queryUserByLoginId() throws Exception {
        User user = us.selectByLoginId("Alan");
        System.out.println(user);
    }
    
    
    
    @Test
    @Rollback(false) //控制回滚
    public void testInsert() throws Exception {
    	User user = new User();
    	user.setId("123456789");
    	user.setName("yaoyouwei");
    	user.setDelFlag(0);
    	user.setLoginId("yaoyouwei");
    	user.setPassword("1234");
    	us.insert(user);
    	EntityWrapper<User> ew = new EntityWrapper<User>(user);
    	User ui = us.selectOne(ew);
    	System.out.println(ui);
    }
    
    
  
}
