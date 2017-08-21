package com.yaoyouwei.pojo;
import java.util.Date;

/**
 * @table sys_role
 * @creationDate 2017-05-01 19:24:11
 * @author yaoyouwei
 */
public class SysRole{
	private String id;
	private String name;
	private String roleSecurity;
	private int enabled;
	private String description;
	private Date lastUpdateDate;
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
	public void setRoleSecurity(String roleSecurity){
		this.roleSecurity=roleSecurity;
	}
	public String getRoleSecurity(){
		return roleSecurity;
	}
	public void setEnabled(int enabled){
		this.enabled=enabled;
	}
	public int getEnabled(){
		return enabled;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setLastUpdateDate(Date lastUpdateDate){
		this.lastUpdateDate=lastUpdateDate;
	}
	public Date getLastUpdateDate(){
		return lastUpdateDate;
	}
}

/*
<resultMap id="sysRoleResultMap" type="com.forwave.pojo.SysRole">
	<result property="id" column="id" />
	<result property="name" column="name" />
	<result property="roleSecurity" column="role_security" />
	<result property="enabled" column="enabled" />
	<result property="description" column="description" />
	<result property="lastUpdateDate" column="last_update_date" />
</resultMap>
*/
