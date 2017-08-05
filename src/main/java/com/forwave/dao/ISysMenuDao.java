package com.forwave.dao;

import java.util.List;

import com.forwave.pojo.SysMenu;

public interface ISysMenuDao {
	
	List<SysMenu> queryMenuList(SysMenu menu);
}
