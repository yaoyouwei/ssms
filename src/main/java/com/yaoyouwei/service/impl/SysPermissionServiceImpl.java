package com.yaoyouwei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yaoyouwei.dao.ISysPermissionDao;
import com.yaoyouwei.dto.SysPermissionDto;
import com.yaoyouwei.pojo.SysRole;
import com.yaoyouwei.service.ISysPermissionService;
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
	
	@Resource 
	ISysPermissionDao sysPermissionDao;
	@Override
	public List<SysPermissionDto> queryPermissionListByRole(SysRole role) {
		return sysPermissionDao.queryPermissionListByRole(role);
	}

}
