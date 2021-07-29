package com.sysambientes.sysambientes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "data_create")
	private Date createDate;

	@Column(name = "data_update")
	private Date updateDate;

//___________________________________________________________

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		this.createDate = atual;
		this.updateDate = atual;
	}

//___________________________________________________________

	@PreUpdate
	public void preUpdate() {
		this.updateDate = new Date();
	}

}