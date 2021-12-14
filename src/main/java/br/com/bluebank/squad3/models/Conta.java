package br.com.bluebank.squad3.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name= "conta",uniqueConstraints = { @UniqueConstraint(columnNames = "conta") })
public class Conta {

	@ApiModelProperty(value = "Código da conta")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_conta")
	private Long id_conta;

  @ApiModelProperty(value = "Agência da conta")
	@NotNull(message = "Agência não pode ser nula")
	@Column(name="agencia")
	private int agencia;

  @ApiModelProperty(value = "Número da conta")
	@NotNull(message = "Conta não pode ser nulo")
	@Column(name="conta",unique = true, nullable = false, length =6)
	private Long conta;

  @ApiModelProperty(value = "Saldo da conta")
	@Min(value=0)
	@Column(name="saldo", columnDefinition = "int default 0")
	private Double saldo;

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

	public Long getConta() {
		return conta;
	}

	public void setConta(Long conta) {
		this.conta = conta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
