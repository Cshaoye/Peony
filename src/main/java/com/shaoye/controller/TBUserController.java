package com.shaoye.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author hufan
 * 
 */
@Controller
@RequestMapping(value = "/tbuser")
public class TBUserController {
	// 日志管理 当然，如果确定使用aop切面的形式进行日志管理，可以放弃该实例化
	private static Logger logger = LoggerFactory
			.getLogger(TBUserController.class);

	// spring 支持restful的格式
	@ResponseBody
	@RequestMapping(value = "/rest/{ownerId}", method = RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId, Model model,
			HttpServletResponse rep) throws IOException {
		logger.info("enter the tbuser controller..current process id is {}",
				ownerId);
		return ownerId;
	}

	@RequestMapping(value = "/rest/test", method = RequestMethod.GET)
	public String testa(Model model, HttpServletResponse rep)
			throws IOException {
		model.addAttribute("abc", "efd");
		return "a";
	}

	/**
	 * 登录入口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/rest/login", method = RequestMethod.POST)
	public String loginIn(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			HttpServletRequest request) {
		logger.info("current login name: " + username);
		logger.info("current login password: " + password);
		if (username.equals("hufan") && password.equals("123456")) {
			return "index";
		} else {
			return "login";
		}
	}
}
