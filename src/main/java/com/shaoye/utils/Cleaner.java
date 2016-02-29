package com.shaoye.utils;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.shaoye.dto.TBUserDto;
import com.shaoye.service.ITBUserService;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Cleaner {
	private static Logger logger = LoggerFactory.getLogger(Cleaner.class);

	@Resource
	private ITBUserService tbUserService = null;

	@Test
	public void cleanTBUser() {
		List<TBUserDto> users = tbUserService.getAllTBUser();
		List<TBUserDto> unUpdateUser = tbUserService
				.batchUpdateTBUserByLoopMethod(users);
		if (unUpdateUser.isEmpty()) {
			logger.info("恭喜您，没有未被处理的用户！");
		}
		for (TBUserDto user : unUpdateUser) {
			logger.info("[" + JSON.toJSONString(user) + "]");
		}
	}
}
