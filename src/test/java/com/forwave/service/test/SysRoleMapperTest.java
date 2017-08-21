package com.forwave.service.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yaoyouwei.pojo.SysRole;
import com.yaoyouwei.pojo.SysUser;
import com.yaoyouwei.service.ISysRoleService;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SysRoleMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    ISysRoleService sysRoleServiec;

    @Test
    @Rollback(false) //控制回滚
    public void queryRoleListByUser(){
        SysUser user = new SysUser();
        user.setDelFlag(0);
        user.setName("Alan");
        List<SysRole> roles = sysRoleServiec.queryRoleListByUser(user);
        for(SysRole role:roles){
        	System.out.print(role.getId());
        	System.out.print(role.getName());
        	System.out.print(role.getEnabled());
        	System.out.print(role.getRoleSecurity());
        	System.out.println(role.getLastUpdateDate());
        }
        
        
    }
    
    @Test
    @Rollback(false) //控制回滚
    public void queryRoleList()  {
    	//02军长1jznull
        SysRole roleQuery = new SysRole();
        //roleQuery.setName("军长");
       // roleQuery.setEnabled(1);
        List<SysRole> roles = sysRoleServiec.queryRoleList(roleQuery);
        for(SysRole role:roles){
        	System.out.print(role.getId());
        	System.out.print(role.getName());
        	System.out.print(role.getEnabled());
        	System.out.print(role.getRoleSecurity());
        	System.out.println(role.getLastUpdateDate());
        }
        
        
    }
  
}
