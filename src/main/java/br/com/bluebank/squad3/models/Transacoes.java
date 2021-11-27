package br.com.bluebank.squad3.models;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transacoes")
public class Transacoes {

	@ApiModelProperty(value = "Código da Transação")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transacoes")
	private Long id_transacoes;

	@ApiModelProperty(value = "Data da Transação")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	/*
	 * @NotNull(message = "tipo_transacao não pode ser nulo e nem vazio")
	 * 
	 * @Column(name = "tipo_transacao") private String tipo_transacao;
	 */

	@Column(name = "id_contaenvia")
	private Long id_contaenvia;


	@Column(name = "id_contarecebe")
	private Long id_contarecebe;

	@ApiModelProperty(value = "Valor da Transação")
	@NotNull(message = "valor_transacao não pode ser nulo e nem vazio")
	@Column(name = "valor_transacao")
	private Double valor_transacao;

	/*
	 * @ManyToOne private Conta conta;
	 */

	public Long getId_transacoes() {
		return id_transacoes;
	}

	public void setId_transacoes(Long id_transacoes) {
		this.id_transacoes = id_transacoes;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId_contaenvia() {
		return id_contaenvia;
	}

	public void setId_contaenvia(Long id_contaenvia) {
		this.id_contaenvia = id_contaenvia;
	}

	public Long getId_contarecebe() {
		return id_contarecebe;
	}

	public void setId_contarecebe(Long id_contarecebe) {
		this.id_contarecebe = id_contarecebe;
	}

	public Double getValor_transacao() {
		return valor_transacao;
	}

	public void setValor_transacao(Double valor_transacao) {
		this.valor_transacao = valor_transacao;
	}

	/*
	 * public Transacoes() { }
	 * 
	 * public Transacoes(@NotNull @NotBlank String tipo_transacao) {
	 * this.tipo_transacao = tipo_transacao; }
	 */

}
