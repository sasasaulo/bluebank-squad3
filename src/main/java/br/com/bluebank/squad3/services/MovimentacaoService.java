package br.com.bluebank.squad3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.squad3.models.Conta;
import br.com.bluebank.squad3.models.Transacoes;

@Service
public class MovimentacaoService {
	@Autowired
	private ContaService contaservice;
	/*
	 * @Autowired private TransacoesService transacoesService;
	 */

	@Transactional
	public void Transferir(Transacoes transacoes) {
		// achar conta envia pelos ids
		Conta contaenvia = contaservice.listarPorId(transacoes.getId_contaenvia());
		Conta contarecebedora = contaservice.listarPorId(transacoes.getId_contarecebe());
		// fazer a transferencia
		contaenvia.setSaldo(contaenvia.getSaldo() - (transacoes.getValor_transacao()));
		contarecebedora.setSaldo(contarecebedora.getSaldo() + (transacoes.getValor_transacao()));
	}
}

// metodo para na hora que dar o get pegar as transacoes tb da conta
// get um por id, vem uma conta, vamos fazer esse por enquanto
//    public void PegarTransacoesConta(Conta conta){
//        Long idconta=conta.getIdconta();
//        //ver todas transacoes Loop por ele tudo
//        transacaoservice.listar();

// Se
// transacoes com idcontaenvia igual a id conta
// retorna essas transacoes como debito
// Se transacoes com idcontarecebedora igual a id conta
// retorna essas transacoes como credito
//        if(idconta== transacao.getIdcontaenvia()){
//            return transacao;
//        }
//        if(idconta== transacao.getIdcontaenvia()){
//            return transacao;
//        }
