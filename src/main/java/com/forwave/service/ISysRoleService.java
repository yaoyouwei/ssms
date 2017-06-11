package com.forwave.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forwave.pojo.SysRole;
import com.forwave.pojo.SysUser;
public interface ISysRoleService {
	
	List<SysRole> queryRoleListByUser(SysUser user);
	
	List<SysRole> queryAllRoleList();
	List<SysRole> queryRoleList(SysRole role);
	SysRole queryRoleById(String roleId);
}
