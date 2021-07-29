package com.sysambientes.sysambientes.services;

import com.sysambientes.sysambientes.model.Transferencia;
import com.sysambientes.sysambientes.model.Usuario;
import com.sysambientes.sysambientes.repository.TransferenciaRepository;
import com.sysambientes.sysambientes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;


	public TransferenciaService() { }


	public <S extends Transferencia> S create(S entity) {
		return transferenciaRepository.save(entity);
	}

	
	public Transferencia findById(Integer id) {
		Optional<Transferencia> usuarioOpt = transferenciaRepository.findById(id);
		return usuarioOpt.orElse(null);
	}

	
	public List<Transferencia> findAll() {
		return transferenciaRepository.findAll();
	}

	public BigInteger qtdTransacao(Integer id){
		return  transferenciaRepository.qtdTransacao(id);
	}
	public BigInteger qtdTransacaoCompra(Integer id){
		return  transferenciaRepository.qtdTransacaoCompra(id);
	}
	public BigInteger qtdTransacaoVenda(Integer id){
		return  transferenciaRepository.qtdTransacaoVenda(id);
	}

	public List<BigInteger> jogo(Integer id) {
		List<BigInteger> bigIntegerList = new ArrayList();
		bigIntegerList.add(transferenciaRepository.qtdTransacao(id));
		bigIntegerList.add(transferenciaRepository.qtdTransacaoCompra(id));
		bigIntegerList.add(transferenciaRepository.qtdTransacaoVenda(id));
		return bigIntegerList;
	}
}
