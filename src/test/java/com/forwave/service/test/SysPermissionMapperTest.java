package com.forwave.service.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.forwave.dto.SysPermissionDto;
import com.forwave.pojo.SysPermission;
import com.forwave.pojo.SysRole;
import com.forwave.service.ISysPermissionService;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SysPermissionMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    ISysPermissionService sysPermissionService;

    
    @Test
    @Rollback(false) //控制回滚
    public void queryRightListByRole()  {
    	//02军长1jznull
        SysRole roleQuery = new SysRole();
        roleQuery.setName("司令");
        roleQuery.setEnabled(1);
        List<SysPermissionDto> rights = sysPermissionService.queryPermissionListByRole(roleQuery);
        for(SysPermissionDto right:rights){
        	System.out.print(right.getId());
        	System.out.print(right.getActionId());
        	System.out.println(right.getType());
        	System.out.println(right.getUrl());
        }
        
        
    }
  
}
