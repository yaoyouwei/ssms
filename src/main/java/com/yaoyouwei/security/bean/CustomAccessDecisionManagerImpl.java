package com.yaoyouwei.security.bean;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
public class CustomAccessDecisionManagerImpl implements ICustomAccessDecisionManager {
	private static Log log = LogFactory.getLog(CustomAccessDecisionManagerImpl.class);
	/**
	 * 如果该页面不需要权限访问,则直接结束
	 * authentication:用户的权限(角色)
	 * configAttributes:访问该资源所需要的权限(角色)
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		log.info("进入自定义决策器,判断用户的角色是否存在于访问当前资源所需要的角色中");
		if (null == configAttributes) {
			return;
		}
		//访问该uri所需要的角色列表
		Iterator<ConfigAttribute> configAttributeItr = configAttributes.iterator();
		while (configAttributeItr.hasNext()) {
			ConfigAttribute configAttribute = configAttributeItr.next();
			String needRole = ((SecurityConfig) configAttribute).getAttribute();//访问该资源所需要角色
			for (GrantedAuthority ownRole : authentication.getAuthorities()) {//该用户拥有的角色
				if (needRole.trim().equals(ownRole.getAuthority().trim())) {
					return;//放行
				}
			}
		}
		//该用户没有权限访问该资源
		throw new AccessDeniedException("Access Denied");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
