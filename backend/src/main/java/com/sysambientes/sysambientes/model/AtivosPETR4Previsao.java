package com.sysambientes.sysambientes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ativos_petr4_previsao")
@Data
@EqualsAndHashCode(callSuper = true)
public class AtivosPETR4Previsao extends EntityBase implements Serializable {


	@Column(name = "horario")
	private Date horario;

	@Column(name = "valor")
	private Float valor;

//________________________________

// RELACIONAMENTOS

//	@OneToMany
//	@JoinColumn(name = "usuario_id")
//	private List<Acesso> acessos = new ArrayList<Acesso>();

//	@ManyToMany
//	@JoinTable(name = "perfis_usuarios")
//	private List<Perfil> perfis = new ArrayList<Perfil>();

}