package com.sysambientes.sysambientes.controller;

import java.math.BigDecimal;
import java.util.List;

import com.sysambientes.sysambientes.model.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.services.UsuarioService;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{email}", method = RequestMethod.GET)
	public ResponseEntity<?> findByEmail(@PathVariable String email) {
		Usuario usuario = usuarioService.findByEmail(email);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarioList = usuarioService.findAll();
		return new ResponseEntity<>(usuarioList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario usuario) {
		usuario = usuarioService.update(usuario);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Usuario usuario) {
		usuario.setSaldo(new Float(1000.0));
		usuario.setQtdAcao(0);
		usuario.setQtdAcaoPETR4(0);
		usuario.setQtdAcaoBBAS3(0);
		usuario.setMomento(1);
		usuario = usuarioService.create(usuario);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/momento", method = RequestMethod.POST)
	public ResponseEntity<Void> alterar(@RequestBody Usuario usuario){
		Usuario usuario2 = usuarioService.findById(usuario.getId());
		usuario2.setMomento(usuario.getMomento());
		usuarioService.update(usuario2);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}


	
}
