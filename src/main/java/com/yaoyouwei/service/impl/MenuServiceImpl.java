package com.yaoyouwei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yaoyouwei.dao.IMenuDao;
import com.yaoyouwei.entity.Menu;
import com.yaoyouwei.service.IMenuService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<IMenuDao, Menu> implements IMenuService {
    @Resource 
    IMenuDao menuDao;
    
	@Override
	public List<Menu> queryMenu(Menu menu){
		EntityWrapper<Menu> ew = new EntityWrapper<Menu>(menu);
		return menuDao.selectList(ew);
	}
}
