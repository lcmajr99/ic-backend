package com.sysambientes.sysambientes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "usuarios")
@Data
@EqualsAndHashCode(callSuper = true)
public class Usuario extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;


	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name="momento")
	private Integer momento;

//	@Enumerated(EnumType.STRING)
//	private Status status;

	@Column(name = "password")
	private String password;

	@Column(name = "saldo")
	private Float saldo;

	@Column(name = "qtdAcao")
	private Integer qtdAcao;

	@Column(name = "qtdAcaoBBAS3")
	private Integer qtdAcaoBBAS3;

	@Column(name = "status")
	private String status;

	@Column(name = "qtdAcaoPETR4")
	private Integer qtdAcaoPETR4;
//________________________________

// RELACIONAMENTOS

//	@OneToMany
//	@JoinColumn(name = "usuario_id")
//	private List<Acesso> acessos = new ArrayList<Acesso>();

//	@ManyToMany
//	@JoinTable(name = "perfis_usuarios")
//	private List<Perfil> perfis = new ArrayList<Perfil>();

}