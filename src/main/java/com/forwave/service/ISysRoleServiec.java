package com.forwave.service;

import java.util.List;

import com.forwave.pojo.SysRole;
import com.forwave.pojo.SysUser;

public interface ISysRoleServiec {
	
	List<SysRole> queryRoleListByUser(SysUser user);
}
