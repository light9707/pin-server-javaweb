package com.Pshop.service.impl;

import com.Pshop.damian.User;
import com.Pshop.dao.UserDao;
import com.Pshop.dao.impl.UserDaoImpl;
import com.Pshop.service.UserService;

public class UserServiceImpl  implements UserService{  
      // 实现用户登录的方法
    public User login(String name,String pwd) {

     //用实现类来指向父类的接口
         UserDao dao = (UserDao) new  UserDaoImpl();
         return  dao.finduser(name,pwd);
    }
    public int register(User user) {
   
         UserDao dao = (UserDao) new  UserDaoImpl();
         return  dao.adduser(user);
    }
}