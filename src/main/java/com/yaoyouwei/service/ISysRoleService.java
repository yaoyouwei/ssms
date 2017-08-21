package com.yaoyouwei.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yaoyouwei.pojo.SysRole;
import com.yaoyouwei.pojo.SysUser;
public interface ISysRoleService {
	
	List<SysRole> queryRoleListByUser(SysUser user);
	
	List<SysRole> queryAllRoleList();
	List<SysRole> queryRoleList(SysRole role);
	SysRole queryRoleById(String roleId);
}
