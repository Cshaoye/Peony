package com.shaoye.service;

import java.util.List;

import com.shaoye.dto.TBUserDto;
import com.shaoye.pojo.TBUser;
/**
 * 
 * @author hufan
 *
 */
public interface ITBUserService {
	/**
	 * 
	 * @param user
	 * @return
	 */
	public int addTBUser(TBUser user);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public TBUserDto getTBUserById(String id);
	/**
	 * 
	 * @return
	 */
	public List<TBUserDto> getAllTBUser();
	/**
	 * 这种方式是直接调用传入一个list集合，交付mybatis循环处理，
	 * 缺陷：出现异常不知到是那条数据出现错误
	 * @param TBUserDto
	 * @return
	 */
	public boolean batchUpdateTBUser(List<TBUserDto> tbUserDtos);
	/**
	 * 
	 * @param TBUserDto
	 * @return
	 */
	public List<TBUserDto> batchUpdateTBUserByLoopMethod(List<TBUserDto> tbUserDtos);
}
