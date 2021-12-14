package br.com.bluebank.squad3.models;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
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

	@Column(name = "id_contaenvia")
	private Long idcontaenvia;


	@Column(name = "contarecebe")
	private Long contarecebe;


	@Min(value=1)
	@ApiModelProperty(value = "Valor da Transação")
	@NotNull(message = "valor_transacao não pode ser nulo e nem vazio")
	@Column(name = "valor_transacao")
	private Double valor_transacao;

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
		return idcontaenvia;
	}

	public void setId_contaenvia(Long id_contaenvia) {
		this.idcontaenvia = id_contaenvia;
	}

	public Long getContarecebe() {
		return contarecebe;
	}

	public void setContarecebe(Long contarecebe) {
		this.contarecebe = contarecebe;
	}

	public Double getValor_transacao() {
		return valor_transacao;
	}

	public void setValor_transacao(Double valor_transacao) {
		this.valor_transacao = valor_transacao;
	}
}
