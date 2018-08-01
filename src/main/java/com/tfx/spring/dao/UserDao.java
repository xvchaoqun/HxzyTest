package com.tfx.spring.dao;

import com.tfx.spring.beans.User;

import java.util.List;

public interface UserDao {
	public void add(User u);

	public User login(String name, String password);

	public List<User> selectAll(java.sql.Date datemin, java.sql.Date datemax, String sex, String userMess);

	public boolean getUserName(String name);

	public User getUserById(int id);

	public void update(User user);

	public void deleteUser(int id);
}
