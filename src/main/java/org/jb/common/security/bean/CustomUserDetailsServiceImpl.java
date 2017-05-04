package org.jb.common.security.bean;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.forwave.pojo.SysRole;
import com.forwave.pojo.SysUser;
import com.forwave.service.ISysRoleServiec;
import com.forwave.service.IUserService;

public class CustomUserDetailsServiceImpl implements
		ICustomUserDetailsService {

	private ISysRoleServiec roleService;

	@Override
	public UserDetails loadUserByUsername(String loginUserName)
			throws UsernameNotFoundException {
		SysUser user = new SysUser();
		user.setName(loginUserName);
		//获得当前用户的角色列表在本系统中，只有一个角色)
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		user.setAuthorities(grantedAuths);
		return user;
	}

	// 取得用户的权限
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
