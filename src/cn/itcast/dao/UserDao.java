package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.User;

public interface UserDao {

	public User loginForUser(User user);

	public List<User> findAll();

}
