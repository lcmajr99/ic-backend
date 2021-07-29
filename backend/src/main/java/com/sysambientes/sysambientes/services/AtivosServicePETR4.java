package com.sysambientes.sysambientes.services;

import com.sysambientes.sysambientes.model.AtivosPETR4;
import com.sysambientes.sysambientes.repository.AtivoBBAS3Repository;
import com.sysambientes.sysambientes.repository.AtivoPETR4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtivosServicePETR4 {

	@Autowired
	private AtivoPETR4Repository ativoRepository;

	@Autowired
	private RegisterService registerService;

	public AtivosServicePETR4() { }

	public <S extends AtivosPETR4> S create(S entity) {
		return entity;
	}

	public <S extends AtivosPETR4> S update(S entity) {
		return ativoRepository.save(entity);
	}

	public void deleteById(Integer id) {
		ativoRepository.deleteById(id);
	}
	
	public AtivosPETR4 findById(Integer id) {
		Optional<AtivosPETR4> ativosOpt = ativoRepository.findById(id);
		return ativosOpt.orElse(null);
	}
	
	public List<AtivosPETR4> findAll() {
		return ativoRepository.findAll();
	}
	
}
