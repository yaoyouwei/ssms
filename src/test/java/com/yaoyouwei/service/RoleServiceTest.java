package com.yaoyouwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yaoyouwei.entity.Role;
import com.yaoyouwei.entity.User;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-security.xml","classpath:spring-aop.xml"})
public class RoleServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IRoleService roleServiec;

    @Test
    @Rollback(false) //控制回滚
    public void queryRoleListByUser(){
        User user = new User();
        user.setDelFlag(0);
        user.setName("Alan");
        user.setId("01");
        List<Role> roles = roleServiec.queryRoleListByUser(user);
        System.out.println(roles.size());
        for(Role role:roles){
        	System.out.println(role);
        }
    }
    
    @Test
    @Rollback(false) //控制回滚
    public void queryRoleList()  {
    	//02军长1jznull
        Role roleQuery = new Role();
        roleQuery.setName("军长");//设置为null表示忽略此条件
        roleQuery.setEnabled(1);
        //roleQuery.setDescription("");
        List<Role> roles = roleServiec.queryRoleList(roleQuery);
        for(Role role:roles){
        	System.out.println(role);
        }
        
        
    }
    
    @Test
    @Rollback(false) //控制回滚
    public void queryRoleById()  {
    	Role role = roleServiec.queryRoleById("01");
        System.out.println(role);
    }
  
}
