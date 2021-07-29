package com.sysambientes.sysambientes.services;

import com.sysambientes.sysambientes.model.AtivosBBAS3;
import com.sysambientes.sysambientes.model.AtivosPETR4;
import com.sysambientes.sysambientes.repository.AtivoBBAS3Repository;
import com.sysambientes.sysambientes.repository.AtivoPETR4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtivosServiceBBAS3 {

	@Autowired
	private AtivoBBAS3Repository ativoRepository;

	@Autowired
	private RegisterService registerService;

	public AtivosServiceBBAS3() { }

	public <S extends AtivosBBAS3> S create(S entity) {
		return entity;
	}

	public <S extends AtivosBBAS3> S update(S entity) {
		return ativoRepository.save(entity);
	}

	public void deleteById(Integer id) {
		ativoRepository.deleteById(id);
	}
	
	public AtivosBBAS3 findById(Integer id) {
		Optional<AtivosBBAS3> ativosOpt = ativoRepository.findById(id);
		return ativosOpt.orElse(null);
	}
	
	public List<AtivosBBAS3> findAll() {
		return ativoRepository.findAll();
	}
	
}
