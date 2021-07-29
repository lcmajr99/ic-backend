package com.sysambientes.sysambientes.controller;

import com.sysambientes.sysambientes.model.AtivosPETR4;
import com.sysambientes.sysambientes.model.AtivosPETR4Previsao;
import com.sysambientes.sysambientes.services.AtivosServicePETR4;
import com.sysambientes.sysambientes.services.AtivosServicePETR4Previsao;
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
@RequestMapping(value = "/petraprevisao")
public class AtivosPETR4PrevisaoController {

	@Autowired
	private AtivosServicePETR4 ativosServicePETR4;

	@Autowired
	private AtivosServicePETR4Previsao ativosServicePETR4Previsao;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		AtivosPETR4Previsao ativosPETR4 = ativosServicePETR4Previsao.findById(id);
		return new ResponseEntity<>(ativosPETR4, HttpStatus.OK);
	}

	@RequestMapping(value = "/valores/{momento}", method = RequestMethod.GET)
	public ResponseEntity<List<AtivosPETR4Previsao>> palpite(@PathVariable Integer momento) {

		ArrayList<AtivosPETR4Previsao> ativosPETR4List = new ArrayList<AtivosPETR4Previsao>(){{
			add(ativosServicePETR4Previsao.findById(momento));
			add(ativosServicePETR4Previsao.findById(momento+100));
		}};


		return new ResponseEntity<>(ativosPETR4List, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtivosPETR4Previsao>> findAll() {
		List<AtivosPETR4Previsao> ativosPETR4PrevisaoList = ativosServicePETR4Previsao.findAll();
		return new ResponseEntity<>(ativosPETR4PrevisaoList, HttpStatus.OK);
	}



	
}
