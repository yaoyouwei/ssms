package com.yaoyouwei.security.bean;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yaoyouwei.pojo.SysRole;
import com.yaoyouwei.pojo.SysUser;
import com.yaoyouwei.service.ISysRoleService;
import com.yaoyouwei.service.ISysUserService;
/**
 * 获取用户以及用户的角色信息
 * @author yaoyouwei
 */
public class CustomUserDetailsServiceImpl implements ICustomUserDetailsService {
	private static Log log = LogFactory.getLog(CustomUserDetailsServiceImpl.class);

    @Resource
	private ISysRoleService roleService;
    @Resource
   	private ISysUserService sysUserService;

	@Override
	public UserDetails loadUserByUsername(String loginUserName)
			throws UsernameNotFoundException {
		log.info("开始验证用户:["+loginUserName+"]");
		SysUser user = sysUserService.queryUserByLoginId(loginUserName);
		if(user == null){
			throw new UsernameNotFoundException("用户不存在!");
		}
		//获得当前用户的角色列表
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		user.setAuthorities(grantedAuths);
		return user;
	}

	/**
	 * 获取用户拥有的角色
	 * @param user
	 * @return
	 */
	private Set<GrantedAuthority> obtionGrantedAuthorities(SysUser user) {
		Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
		List<SysRole> roles = roleService.queryRoleListByUser(user);
		//存在我们的角色列表
		for(SysRole role:roles){
			grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getRoleSecurity()));
		}
		return grantedAuthoritySet;
	}


}
