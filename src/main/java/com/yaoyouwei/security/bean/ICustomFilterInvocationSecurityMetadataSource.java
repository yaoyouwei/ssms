package com.yaoyouwei.security.bean;

import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/**
 * 从数据库中获取 权限-角色  的对应关系
 * 根据权限获取对应的角色
 * @author yaoyouwei
 */
public interface ICustomFilterInvocationSecurityMetadataSource extends
		FilterInvocationSecurityMetadataSource {

}
