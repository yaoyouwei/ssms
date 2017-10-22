package com.yaoyouwei.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yaoyouwei.entity.Role;
import com.yaoyouwei.entity.User;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IRoleDao extends BaseMapper<Role> {
	public List<Role> queryRoleListByUser(User user);
}