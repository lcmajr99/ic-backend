package com.sysambientes.sysambientes.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "transferencia")
@Data
@EqualsAndHashCode(callSuper = true)
public class Transferencia extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Enumerated(EnumType.STRING)
//	private Status status;

	@Column(name = "valor")
	private Float valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private Tipo tipo;

	@Column(name = "quantidade")
	private Integer quantidade;


//________________________________

// RELACIONAMENTOS

	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "id_usuario", nullable= false)
	private Usuario usuario;





//	@ManyToMany
//	@JoinTable(name = "perfis_usuarios")
//	private List<Perfil> perfis = new ArrayList<Perfil>();

}