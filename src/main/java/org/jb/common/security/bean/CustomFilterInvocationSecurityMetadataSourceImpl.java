package org.jb.common.security.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.jb.common.service.BaseService;
import org.jb.crm.sys.dto.SysRightDTO;
import org.jb.crm.sys.dto.SysRoleDTO;
import org.jb.crm.sys.dto.SysRoleQueryDTO;
import org.jb.crm.sys.service.ISysRoleService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;

public class CustomFilterInvocationSecurityMetadataSourceImpl extends
		BaseService implements ICustomFilterInvocationSecurityMetadataSource {

	private ISysRoleService sysRoleService;

	// key:url, value:角色
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
	 * TODO(程序启动的时候就加载所有资源信息).
	 */
	private void loadResourceDefine() {
		// 在Web服务器启动时，提取系统中的所有权限。
		SysRoleQueryDTO sysRoleQueryDTO = new SysRoleQueryDTO();
		List<SysRoleDTO> query = this.sysRoleService
				.loadAllNormalRoles(sysRoleQueryDTO);
		/*
		 * 应当是资源url为key， 角色名称为value。角色名称就是那些以ROLE_为前缀的值
		 */
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		for (SysRoleDTO auth : query) {
			
			ConfigAttribute ca = new SecurityConfig(auth.getRoleSecurity());// 角色名:ROLE_XXXX--value
			Set<SysRightDTO> rights = auth.getSysRights();// 获得所有的权限(uri)

			for (SysRightDTO right : rights) {
				String url = right.getRightUrl();// uri作为key
				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中
				 * 
				 * ROLE_AdMIN  index.jsp
				 * ROLE_MAN    index.jsp
				 * map<index.jsp, [ROLE_AdMIN,ROLE_MAN]>
				 * 。
				 */
				if (resourceMap.containsKey(url)) {
					//获得原来的集合
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
				} else {//首次添加的key
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(url, atts);
				}
			}
		}

	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	/**
	 * 根据用户访问的uri，加载该uri所需要角色列表　
	 * Object object:uri地址
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		//最初请求的uri格式:/crm/index.jsp
		// object 是一个URL ,为用户请求URL
		String url = ((FilterInvocation) object).getRequestUrl().trim();
		if ("/".equals(url)) {
			return null;
		}
		int firstQuestionMarkIndex = url.indexOf(".");
		// 判断请求是否带有参数 如果有参数就去掉后面的后缀和参数(/index.do --> /index)
		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}
		//最终形成的uri 格式:/index

		Iterator<String> ite = resourceMap.keySet().iterator();
		// 取到请求的URL后与上面取出来的资源做比较
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

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

}
