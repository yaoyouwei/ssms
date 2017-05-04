package com.forwave.service.impl;

import java.util.List;

import javax.annotation.Resource;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.forwave.dao.ISysRoleDao;
import com.forwave.pojo.SysRole;
import com.forwave.pojo.SysUser;
import com.forwave.service.ISysRoleServiec;

@Service("sysRoleService")
public class SysRoleServiceImpl implements ISysRoleServiec {
	private static Log logger = LogFactory.getLog(SysRoleServiceImpl.class);

    @Resource
    private ISysRoleDao sysRoleDao;

	@Override
	public List<SysRole> queryRoleListByUser(SysUser user) {
		return sysRoleDao.queryRoleListByUser(user);
	}
    
   

 
}
