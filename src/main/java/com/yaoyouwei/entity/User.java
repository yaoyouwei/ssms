package com.yaoyouwei.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 实现SpringSecurity提供的UserDetails接口
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public class User extends Model<User> implements UserDetails{

    private static final long serialVersionUID = 1L;

	private String id;
	private String loginId;
	private String name;
	private String password;
	private Integer delFlag;
	
	//用户拥有的角色
    private transient Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	//UserDetails[begin]
	@Override
	public String getUsername() {
		return this.loginId;
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
		return this.delFlag == 0 ? true : false;
	}
	
	@Override
	public boolean equals(Object obj) {
		User that = (User) obj;
		return this.loginId.equals(that.loginId);
	}

	@Override
	public int hashCode() {
		return this.loginId.length();
	}
	//UserDetails[end]
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", loginId=" + loginId +
			", name=" + name +
			", password=" + password +
			", delFlag=" + delFlag +
			"}";
	}
	
}
