package com.forwave.service.impl;


import java.util.List;

import javax.annotation.Resource;







import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.forwave.dao.ISysUserDao;
import com.forwave.pojo.SysUser;
import com.forwave.service.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService {
	//private static Log logger = LogFactory.getLog(SysUserServiceImpl.class);

    @Resource
    private ISysUserDao sysUserDao;

	@Override
	public SysUser queryUserByName(String name) {
		SysUser user = new SysUser();
		user.setName(name);
		user.setDelFlag(0);
		return sysUserDao.queryUserList(user).get(0);
	}

	@Override
	public SysUser queryUserById(String id) {
		SysUser user = new SysUser();
		user.setId(id);
		user.setDelFlag(0);
		return sysUserDao.queryUserList(user).get(0);
	}

	@Override
	public List<SysUser> queryUserList(SysUser user) {
		return sysUserDao.queryUserList(user);
	}

	@Override
	public SysUser queryUserByLoginId(String loginId) {
		if(StringUtils.isBlank(loginId)){
			return null;
		}
		SysUser user = new SysUser();
		user.setLoginId(loginId);
		user.setDelFlag(0);
		return sysUserDao.queryUserList(user).get(0);
	}

	

	
    
   

}
