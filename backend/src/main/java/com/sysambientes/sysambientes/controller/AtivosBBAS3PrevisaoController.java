package com.sysambientes.sysambientes.controller;

import com.sysambientes.sysambientes.model.AtivosBBAS3Previsao;
import com.sysambientes.sysambientes.services.AtivosServiceBBAS3Previsao;
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
@RequestMapping(value = "/bbas3previsao")
public class AtivosBBAS3PrevisaoController {


	@Autowired
	private AtivosServiceBBAS3Previsao ativosServicePETR4Previsao;




	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		AtivosBBAS3Previsao ativosPETR4 = ativosServicePETR4Previsao.findById(id);
		return new ResponseEntity<>(ativosPETR4, HttpStatus.OK);
	}

	@RequestMapping(value = "/valores/{momento}", method = RequestMethod.GET)
	public ResponseEntity<List<AtivosBBAS3Previsao>> palpite(@PathVariable Integer momento) {

		ArrayList<AtivosBBAS3Previsao> ativosPETR4List = new ArrayList<AtivosBBAS3Previsao>(){{
			add(ativosServicePETR4Previsao.findById(momento));
			add(ativosServicePETR4Previsao.findById(momento+100));
		}};


		return new ResponseEntity<>(ativosPETR4List, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtivosBBAS3Previsao>> findAll() {
		List<AtivosBBAS3Previsao> ativosPETR4PrevisaoList = ativosServicePETR4Previsao.findAll();
		return new ResponseEntity<>(ativosPETR4PrevisaoList, HttpStatus.OK);
	}



	
}
