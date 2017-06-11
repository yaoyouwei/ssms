package com.forwave.dao;

import java.util.List;

import com.forwave.pojo.SysUser;

public interface ISysUserDao {
	List<SysUser> queryUserList(SysUser user);
}