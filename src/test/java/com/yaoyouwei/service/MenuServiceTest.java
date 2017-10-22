package com.yaoyouwei.service;


import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-security.xml","classpath:spring-aop.xml"})
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MenuServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IMenuService menuService;

    @Test
    @Rollback(false) //控制回滚
    public void test() throws Exception {
    }
  
}
