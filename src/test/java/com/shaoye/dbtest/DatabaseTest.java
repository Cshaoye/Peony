package com.shaoye.dbtest;

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
import com.shaoye.pojo.User;
import com.shaoye.service.ITBUserService;
import com.shaoye.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DatabaseTest {
	private static Logger logger = LoggerFactory.getLogger(DatabaseTest.class);
	@Resource
	private IUserService userService = null;
	@Resource
	private ITBUserService tbUserService = null;

	@Test
	public void test1() {
		User user = userService.getUserById(3);
		if (user != null) {
			logger.info("**********"  + JSON.toJSONString(user));
		} else {
			logger.info("*****{}*****","noting get from db");
		}
	}
	
	@Test
	public void test2() {
		User user = new User();
		user.setUsername("angular");
		user.setPassword("123456");
		try {
			userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		logger.info("**********" + JSON.toJSONString(user));
	}

	@Test
	public void test3() {
		List<TBUserDto> users = tbUserService.getAllTBUser();
		for (TBUserDto user : users) {
			logger.info("[" + JSON.toJSONString(user) + "]");
		}
	}
}
