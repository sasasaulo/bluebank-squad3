package br.com.bluebank.squad3.services;


import br.com.bluebank.squad3.models.Endereco;
import br.com.bluebank.squad3.repositories.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EnderecoService {


    private EnderecoRepository enderecoRepository;

    public EnderecoService (EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public ResponseEntity<Endereco> cadastrarEndereco(Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
    }
    public ResponseEntity<List<Endereco>> listarEndereco() {
        return ResponseEntity.ok(enderecoRepository.findAll());
    }

    public ResponseEntity<Endereco> atualizarEndereco(Long id_endereco, Endereco endereco) {
        enderecoRepository.findById(id_endereco);
        endereco.setId_endereco(id_endereco);
        enderecoRepository.save(endereco);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

}
