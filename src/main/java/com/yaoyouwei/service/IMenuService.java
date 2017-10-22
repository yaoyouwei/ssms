package com.yaoyouwei.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.yaoyouwei.entity.Menu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IMenuService extends IService<Menu> {
	List<Menu> queryMenu(Menu menu);
}
