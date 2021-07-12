package com.ionic.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ionic.api.enuns.StatusPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pagamento")
public  class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private StatusPagamento status;
	
	@OneToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

}
