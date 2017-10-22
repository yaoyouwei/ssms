package com.yaoyouwei.service;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yaoyouwei.entity.Menu;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-security.xml","classpath:spring-aop.xml"})
public class MenuServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IMenuService menuService;

    @Test
    @Rollback(false) //控制回滚
    public void queryUser() throws Exception {
        Menu menu = new Menu();
        List<Menu> menuList = menuService.queryMenu(menu);
        for(Menu m:menuList){
        	System.out.println(m);
        }
    }
  
}
