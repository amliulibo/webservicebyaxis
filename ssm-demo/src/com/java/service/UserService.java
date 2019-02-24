package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.entity.User;

public interface UserService
{
	public User login(User user);
	public List<User> find(Map<String, Object> map);
	public long getTotal(Map<String, Object> map);
	public int update(User user);
	public int add(User user);
	public int delete(Integer id);
}
