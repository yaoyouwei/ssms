package com.yaoyouwei.dto;


import com.yaoyouwei.pojo.User;

public class UserDto extends User{
    private int start;
    private int limit;
    
    
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
    
    
	
	
 
}
