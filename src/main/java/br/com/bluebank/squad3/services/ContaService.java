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

    public Conta listarPorId(Long id_conta){
        Optional<Conta> conta = contarepository.findById(id_conta);
        return conta.get();
    }

    public void alterar ( Long id_conta,Conta conta){
        contarepository.findById(id_conta);
        conta.setId_conta(id_conta);
        contarepository.save(conta);
    }
    public void deletar(Long idconta){
        contarepository.deleteById(idconta);

    }
    public Conta acharConta(Long conta){
        return contarepository.findByConta(conta);

    }
}
