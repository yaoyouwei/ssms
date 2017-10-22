package com.yaoyouwei.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yaoyouwei.entity.User;

/**
 * <p>
  * 用户DAO接口
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IUserDao extends BaseMapper<User> {
	List<User> queryUserList(User user);
}