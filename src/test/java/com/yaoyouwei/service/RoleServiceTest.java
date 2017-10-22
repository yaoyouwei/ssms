package com.yaoyouwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.baomidou.mybatisplus.plugins.Page;
import com.yaoyouwei.entity.Role;
import com.yaoyouwei.entity.User;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RoleServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IRoleService roleServiec;

    @Test
    @Rollback(false) //控制回滚
    public void selectByUser(){
        User user = new User();
        user.setDelFlag(0);
        user.setName("Alan");
        user.setId("01");
        List<Role> roles = roleServiec.selectByUser(user);
        System.out.println(roles.size());
        for(Role role:roles){
        	System.out.println(role);
        }
    }
    
    @Test
    @Rollback(false) //控制回滚
    public void selectPageByUser(){
    	User user = new User();
    	user.setDelFlag(0);
    	user.setName("Alan");
    	user.setId("01");
    	Page<Role> page = roleServiec.selectPageByUser(new Page<Role>(1,2),user);
    	List<Role> roles = page.getRecords();
    	for(Role role:roles){
    		System.out.println(role);
    	}
    }
    
  
}
