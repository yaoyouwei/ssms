package com.yaoyouwei.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yaoyouwei.dao.IRoleDao;
import com.yaoyouwei.entity.Role;
import com.yaoyouwei.entity.User;
import com.yaoyouwei.service.IRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<IRoleDao, Role> implements IRoleService {
	
	@Override
	public List<Role> selectByUser(User user) {
		return  super.baseMapper.selectByUser(user);
	}

	@Override
	public Page<Role> selectPageByUser(Page<Role> page,User user) {
		page.setRecords(selectByUser(user));
		return page;
	}
}
