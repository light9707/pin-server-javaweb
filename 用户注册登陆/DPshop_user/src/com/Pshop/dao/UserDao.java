package com.Pshop.dao;

import com.Pshop.damian.User;

public interface UserDao {
	//查找用户
	public User finduser(String name,String passwrod);
	//添加用户
    public int adduser(User user);
}
