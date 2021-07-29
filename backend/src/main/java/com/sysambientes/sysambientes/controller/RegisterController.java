package com.sysambientes.sysambientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.services.RegisterService;


@RestController
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	

	@RequestMapping(method = RequestMethod.POST)
	public void login(@RequestBody Usuario usuario) {
		registerService.register(usuario);
	}
	
}
