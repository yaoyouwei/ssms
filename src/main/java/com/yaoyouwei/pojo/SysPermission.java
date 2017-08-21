package com.yaoyouwei.pojo;

/**
 * @table sys_permission
 * @creationDate 2017-05-07 09:45:13
 * @author yaoyouwei
 */
public class SysPermission{
	private String id;
	private int type;
	private String actionId;
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getType(){
		return type;
	}
	public void setActionId(String actionId){
		this.actionId=actionId;
	}
	public String getActionId(){
		return actionId;
	}
}

/*
<resultMap id="sysPermissionResultMap" type="com.forwave.pojo.SysPermission">
	<result property="id" column="id" />
	<result property="type" column="type" />
	<result property="actionId" column="action_id" />
</resultMap>
*/
