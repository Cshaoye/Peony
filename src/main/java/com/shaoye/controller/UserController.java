package com.shaoye.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shaoye.pojo.User;
import com.shaoye.service.IUserService;

/**
 * 
 * @author hufan
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static Log log = LogFactory.getLog(UserController.class);
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/index")
	public String indexPage() {
		log.info("enter the index page");
		return "/user/index";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		log.info("enter the login page");
		return "/user/login";
	}

	@RequestMapping(value = "/register")
	public String registerPage() {
		log.info("enter the register page");
		return "/user/register";
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean result = userService.getUserByUserName(user);
		if(!result) {
			model.setViewName("/user/fail");
			model.addObject("user", user);
			return model;
		}
		model.setViewName("/user/success");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "doRegister")
	public ModelAndView doRegister(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email) {
		ModelAndView model = new ModelAndView();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return model;
	}

	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public ModelAndView gainUserById(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.getUserById(id);
		if (user != null) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("/user/message");
		} else {
			modelAndView.setViewName("/user/index");
		}
		return modelAndView;
	}
}
