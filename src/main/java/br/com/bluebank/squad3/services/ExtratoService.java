package br.com.bluebank.squad3.services;

import br.com.bluebank.squad3.models.Conta;
import br.com.bluebank.squad3.models.Transacoes;
import br.com.bluebank.squad3.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtratoService {
    @Autowired
    private TransacoesService transacaoService;
    @Autowired
    private ContaService contaservice;

    public List<Transacoes> ExtratoDebito(Long idconta){
        return transacaoService.PegarTransacoesContaDebito(idconta);
    }
    public List<Transacoes> ExtratoCredito(Long idconta){
        Conta contarecebedora=contaservice.listarPorId(idconta);
        return transacaoService.PegarTransacoesContaCredito(contarecebedora.getConta());
    }
}
