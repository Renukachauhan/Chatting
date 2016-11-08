package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
public boolean save(User user);
public boolean update(User user);
public User get(String userId);
public User validate(String userId,String password);
public List<User> getAllUsers();
}
