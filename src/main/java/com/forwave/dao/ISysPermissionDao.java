package com.forwave.dao;

import java.util.List;

import com.forwave.dto.SysPermissionDto;
import com.forwave.pojo.SysRole;

public interface ISysPermissionDao {
	/**
	 * 根据
	 * @param role
	 * @return
	 */
	List <SysPermissionDto> queryPermissionListByRole(SysRole role);
}
