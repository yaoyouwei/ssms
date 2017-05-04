package com.forwave.pojo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @table sys_user
 * @creationDate 2017-05-01 19:24:11
 * @author yaoyouwei
 */
public class SysUser implements UserDetails{
	private static final long serialVersionUID = 185451514154L;
	private String id;
	private String name;
	private String password;
	private int enabled;
	private Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setEnabled(int enabled){
		this.enabled=enabled;
	}
	public int getEnabled(){
		return enabled;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	@Override
	public String getUsername() {
		return this.name;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled==1?true:false;
	}
	
	@Override
	public boolean equals(Object obj) {
		SysUser that = (SysUser) obj;
		return this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return this.name.length();
	}

	@Override
	public String toString() {
		return this.name;
	}
}

/*
<resultMap id="sysUserResultMap" type="com.forwave.pojo.SysUser">
	<result property="id" column="id" />
	<result property="name" column="name" />
	<result property="password" column="password" />
	<result property="enabled" column="enabled" />
</resultMap>
*/
