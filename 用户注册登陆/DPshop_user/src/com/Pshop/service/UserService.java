package com.Pshop.service;

import com.Pshop.damian.User;

public interface UserService {
//实现登陆
	public User login(String name,String pwd);
	
	//注册
	public int register(User user);
}
