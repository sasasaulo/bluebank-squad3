package br.com.bluebank.squad3.controllers;

import br.com.bluebank.squad3.models.Endereco;
import br.com.bluebank.squad3.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Api(value="API Rest Enderecos")
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    public void EnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @ApiOperation("Cadastra um Endereço")
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvar(endereco));
    }

    @ApiOperation("Lista Endereços")
    @GetMapping("/listar")
    public ResponseEntity<List<Endereco>> listarEnderecos() {

        return ResponseEntity.ok(enderecoService.listar());
    }

    @ApiOperation("Atualiza um Endereço")
    @PutMapping("/atualizar/{id_endereco}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id_endereco, @RequestBody @Valid Endereco endereco) throws URISyntaxException {
        enderecoService.alterar(id_endereco, endereco);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

}
