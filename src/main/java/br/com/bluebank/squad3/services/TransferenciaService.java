package br.com.bluebank.squad3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.squad3.models.Conta;
import br.com.bluebank.squad3.models.Transacoes;

import java.util.List;

@Service
public class TransferenciaService {
	@Autowired
	private ContaService contaservice;

	@Transactional
	public void Transferir(Transacoes transacao) {
		Conta contaenvia = contaservice.listarPorId((transacao.getId_contaenvia()));
		Conta contarecebedora=contaservice.acharConta(transacao.getContarecebe());

		contaenvia.setSaldo(contaenvia.getSaldo() - (transacao.getValor_transacao()));
		contarecebedora.setSaldo(contarecebedora.getSaldo() + (transacao.getValor_transacao()));
	}


}


