package com.yaoyouwei.service;

import java.util.List;

import com.yaoyouwei.dto.SysPermissionDto;
import com.yaoyouwei.pojo.SysRole;

public interface ISysPermissionService {
	
	List <SysPermissionDto> queryPermissionListByRole(SysRole role);
}
