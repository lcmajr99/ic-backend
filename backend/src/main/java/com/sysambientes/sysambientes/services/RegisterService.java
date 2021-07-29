package com.sysambientes.sysambientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysambientes.sysambientes.exceptions.SysambientesException;
import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.repository.UsuarioRepository;

@Service
public class RegisterService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public RegisterService() { }
	
	
	public void register(Usuario usuario) {
		if (usuarioRepository.findByEmail(usuario.getEmail()) != null) throw new SysambientesException("Já existe um usuário cadastrado com esse email.");
		else  usuarioRepository.save(usuario);
	}
	
}
