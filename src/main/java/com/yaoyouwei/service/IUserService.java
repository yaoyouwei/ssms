package com.yaoyouwei.service;

import com.baomidou.mybatisplus.service.IService;
import com.yaoyouwei.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IUserService extends IService<User> {
	User selectByLoginId(String loginId);
 }
