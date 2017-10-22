package com.yaoyouwei.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

	private String id;
	private Integer type;
	private String actionId;
	
	private transient  String url;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Permission{" +
			", id=" + id +
			", type=" + type +
			", actionId=" + actionId +
			"}";
	}
}
