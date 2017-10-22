package com.yaoyouwei.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
@TableName("role_user")
public class RoleUser extends Model<RoleUser> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String roleId;
	private byte[] userId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public byte[] getUserId() {
		return userId;
	}

	public void setUserId(byte[] userId) {
		this.userId = userId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RoleUser{" +
			", id=" + id +
			", roleId=" + roleId +
			", userId=" + userId +
			"}";
	}
}
