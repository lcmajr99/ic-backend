package com.sysambientes.sysambientes.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysambientes.sysambientes.exceptions.SysambientesException;
import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.repository.UsuarioRepository;

@Service
public class LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public LoginService() { }
	
	
	public Usuario login(Map<String, String> login) {
		String email = login.get("email");
		String password = login.get("password");

		Usuario usuario = usuarioRepository.findByEmailAndPassword(email, password);
		
		if (usuario != null) return usuario;
		else throw new SysambientesException("Email ou Senha incorretos.");
	}
	
}
