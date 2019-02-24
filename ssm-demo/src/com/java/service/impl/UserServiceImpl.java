package com.java.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.service.UserService;



@Service("userService")
public class UserServiceImpl implements  UserService
{
	@Resource
	private UserDao userDao;

	@Override
	public User login(User user)
	{
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public List<User> find(Map<String, Object> map)
	{
		// TODO Auto-generated method stub
		return userDao.find(map);
	}

	@Override
	public long getTotal(Map<String, Object> map)
	{
		// TODO Auto-generated method stub
		return userDao.getTotal(map);
	}

	@Override
	public int update(User user)
	{
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public int add(User user)
	{
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	@Override
	public int delete(Integer id)
	{
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}
}
