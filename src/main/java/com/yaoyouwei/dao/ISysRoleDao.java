package com.yaoyouwei.dao;

import java.util.List;

import com.yaoyouwei.pojo.SysRole;
import com.yaoyouwei.pojo.SysUser;

public interface ISysRoleDao {
	
	List<SysRole> queryRoleListByUser(SysUser user);

	List<SysRole> queryRoleList(SysRole role);

}
