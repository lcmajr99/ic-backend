package com.sysambientes.sysambientes.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.sysambientes.sysambientes.model.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.criterion.DetachedCriteria;


import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RegisterService registerService;

	public UsuarioService() { }
	
	
	public <S extends Usuario> S create(S entity) {
		registerService.register(entity);
		return entity;
	}

	public <S extends Usuario> S update(S entity) {
		return usuarioRepository.save(entity);
	}
	
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		return usuarioOpt.orElse(null);
	}

	public Usuario findByEmail(String email) {
		Usuario usuarioOpt = usuarioRepository.findByEmail(email);
		return usuarioOpt;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}





}
