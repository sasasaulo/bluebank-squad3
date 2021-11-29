package br.com.bluebank.squad3.models;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "cliente", uniqueConstraints = { @UniqueConstraint(columnNames = "cpf") })
public class Cliente {

	@ApiModelProperty(value = "Código do cliente")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;

	@ApiModelProperty(value = "Nome do cliente")
	@NotNull(message = "nome não pode ser nulo e nem vazio")
	@Size(max = 120)
	@Column(name = "nome")
	private String nome;

	@ApiModelProperty(value = "CPF do cliente")
	@NotNull(message = "cpf não pode ser nulo e nem vazio")
	@CPF
	@Column(name = "cpf", unique = true, nullable = false, length = 11)
	private String cpf;

	@ApiModelProperty(value = "Telefone do cliente")
	@NotNull(message = "telefone não pode ser nulo")
	@Column(name = "telefone")
	private Long telefone;

	@NotNull(message = "Endereço não pode ser nulo")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@NotNull(message = "Conta não pode ser nula")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idconta")
	private Conta conta;

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id_cliente);
//	}
//

//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Cliente other = (Cliente) obj;
//		return Objects.equals(id_cliente, other.id_cliente);
//	}

}
