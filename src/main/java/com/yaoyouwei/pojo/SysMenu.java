package com.yaoyouwei.pojo;

/**
 * @table sys_menu
 * @creationDate 2017-06-18 21:07:26
 * @author yaoyouwei
 */
public class SysMenu{
	private String id;
	private String pid;
	private String text;
	private String url;
	private int leaf;
	private String iconCls;
	private int order;
	private int visible;
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setPid(String pid){
		this.pid=pid;
	}
	public String getPid(){
		return pid;
	}
	public void setText(String text){
		this.text=text;
	}
	public String getText(){
		return text;
	}
	public void setUrl(String url){
		this.url=url;
	}
	public String getUrl(){
		return url;
	}
	public int getLeaf() {
		return leaf;
	}
	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}
	public void setIconCls(String iconCls){
		this.iconCls=iconCls;
	}
	public String getIconCls(){
		return iconCls;
	}
	public void setOrder(int order){
		this.order=order;
	}
	public int getOrder(){
		return order;
	}
	public void setVisible(int visible){
		this.visible=visible;
	}
	public int getVisible(){
		return visible;
	}
}


