package com.forwave.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.forwave.dao.ISysPermissionDao;
import com.forwave.dto.SysPermissionDto;
import com.forwave.pojo.SysRole;
import com.forwave.service.ISysPermissionService;
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
	
	@Resource 
	ISysPermissionDao sysPermissionDao;
	@Override
	public List<SysPermissionDto> queryPermissionListByRole(SysRole role) {
		return sysPermissionDao.queryPermissionListByRole(role);
	}

}
