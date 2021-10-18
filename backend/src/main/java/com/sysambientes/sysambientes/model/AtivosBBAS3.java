package com.sysambientes.sysambientes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ativos_bbas3")
@Data
@EqualsAndHashCode()
public class AtivosBBAS3 implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "horario")
	private String horario;

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