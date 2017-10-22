package com.yaoyouwei.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yaoyouwei.entity.Permission;
import com.yaoyouwei.entity.Role;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-security.xml","classpath:spring-aop.xml"})
public class PermissionServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IPermissionService permissionService;

    
    @Test
    @Rollback(false) //控制回滚
    public void queryRightListByRole()  {
        Role roleQuery = new Role();
        roleQuery.setName("司令");
        roleQuery.setEnabled(1);
        List<Permission> rights = permissionService.selectByRole(roleQuery);
        for(Permission right:rights){
        	System.out.println(right);
        }
        
        
    }
  
}
