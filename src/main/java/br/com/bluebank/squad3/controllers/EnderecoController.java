package br.com.bluebank.squad3.controllers;

import br.com.bluebank.squad3.models.Endereco;
import br.com.bluebank.squad3.services.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {


    private EnderecoService enderecoService;

    public void EnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco) {
        return this.enderecoService.cadastrarEndereco(endereco);

    }
    @GetMapping("/listar")
    public ResponseEntity<List<Endereco>> listarEndereco() {
        return this.enderecoService.listarEndereco();
    }

}
