package com.sysambientes.sysambientes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ativos_bbas3_previsao")
@Data
@EqualsAndHashCode()
public class AtivosBBAS3Previsao  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

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