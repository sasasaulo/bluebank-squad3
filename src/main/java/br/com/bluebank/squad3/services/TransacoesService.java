package br.com.bluebank.squad3.services;

import java.util.List;
import java.util.Optional;

import br.com.bluebank.squad3.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluebank.squad3.models.Transacoes;
import br.com.bluebank.squad3.repositories.TransacoesRepository;

@Service
public class TransacoesService {
	@Autowired
	private TransacoesRepository transacaoRepository;

	public Transacoes salvar(Transacoes transacoes) {
		return transacaoRepository.save(transacoes);
	}

	public List<Transacoes> listar() {
		return transacaoRepository.findAll();
	}

	public Transacoes listarporId(long id_transacoes) {
		Optional<Transacoes> transacao = transacaoRepository.findById(id_transacoes);
		return transacao.get();
	}

	public void alterar(long id_transacoes, Transacoes transacoes) {
		transacaoRepository.findById(id_transacoes);
		transacoes.setId_transacoes(id_transacoes);
		transacaoRepository.save(transacoes);
	}

	public void deletar(long id_transacoes) {
		transacaoRepository.deleteById(id_transacoes);

	}
	public List<Transacoes> PegarTransacoesContaDebito(Long idconta){
		return transacaoRepository.findByidcontaenvia(idconta);
	}
	public List<Transacoes> PegarTransacoesContaCredito(Long conta){
		return transacaoRepository.findBycontarecebe(conta);
	}

}
