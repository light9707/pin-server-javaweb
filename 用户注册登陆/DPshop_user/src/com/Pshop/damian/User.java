package com.Pshop.damian;
 //实体类包
public class User {
    private    int id;
    private    String username;
    private    String password;

 
    public User(String username, String password) {
      super();
      this.username = username;
      this.password = password;


  }    
  public User() {
      // TODO Auto-generated constructor stub
  }
  public int getId() {
      return id;
  }
  public String getUsername() {
      return username;
  }    
  public String getPassword() {
      return password;
  }

	

public void setId(int id) {
	this.id = id;
}
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password) {
	this.password = password;
}


  }    

