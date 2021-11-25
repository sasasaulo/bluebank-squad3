package br.com.bluebank.squad3.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_conta")
	private Long id_conta;

	@Column(name="agencia")
	private int agencia;

	@Column(name="conta")
	private int conta;

	@Column(name="saldo")
	private Double saldo;

	@OneToOne(mappedBy="conta")
	private Cliente cliente;

	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
	private List<Transacoes> transacoes;

	public Long getId_conta() {
		return id_conta;
	}

	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Transacoes> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacoes> transacoes) {
		this.transacoes = transacoes;
	}
}
