package com.shaoye.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shaoye.dao.TBUserDao;
import com.shaoye.dto.TBUserDto;
import com.shaoye.pojo.TBUser;
import com.shaoye.service.ITBUserService;
import com.shaoye.utils.DtoConverter;

public class TBUserServiceImpl implements ITBUserService {

	@Autowired
	private TBUserDao tbUserDao;

	@Override
	public int addTBUser(TBUser user) {
		return tbUserDao.addTBUser(user);
	}

	@Override
	public TBUserDto getTBUserById(String id) {
		return DtoConverter.getTBUserDto(tbUserDao.getTBUserById(id));
	}

	@Override
	public List<TBUserDto> getAllTBUser() {
		List<TBUserDto> userDtos = new ArrayList<TBUserDto>();
		List<TBUser> users = tbUserDao.getAllTBUser();
		for (TBUser user : users) {
			userDtos.add(DtoConverter.getTBUserDto(user));
		}
		return userDtos;
	}

	@Override
	public boolean batchUpdateTBUser(List<TBUserDto> tbUserDtos) {
		boolean result = true;
		List<TBUser> users = null;
		if (tbUserDtos != null && !tbUserDtos.isEmpty()) {
			users = new ArrayList<TBUser>();
		} else {
			return false;
		}
		for (TBUserDto dto : tbUserDtos) {
			users.add(DtoConverter.getTBUser(dto));
		}
		try {
			tbUserDao.batchUpdateTBUser(users);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TBUserDto> batchUpdateTBUserByLoopMethod(
			List<TBUserDto> tbUserDtos) {
		List<TBUserDto> unUpdateTBUser = new ArrayList<TBUserDto>();
		for (TBUserDto dto : tbUserDtos) {
			try {
				tbUserDao.updateTBUserMobileAndIdNumber(DtoConverter
						.getTBUser(dto));
			} catch (Exception e) {
				unUpdateTBUser.add(dto);
				throw e;
			}
		}
		return unUpdateTBUser;
	}
}
