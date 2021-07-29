package com.sysambientes.sysambientes.repository;

import com.sysambientes.sysambientes.model.AtivosBBAS3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtivoBBAS3Repository extends JpaRepository<AtivosBBAS3, Integer> {
	
	public Optional<AtivosBBAS3> findById(Integer id);
	
	public boolean existsById(Integer id);
	
	public List<AtivosBBAS3> findAll();
	
	public <S extends AtivosBBAS3> S save(S entity);
	
	public void deleteById(Integer id);

}
