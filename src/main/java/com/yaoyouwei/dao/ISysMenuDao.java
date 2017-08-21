package com.yaoyouwei.dao;

import java.util.List;

import com.yaoyouwei.pojo.SysMenu;

public interface ISysMenuDao {
	
	List<SysMenu> queryMenuList(SysMenu menu);
}
