package com.yaoyouwei.dao;

import java.util.List;

import com.yaoyouwei.pojo.SysUser;

public interface ISysUserDao {
	List<SysUser> queryUserList(SysUser user);
}