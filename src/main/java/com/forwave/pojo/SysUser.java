package com.forwave.pojo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @table sys_user
 * @creationDate 2017-05-08 00:50:15
 * @author yaoyouwei
 */
public class SysUser implements UserDetails {
	private static final long serialVersionUID = 1323234234343543L;
	private String id;
	private String loginId;
	private String name;
	private String password;
	private int delFlag;
	private Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public String getLoginId(){
		return loginId;
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
	
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
	@Override
	public String getUsername() {
		return this.loginId;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.delFlag == 0 ? true : false;
	}
	
	@Override
	public boolean equals(Object obj) {
		SysUser that = (SysUser) obj;
		return this.loginId.equals(that.loginId);
	}

	@Override
	public int hashCode() {
		return this.loginId.length();
	}

	@Override
	public String toString() {
		return this.loginId;
	}
}

/*
<resultMap id="sysUserResultMap" type="com.forwave.pojo.SysUser">
	<result property="id" column="id" />
	<result property="loginId" column="login_id" />
	<result property="name" column="name" />
	<result property="password" column="password" />
	<result property="enabled" column="enabled" />
</resultMap>
*/
