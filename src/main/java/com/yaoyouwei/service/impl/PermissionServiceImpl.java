package com.yaoyouwei.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yaoyouwei.dao.IPermissionDao;
import com.yaoyouwei.entity.Permission;
import com.yaoyouwei.entity.Role;
import com.yaoyouwei.service.IPermissionService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<IPermissionDao, Permission> implements IPermissionService {
    
	@Override
	public List<Permission> selectByRole(Role role) {
		List<Permission> list = super.baseMapper.selectByRole(role);
		return list;
	}
	
}
