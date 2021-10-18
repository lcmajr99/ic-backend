package com.sysambientes.sysambientes.controller;

import com.sysambientes.sysambientes.model.*;
import com.sysambientes.sysambientes.services.*;
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

	@Autowired
	private AtivosServiceBBAS3 ativosServiceBBAS3;

	@Autowired
	private AtivosServiceBBAS3Previsao ativosServiceBBAS3Previsao;

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
		if(transferencia.getTipo() == tipo ){
			if(transferencia.getQualAtivo().equals("petr4")) {
				Float aux = transferencia.getValor() * transferencia.getQuantidade();
				usuarioAux.setSaldo(usuarioAux.getSaldo() - aux);
				usuarioAux.setQtdAcao(usuarioAux.getQtdAcao() + transferencia.getQuantidade());
				usuarioAux.setQtdAcaoPETR4(usuarioAux.getQtdAcaoPETR4() + transferencia.getQuantidade());
				usuarioService.update(usuarioAux);
			}else{
				Float aux = transferencia.getValor() * transferencia.getQuantidade();
				usuarioAux.setSaldo(usuarioAux.getSaldo() - aux);
				usuarioAux.setQtdAcao(usuarioAux.getQtdAcao() + transferencia.getQuantidade());
				usuarioAux.setQtdAcaoBBAS3(usuarioAux.getQtdAcaoBBAS3() + transferencia.getQuantidade());
				usuarioService.update(usuarioAux);
			}
		}else{
			if(transferencia.getQualAtivo().equals("petr4")){
				Float aux = transferencia.getValor() * transferencia.getQuantidade();
				usuarioAux.setSaldo(usuarioAux.getSaldo()+aux);
				usuarioAux.setQtdAcao(usuarioAux.getQtdAcao() - transferencia.getQuantidade());
				usuarioAux.setQtdAcaoPETR4(usuarioAux.getQtdAcaoPETR4() - transferencia.getQuantidade());
				usuarioService.update(usuarioAux);
			}else{
				Float aux = transferencia.getValor() * transferencia.getQuantidade();
				usuarioAux.setSaldo(usuarioAux.getSaldo()+aux);
				usuarioAux.setQtdAcao(usuarioAux.getQtdAcao() - transferencia.getQuantidade());
				usuarioAux.setQtdAcaoBBAS3(usuarioAux.getQtdAcaoBBAS3() - transferencia.getQuantidade());
				usuarioService.update(usuarioAux);
			}

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
		AtivosBBAS3 ativosBBAS3 = ativosServiceBBAS3.findById(usuarioAux.getMomento());
		Float aux = new Float((usuarioAux.getQtdAcaoPETR4() * ativosPETR4.getValor() + usuarioAux.getQtdAcaoBBAS3() * ativosBBAS3.getValor()));

		return new ResponseEntity<>(aux, HttpStatus.OK);
	}
	@RequestMapping(value = "/resultado3/{id}", method = RequestMethod.GET)
	public ResponseEntity<Float> jogo3(@PathVariable Integer id){
		Usuario usuarioAux = usuarioService.findById(id);
		AtivosPETR4Previsao ativosPETR4Previsao = ativosServicePETR4Previsao.findById(usuarioAux.getMomento());
		AtivosBBAS3Previsao ativosBBAS3Previsao = ativosServiceBBAS3Previsao.findById(usuarioAux.getMomento());

		Float aux = new Float((usuarioAux.getQtdAcaoPETR4() * ativosPETR4Previsao.getValor() + usuarioAux.getQtdAcaoBBAS3() * ativosBBAS3Previsao.getValor()));

		return new ResponseEntity<>(aux, HttpStatus.OK);
	}



}
