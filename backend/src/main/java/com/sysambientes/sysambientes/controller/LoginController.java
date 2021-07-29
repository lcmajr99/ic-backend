package com.sysambientes.sysambientes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.services.LoginService;


@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	

	@RequestMapping(method = RequestMethod.POST)
	public Usuario login(@RequestBody Map<String, String> login) {
		return loginService.login(login);
	}
	
}
