package com.shaoye.dao;

import org.apache.ibatis.annotations.Param;

import com.shaoye.pojo.User;

/**
 * 
 * @author hufan
 *
 */
public interface UserDao {
	
	User getUserByUserName(@Param("username") String username);
	
	int addUser(User user);

	User getUserById(@Param("id") int id);

	void updateUser(User user);

	int deleteUserById(@Param("id") int id);
}
