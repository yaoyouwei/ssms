package com.forwave.service;

import com.forwave.pojo.SysUser;

import java.util.List;

public interface ISysUserService {
	SysUser queryUserByName(String name);
	SysUser queryUserByLoginId(String loginId);
	SysUser queryUserById(String id);
	List<SysUser> queryUserList(SysUser user);

}