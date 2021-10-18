package com.sysambientes.sysambientes.services;

import com.sysambientes.sysambientes.model.AtivosBBAS3Previsao;
import com.sysambientes.sysambientes.repository.AtivoBBAS3PrevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtivosServiceBBAS3Previsao {

	@Autowired
	private AtivoBBAS3PrevisaoRepository ativoRepository2;


	public AtivosServiceBBAS3Previsao() { }


	public void deleteById(Integer id) {
		ativoRepository2.deleteById(id);
	}
	
	public AtivosBBAS3Previsao findById(Integer id) {
		Optional<AtivosBBAS3Previsao> ativosOpt3 = ativoRepository2.findById(id);
		return ativosOpt3.orElse(null);
	}
	
	public List<AtivosBBAS3Previsao> findAll() {
		return ativoRepository2.findAll();
	}
	
}
