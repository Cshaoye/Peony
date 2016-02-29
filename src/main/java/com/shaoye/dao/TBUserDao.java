package com.shaoye.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shaoye.pojo.TBUser;

/**
 * 
 * @author hufan
 *
 */
public interface TBUserDao {
	/**
	 * 新添加用户信息
	 * @param user
	 * @return
	 */
	int addTBUser(TBUser user);
	
	/**
	 * 通过用户id获取用户信息
	 * @param id
	 * @return
	 */
	TBUser getTBUserById(@Param("id") String id);
	
	/**
	 * 获取所有的用户信息
	 * @return
	 */
	List<TBUser> getAllTBUser();
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateTBUserMobileAndIdNumber(TBUser user);
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	int deleteTBUserById(@Param("id") String id);
	/**
	 * 批量修改用户信息
	 * @param users
	 */
	void batchUpdateTBUser(List<TBUser> users);
}
