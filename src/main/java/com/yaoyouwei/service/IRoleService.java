package com.yaoyouwei.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.yaoyouwei.entity.Role;
import com.yaoyouwei.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IRoleService extends IService<Role> {
    List<Role> queryRoleListByUser(User user);
	List<Role> queryAllRoleList();
	List<Role> queryRoleList(Role role);
	Role queryRoleById(String roleId);
}
