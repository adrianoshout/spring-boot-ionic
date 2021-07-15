package com.ionic.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ionic.api.enuns.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Length(min = 5, max = 80)
	private String nome;
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String cpfOuCnpj;
	private TipoCliente tipo;
	
	@JsonIgnore
	private String senha;
	
	@Builder.Default
	@OneToMany
	private List<Endereco> enderecos = new ArrayList<>();
	
	@Builder.Default
	@ElementCollection
	@CollectionTable(name = "tb_telefone")
	private Set<String> telefones = new HashSet<>();
	
	@Builder.Default
	@OneToMany
	private List<Pedido> pedidos = new ArrayList<>();

}
