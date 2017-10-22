package com.yaoyouwei.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.yaoyouwei.entity.Permission;
import com.yaoyouwei.entity.Role;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IPermissionService extends IService<Permission> {
	List <Permission> selectByRole(Role role);
}
