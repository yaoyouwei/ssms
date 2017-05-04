package com.forwave.dao;

import java.util.List;

import com.forwave.pojo.SysRole;
import com.forwave.pojo.SysUser;

public interface ISysRoleDao {
	
	List<SysRole> queryRoleListByUser(SysUser user);

}
