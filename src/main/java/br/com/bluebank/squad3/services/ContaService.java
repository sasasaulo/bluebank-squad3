package br.com.bluebank.squad3.services;

import br.com.bluebank.squad3.models.Conta;
import br.com.bluebank.squad3.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contarepository;

    public Conta salvar(Conta conta) {
        return contarepository.save(conta);
    }

    public List<Conta> listar() {
        return contarepository.findAll();
    }

    public Conta listarporId(long idconta){
        Optional<Conta> conta = contarepository.findById(idconta);
        return conta.get();
    }

    public void alterar ( long idconta,Conta conta){
        contarepository.findById(idconta);
        conta.setId_conta(idconta);
        contarepository.save(conta);
    }
    public void deletar(long idconta){
        contarepository.deleteById(idconta);

    }
}
