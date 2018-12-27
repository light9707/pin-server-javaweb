package com.Pshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.Pshop.damian.User;
import com.Pshop.dao.UserDao;
import com.Pshop.utils.DBUtils;

public class UserDaoImpl  implements UserDao{
/**
 * 查找用户的实现方法
 */
    public User finduser(String name,String password) {
     
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       User u = null;
         try {
            conn = DBUtils.getConnection();
            //找到与浏览器中getConnection输入用户名和密码一致的sql语句，并保存在rs中
            String sql = "select * from users where username= ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2, password);

            rs = ps.executeQuery();
            while(rs.next())
            {
                //新创建一个user对象，将rs中的属性均赋值给user对象
                //如果之前的rs内容为空的话，那么此时返回的u也为null
                u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
  
            }
        } catch (Exception e) {
          e.printStackTrace();
        }finally{
         DBUtils.closeAll(rs, ps, conn);
        }     
        return u;
    }
/**
 * 添加用户的实现方法
 */
    public int adduser(User user) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i =0;
        try{
            conn = DBUtils.getConnection();
            //向数据库库表中插入一行语句如下
            String sql = "insert into users(username,password)values(?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
           //将数据更新到表中
            i =  ps.executeUpdate();
            } catch (Exception e) {
            e.printStackTrace();
            }finally{
             DBUtils.closeAll(rs, ps, conn);
            }
             return i;
    }
    public UserDaoImpl() {
        super();
   
    }    
}