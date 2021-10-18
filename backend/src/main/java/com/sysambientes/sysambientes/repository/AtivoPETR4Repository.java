package com.sysambientes.sysambientes.repository;

import com.sysambientes.sysambientes.model.AtivosBBAS3;
import com.sysambientes.sysambientes.model.AtivosPETR4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface AtivoPETR4Repository extends JpaRepository<AtivosPETR4, Integer> {
	
	public Optional<AtivosPETR4> findById(Integer id);

	@Query(value = "SELECT * FROM ativos_petr4 WHERE ativos_petr4.id = :id", nativeQuery = true)
	public AtivosPETR4 qtdTransacao(@Param("id") Integer id);
	
	public boolean existsById(Integer id);
	
	public List<AtivosPETR4> findAll();
	
	public <S extends AtivosPETR4> S save(S entity);
	
	public void deleteById(Integer id);

}
