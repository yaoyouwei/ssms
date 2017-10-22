package com.yaoyouwei.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yaoyouwei.dao.IUserDao;
import com.yaoyouwei.entity.User;
import com.yaoyouwei.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {
	

	@Override
	public User selectByLoginId(String loginId) {
		User user = new User();
		user.setLoginId(loginId);
		return  super.baseMapper.selectOne(user);
	}




}
