package com.forwave.service.impl;

import java.util.List;

import javax.annotation.Resource;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.forwave.dao.ISysRoleDao;
import com.forwave.pojo.SysRole;
import com.forwave.pojo.SysUser;
import com.forwave.service.ISysRoleService;

@Service
public class SysRoleServiceImpl implements ISysRoleService {
	private static Log logger = LogFactory.getLog(SysRoleServiceImpl.class);

    @Resource
    private ISysRoleDao sysRoleDao;

	@Override
	public List<SysRole> queryRoleListByUser(SysUser user) {
		return sysRoleDao.queryRoleListByUser(user);
	}

	@Override
	public List<SysRole> queryAllRoleList() {
		SysRole role = new SysRole();
		return sysRoleDao.queryRoleList(role);
	}

	@Override
	public List<SysRole> queryRoleList(SysRole role) {
		return sysRoleDao.queryRoleList(role);
	}

	@Override
	public SysRole queryRoleById(String roleId) {
		SysRole role = new SysRole();
		role.setId(roleId);
		return sysRoleDao.queryRoleList(role).get(0);
	}
    
   

 
}
