package com.tfx.spring.service.impl;

import com.tfx.spring.beans.User;
import com.tfx.spring.dao.UserDao;
import com.tfx.spring.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public void add(User user) {
		userDao.add(user);
	}
	@Override
	public User login(String name, String password) {
		return userDao.login(name,password);
	}
	@Override
	public List<User> selectAll(java.sql.Date datemin, java.sql.Date datemax, String sex, String userMess) {
		return userDao.selectAll(datemin,datemax,sex,userMess);
	}
	@Override
	public boolean getUserName(String name) {
		return userDao.getUserName(name);
	}
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
}
