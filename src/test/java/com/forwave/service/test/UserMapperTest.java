package com.forwave.service.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.forwave.pojo.SysUser;
import com.forwave.service.ISysUserService;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    ISysUserService sysUserService;

    @Test
    @Rollback(false) //控制回滚
    public void queryUserByLoginId() throws Exception {
        
        SysUser user = sysUserService.queryUserByLoginId("Alan");
        System.out.println(user.getId());
        System.out.println(user.getLoginId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        
    }
  
}
