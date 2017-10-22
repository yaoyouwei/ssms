package com.yaoyouwei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
	@Resource
    IUserDao userDao;
    

	@Override
	public List<User> queryUser(User user) {
		EntityWrapper<User> ew = new EntityWrapper<User>(user);
		return userDao.selectList(ew);
	}

	

	@Override
	public User queryUserByLoginId(String loginId) {
		User user = new User();
		user.setLoginId(loginId);
		return userDao.selectOne(user);
	}

	@Override
	public User queryUserById(String id) {
		return userDao.selectById(id);
	}
	
}
