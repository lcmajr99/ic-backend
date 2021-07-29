package com.sysambientes.sysambientes.repository;

import com.sysambientes.sysambientes.model.Transferencia;
import com.sysambientes.sysambientes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
	
	public Optional<Transferencia> findById(Integer id);
	
	public boolean existsById(Integer id);
	
	public List<Transferencia> findAll();
	
	public <S extends Transferencia> S save(S entity);
	
	public void deleteById(Integer id);


	@Query(value = "SELECT count(*) FROM transferencia WHERE id_usuario = :id", nativeQuery = true)
	public BigInteger qtdTransacao(@Param("id") Integer id);

	@Query(value = "SELECT count(*) FROM transferencia WHERE id_usuario = :id AND tipo= 'COMPRA'", nativeQuery = true)
	BigInteger qtdTransacaoCompra(@Param("id") Integer id);

	@Query(value = "SELECT count(*) FROM transferencia WHERE id_usuario = :id AND tipo= 'VENDA'", nativeQuery = true)
	BigInteger qtdTransacaoVenda(@Param("id") Integer id);


}
