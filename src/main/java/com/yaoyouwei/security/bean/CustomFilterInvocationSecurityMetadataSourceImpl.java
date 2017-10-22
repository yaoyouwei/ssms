package com.yaoyouwei.security.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yaoyouwei.entity.Permission;
import com.yaoyouwei.entity.Role;
import com.yaoyouwei.service.IPermissionService;
import com.yaoyouwei.service.IRoleService;

/**
 * 从数据库中获取 权限-角色  的对应关系
 * 根据权限获取对应的角色
 * @author yaoyouwei
 */
public class CustomFilterInvocationSecurityMetadataSourceImpl implements ICustomFilterInvocationSecurityMetadataSource {
	private static Log log = LogFactory.getLog(CustomFilterInvocationSecurityMetadataSourceImpl.class);
    @Resource
	private IRoleService roleService;
    @Resource
	private IPermissionService permissionService;

	//权限-角色  的对应关系; key:url, value:角色
	private HashMap<String, Collection<ConfigAttribute>> resourceMap = null;

	/**
	 * 
	 * 自定义方法，这个类放入到Spring容器后， 指定init为初始化方法，从数据库中读取资源
	 */
	@PostConstruct 
	public void init() {
		loadResourceDefine();
	}

	/**
	 * 
	 * (程序启动的时候就加载所有资源信息).
	 */
	private void loadResourceDefine() {
		log.info("初始化url-roles Map");
		// 在Web服务器启动时，获取系统所有权限
		List <Role> roles = roleService.selectList(new EntityWrapper<Role>());
		
		//资源url为key， 角色名称的集合为value,角色名称就是那些以ROLE_为前缀的值
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		for (Role role : roles) {
			//角色
			ConfigAttribute configAttribute = new SecurityConfig(role.getRoleSecurity());// 角色名:ROLE_XXXX--value
			List<Permission> permissions = permissionService.selectByRole(role);// 获得所有的权限(uri)

			//每个角色拥有的权限
			for (Permission permission : permissions) {
				String url = permission.getUrl();// uri作为key
				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中
				 * 
				 * ROLE_AdMIN  index.jsp
				 * ROLE_MAN    index.jsp
				 * map<index.jsp, [ROLE_AdMIN,ROLE_MAN]>
				 */
				if (resourceMap.containsKey(url)) {
					//获得原来的集合
					Collection<ConfigAttribute> configAttributes = resourceMap.get(url);
					configAttributes.add(configAttribute);
					resourceMap.put(url, configAttributes);
				} else {//首次添加的key
					Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
					configAttributes.add(configAttribute);
					resourceMap.put(url, configAttributes);
				}
			}
		}
		//调试代码 
		System.out.println("=========权限:角色=====================");
		log.info(resourceMap);
		Iterator<Entry<String,Collection<ConfigAttribute>>> it = resourceMap.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,Collection<ConfigAttribute>> entry = it.next();
			String url = entry.getKey();
			System.out.println(url+":"+entry.getValue());
		}

	}



	/**
	 * 根据用户访问的uri，加载该uri所需要角色列表　
	 * Object object:uri地址
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		log.info("根据url获取对应role");
		//最初请求的uri格式:/crm/index.jsp
		// object 是一个URL ,为用户请求URL
		String url = ((FilterInvocation) object).getRequestUrl().trim();
		log.info("url:"+url);
		
		if ("/".equals(url)) {
			return null;
		}
		//int firstQuestionMarkIndex = url.indexOf(".");
		int firstQuestionMarkIndex = url.indexOf("?");
		// 判断请求是否带有参数 如果有参数就去掉后面的后缀和参数(/index.do --> /index)
		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}
		//最终形成的uri 格式:/index

		Iterator<String> ite = resourceMap.keySet().iterator();
		// 取到请求的URL后与上面取出来的资源做比较
		//为什么不直接用map获取?resourceMap.get(resURL);
		while (ite.hasNext()) {
			String resURL = ite.next().trim();
			if (url.equals(resURL)) {
				//获得该uri所需要的角色列表
				return resourceMap.get(resURL);
			}
		}
		//如果数据库里面没有该uri的信息，表示该uri不需要经过权限验证了
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	

}
