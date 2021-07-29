package com.sysambientes.sysambientes.controller;

import com.sysambientes.sysambientes.model.AtivosBBAS3;
import com.sysambientes.sysambientes.model.AtivosPETR4;
import com.sysambientes.sysambientes.services.AtivosServiceBBAS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/bbas3")
public class AtivosBBAS3Controller {

	@Autowired
	private AtivosServiceBBAS3 ativosServiceBBAS3;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		AtivosBBAS3 ativosBBAS3 = ativosServiceBBAS3.findById(id);
		return new ResponseEntity<>(ativosBBAS3, HttpStatus.OK);
	}

	@RequestMapping(value = "/valores/{momento}", method = RequestMethod.GET)
	public ResponseEntity<List<AtivosBBAS3>> palpite(@PathVariable Integer momento) {

		ArrayList<AtivosBBAS3> AtivosBBAS3list = new ArrayList<AtivosBBAS3>(){{
			add(ativosServiceBBAS3.findById(momento));
			add(ativosServiceBBAS3.findById(momento+100));
		}};


		return new ResponseEntity<>(AtivosBBAS3list, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtivosBBAS3>> findAll() {
		List<AtivosBBAS3> AtivosBBAS3list = ativosServiceBBAS3.findAll();
		return new ResponseEntity<>(AtivosBBAS3list, HttpStatus.OK);
	}



	
}
