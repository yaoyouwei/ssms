package com.yaoyouwei.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaoyouwei.common.utils.Constant;
import com.yaoyouwei.dto.UserDto;
import com.yaoyouwei.pojo.User;
import com.yaoyouwei.service.ISysUserService;

@Controller
@RequestMapping({ "user/mgnt" })
public class UserController{
	//private static Log logger = LogFactory.getLog(UserController.class);
    //@Resource
    ISysUserService userService;

	@RequestMapping(value={ "list.do" }, params = { "r_showUserList" })
	public String listContact(ModelMap mm) {
		
		return "user_list";
	}
	
	@RequestMapping(value={ "list.do" }, params = { "r_showUserListRemote" })
	public String test1(ModelMap mm) {
		return "user_list_remote";
	}
	

	@ResponseBody
	@RequestMapping(value = { "list.do" }, params = { "c_saveUser" })
	public Map<String,Object> saveUser(User user,ModelMap mm) {
		Map<String,Object> result = new HashMap<String,Object>();
	    try {
			result.put(Constant.SUCCESS, true);
		} catch (Exception e) {
			result.put(Constant.SUCCESS, false);
			result.put(Constant.ERROR_INFO, e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = { "list.do" }, params = { "c_syncUserList" })
	public Map<String,Object> syncUserList(User user,ModelMap mm) {
		Map<String,Object> result = new HashMap<String,Object>();
	    try {
			result.put(Constant.SUCCESS, true);
		} catch (Exception e) {
			result.put(Constant.SUCCESS, false);
			result.put(Constant.ERROR_INFO, e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = { "list.do" }, params = { "u_updateUser" })
	public Map<String,Object> updateUser(User user,ModelMap mm) {
		Map<String,Object> result = new HashMap<String,Object>();
	    try {
			result.put(Constant.SUCCESS, true);
		} catch (Exception e) {
			result.put(Constant.SUCCESS, false);
			result.put(Constant.ERROR_INFO, e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = { "list.do" }, params = { "d_deleteUser" })
	public Map<String,Object> deleteUser(User user,ModelMap mm) {
		Map<String,Object> result = new HashMap<String,Object>();
	    try {
			result.put(Constant.SUCCESS, true);
		} catch (Exception e) {
			result.put(Constant.SUCCESS,false);
			result.put(Constant.ERROR_INFO, e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = { "list.do" }, params = { "d_batchDeleteUser" })
	public Map<String,Object> batchDeleteUser(String [] userIds,ModelMap mm) {
		Map<String,Object> result = new HashMap<String,Object>();
	    try {
			result.put(Constant.SUCCESS, true);
		} catch (Exception e) {
			result.put(Constant.SUCCESS,false);
			result.put(Constant.ERROR_INFO, e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = { "list.do" }, params = { "r_queryUserList"})
	public Map<String,Object> getUserMapList(UserDto user,ModelMap mm) {
		Map<String,Object> result = new HashMap<String,Object>();
	    try {
	    	result.put(Constant.SUCCESS, true);
		} catch (Exception e) {
			result.put(Constant.SUCCESS, false);
			result.put(Constant.ERROR_INFO, e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	




	

}