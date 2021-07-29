package com.sysambientes.sysambientes.controller;

import com.sysambientes.sysambientes.model.AtivosPETR4;
import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.services.AtivosServicePETR4;
import com.sysambientes.sysambientes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/petr4")
public class AtivosPETR4Controller {

	@Autowired
	private AtivosServicePETR4 ativosServicePETR4;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		AtivosPETR4 ativosPETR4 = ativosServicePETR4.findById(id);
		return new ResponseEntity<>(ativosPETR4, HttpStatus.OK);
	}

	@RequestMapping(value = "/valores/{momento}", method = RequestMethod.GET)
	public ResponseEntity<List<AtivosPETR4>> palpite(@PathVariable Integer momento) {

		ArrayList<AtivosPETR4> ativosPETR4List = new ArrayList<AtivosPETR4>(){{
			add(ativosServicePETR4.findById(momento));
			add(ativosServicePETR4.findById(momento+100));
		}};


		return new ResponseEntity<>(ativosPETR4List, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtivosPETR4>> findAll() {
		List<AtivosPETR4> ativosPETR4List = ativosServicePETR4.findAll();
		return new ResponseEntity<>(ativosPETR4List, HttpStatus.OK);
	}



	
}
