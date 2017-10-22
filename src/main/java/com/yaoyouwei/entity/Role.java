package com.yaoyouwei.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yaoyouwei
 * @since 2017-10-22
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String name;
    /**
     * 对应SpringSecurity
     */
	private String roleSecurity;
	private Integer enabled;
	private String description;
	private Date lastUpdateDate;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleSecurity() {
		return roleSecurity;
	}

	public void setRoleSecurity(String roleSecurity) {
		this.roleSecurity = roleSecurity;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Role{" +
			", id=" + id +
			", name=" + name +
			", roleSecurity=" + roleSecurity +
			", enabled=" + enabled +
			", description=" + description +
			", lastUpdateDate=" + lastUpdateDate +
			"}";
	}
}
