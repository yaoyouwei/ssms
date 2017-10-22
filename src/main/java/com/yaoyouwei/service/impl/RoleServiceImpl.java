package com.yaoyouwei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
	
	@Resource
	IRoleDao roleDao;

	
	@Override
	public List<Role> queryRoleListByUser(User user) {
		List<Role> list = roleDao.queryRoleListByUser(user);
	    return list;
	}

	@Override
	public List<Role> queryAllRoleList() {
		return queryRoleList(new Role());
	}

	@Override
	public List<Role> queryRoleList(Role role) {
		EntityWrapper<Role> ew = new EntityWrapper<Role>(role);
		List<Role> list = roleDao.selectList(ew);
		return list;
	}

	@Override
	public Role queryRoleById(String roleId) {
		return roleDao.selectById(roleId);
	}
	
}
