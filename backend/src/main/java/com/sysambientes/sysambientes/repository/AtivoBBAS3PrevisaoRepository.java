package com.sysambientes.sysambientes.repository;

import com.sysambientes.sysambientes.model.AtivosBBAS3Previsao;
import com.sysambientes.sysambientes.model.AtivosPETR4Previsao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtivoBBAS3PrevisaoRepository extends JpaRepository<AtivosBBAS3Previsao, Integer> {
	
	public Optional<AtivosBBAS3Previsao> findById(Integer id);
	
	public boolean existsById(Integer id);
	
	public List<AtivosBBAS3Previsao> findAll();
	
	public <S extends AtivosBBAS3Previsao> S save(S entity);
	
	public void deleteById(Integer id);

}
