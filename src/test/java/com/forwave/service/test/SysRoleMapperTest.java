package com.forwave.service.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.forwave.pojo.SysRole;
import com.forwave.pojo.SysUser;
import com.forwave.service.ISysRoleServiec;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SysRoleMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    ISysRoleServiec sysRoleServiec;

    @Test
    @Rollback(false) //控制回滚
    public void queryRoleListByUser() throws Exception {
        SysUser user = new SysUser();
        user.setEnabled(1);
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
  
}
