package br.com.bluebank.squad3.services;


import br.com.bluebank.squad3.models.Endereco;
import br.com.bluebank.squad3.repositories.EnderecoRepository;
import java.util.List;

public class EnderecoService {


    private EnderecoRepository enderecoRepository;

    public EnderecoService (EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }

    public void alterar ( long id_endereco, Endereco endereco){
        enderecoRepository.findById(id_endereco);
        endereco.setId_endereco(id_endereco);
        enderecoRepository.save(endereco);
    }

}
