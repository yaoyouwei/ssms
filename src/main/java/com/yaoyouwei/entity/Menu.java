package com.yaoyouwei.entity;

import java.io.Serializable;

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
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 父菜单
     */
	private String pid;
    /**
     * 菜单名称
     */
	private String text;
    /**
     * 菜单url
     */
	private String url;
    /**
     * 是否是叶子节点
     */
	private Integer leaf;
    /**
     * 菜单样式
     */
	private String iconCls;
    /**
     * 菜单排序
     */
	private Integer order;
    /**
     * 是否可见
     */
	private Integer visible;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getLeaf() {
		return leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Menu{" +
			", id=" + id +
			", pid=" + pid +
			", text=" + text +
			", url=" + url +
			", leaf=" + leaf +
			", iconCls=" + iconCls +
			", order=" + order +
			", visible=" + visible +
			"}";
	}
}
