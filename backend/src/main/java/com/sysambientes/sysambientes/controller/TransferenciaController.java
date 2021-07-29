package com.sysambientes.sysambientes.controller;

import com.sysambientes.sysambientes.model.*;
import com.sysambientes.sysambientes.services.AtivosServicePETR4;
import com.sysambientes.sysambientes.services.AtivosServicePETR4Previsao;
import com.sysambientes.sysambientes.services.TransferenciaService;
import com.sysambientes.sysambientes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


@RestController
@RequestMapping(value = "/transferencia")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AtivosServicePETR4 ativosServicePETR4;

	@Autowired
	private AtivosServicePETR4Previsao ativosServicePETR4Previsao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Transferencia transferencia = transferenciaService.findById(id);
		return new ResponseEntity<>(transferencia, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Transferencia>> findAll() {
		List<Transferencia> transferenciaList = transferenciaService.findAll();
		return new ResponseEntity<>(transferenciaList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Transferencia transferencia) {
		transferencia = transferenciaService.create(transferencia);
		Integer idUser = transferencia.getUsuario().getId();
		Usuario usuarioAux = usuarioService.findById(idUser);

		//Manipular usuario
		Tipo tipo = Tipo.COMPRA;
		if(transferencia.getTipo() == tipo){
			Float aux = transferencia.getValor() * transferencia.getQuantidade();
			usuarioAux.setSaldo(usuarioAux.getSaldo()-aux);
			usuarioAux.setQtdAcao(usuarioAux.getQtdAcao()+ transferencia.getQuantidade());
			usuarioService.update(usuarioAux);
		}else{
			Float aux = transferencia.getValor() * transferencia.getQuantidade();
			usuarioAux.setSaldo(usuarioAux.getSaldo()+aux);
			usuarioAux.setQtdAcao(usuarioAux.getQtdAcao() - transferencia.getQuantidade());
			usuarioService.update(usuarioAux);
		}


		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "/resultado/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<BigInteger>> jogo(@PathVariable Integer id){
		List<BigInteger> bigIntegerList = transferenciaService.jogo(id);
		return new ResponseEntity<>(bigIntegerList, HttpStatus.OK);
	}

	@RequestMapping(value = "/resultado2/{id}", method = RequestMethod.GET)
	public ResponseEntity<Float> jogo2(@PathVariable Integer id){
		Usuario usuarioAux = usuarioService.findById(id);
		AtivosPETR4 ativosPETR4 = ativosServicePETR4.findById(usuarioAux.getMomento());
		Float aux = new Float((usuarioAux.getQtdAcao() * ativosPETR4.getValor()));

		return new ResponseEntity<>(aux, HttpStatus.OK);
	}
	@RequestMapping(value = "/resultado3/{id}", method = RequestMethod.GET)
	public ResponseEntity<Float> jogo3(@PathVariable Integer id){
		Usuario usuarioAux = usuarioService.findById(id);
		AtivosPETR4Previsao ativosPETR4Previsao = ativosServicePETR4Previsao.findById(usuarioAux.getMomento());
		Float aux = new Float((usuarioAux.getQtdAcao() * ativosPETR4Previsao.getValor()));

		return new ResponseEntity<>(aux, HttpStatus.OK);
	}



}
