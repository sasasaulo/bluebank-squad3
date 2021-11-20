package br.com.bluebank.squad3.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_conta;

	@Column
	private int agencia;

	@Column
	private int conta;

	@Column
	private Long saldo;

//	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
//	private List<Transacoes> transacoes = new ArrayList<>();

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

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

}
