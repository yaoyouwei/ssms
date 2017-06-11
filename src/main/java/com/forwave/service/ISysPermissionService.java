package com.forwave.service;

import java.util.List;

import com.forwave.dto.SysPermissionDto;
import com.forwave.pojo.SysRole;

public interface ISysPermissionService {
	
	List <SysPermissionDto> queryPermissionListByRole(SysRole role);
}
