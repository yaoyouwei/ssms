package com.yaoyouwei.dao;

import java.util.List;

import com.yaoyouwei.dto.SysPermissionDto;
import com.yaoyouwei.pojo.SysRole;

public interface ISysPermissionDao {
	/**
	 * 根据
	 * @param role
	 * @return
	 */
	List <SysPermissionDto> queryPermissionListByRole(SysRole role);
}
