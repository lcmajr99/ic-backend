package com.sysambientes.sysambientes.repository;

import com.sysambientes.sysambientes.model.AtivosPETR4;
import com.sysambientes.sysambientes.model.AtivosPETR4Previsao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtivoPETR4PrevisaoRepository extends JpaRepository<AtivosPETR4Previsao, Integer> {
	
	public Optional<AtivosPETR4Previsao> findById(Integer id);
	
	public boolean existsById(Integer id);
	
	public List<AtivosPETR4Previsao> findAll();
	
	public <S extends AtivosPETR4Previsao> S save(S entity);
	
	public void deleteById(Integer id);

}
