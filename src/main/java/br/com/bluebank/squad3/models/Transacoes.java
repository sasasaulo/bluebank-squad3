package br.com.bluebank.squad3.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transacoes")
public class Transacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_transacoes;

	private String tipo_transacao;

	private Double valor_transacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Long getId_transacoes() {
		return id_transacoes;
	}

	public void setId_transacoes(Long id_transacoes) {
		this.id_transacoes = id_transacoes;
	}

	public String getTipo_transacao() {
		return tipo_transacao;
	}

	public void setTipo_transacao(String tipo_transacao) {
		this.tipo_transacao = tipo_transacao;
	}

	public Double getValor_transacao() {
		return valor_transacao;
	}

	public void setValor_transacao(Double valor_transacao) {
		this.valor_transacao = valor_transacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
