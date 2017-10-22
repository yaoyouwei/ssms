package com.yaoyouwei.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yaoyouwei.entity.Permission;
import com.yaoyouwei.entity.Role;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IPermissionDao extends BaseMapper<Permission> {
	
	List<Permission> queryPermissionListByRole(Role role);

}