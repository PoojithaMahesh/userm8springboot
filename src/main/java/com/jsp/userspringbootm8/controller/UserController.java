package com.jsp.userspringbootm8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userspringbootm8.dao.UserDao;
import com.jsp.userspringbootm8.dto.User;

@RestController
public class UserController {
	@Autowired
	private UserDao dao;

	public void saveUser(@RequestBody User user) {

	}

}
