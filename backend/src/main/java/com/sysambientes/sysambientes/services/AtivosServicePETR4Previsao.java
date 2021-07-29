package com.sysambientes.sysambientes.services;

import com.sysambientes.sysambientes.model.AtivosPETR4;
import com.sysambientes.sysambientes.model.AtivosPETR4Previsao;
import com.sysambientes.sysambientes.repository.AtivoPETR4PrevisaoRepository;
import com.sysambientes.sysambientes.repository.AtivoPETR4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtivosServicePETR4Previsao {

	@Autowired
	private AtivoPETR4PrevisaoRepository ativoRepository;

	@Autowired
	private RegisterService registerService;

	public AtivosServicePETR4Previsao() { }

	public <S extends AtivosPETR4Previsao> S create(S entity) {
		return entity;
	}

	public <S extends AtivosPETR4Previsao> S update(S entity) {
		return ativoRepository.save(entity);
	}

	public void deleteById(Integer id) {
		ativoRepository.deleteById(id);
	}
	
	public AtivosPETR4Previsao findById(Integer id) {
		Optional<AtivosPETR4Previsao> ativosOpt = ativoRepository.findById(id);
		return ativosOpt.orElse(null);
	}
	
	public List<AtivosPETR4Previsao> findAll() {
		return ativoRepository.findAll();
	}
	
}
