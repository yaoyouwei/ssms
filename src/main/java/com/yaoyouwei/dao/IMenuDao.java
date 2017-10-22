package com.yaoyouwei.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yaoyouwei.entity.Menu;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public interface IMenuDao extends BaseMapper<Menu> {
	List<Menu> queryMenuList(Menu menu);
}