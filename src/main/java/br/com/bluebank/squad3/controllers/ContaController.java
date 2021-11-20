package br.com.bluebank.squad3.controllers;

import br.com.bluebank.squad3.models.Conta;
import br.com.bluebank.squad3.repositories.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    private ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository ) {

        this.contaRepository = contaRepository;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Conta>> listarContas() {

        return ResponseEntity.ok(contaRepository.findAll());
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
    }

//	@PutMapping("/atualizar/{id_cliente}")
//	public Optional<ResponseEntity<Cliente>> atualizarNome(@PathVariable(value = "id_cliente") Long id_cliente,
//			@RequestBody Cliente nomeAtualizado) {
//		return clienteRepository.findById(id_cliente).map(nomeExistente -> {
//			nomeExistente.setNome(nomeAtualizado.getNome());
//			return Optional
//					.ofNullable(ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(nomeExistente)));
//
//		}).orElseGet(() -> {
//			return Optional.empty();
//		});
//	}

    @PutMapping("/atualizar/{id_conta}")
    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id_conta, @RequestBody @Valid Conta conta) throws URISyntaxException {
        contaRepository.findById(id_conta);
        conta.setId_conta(id_conta);
        contaRepository.save(conta);
        return new ResponseEntity<>(conta, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletar/{id_conta}")
    public void deletarConta(@PathVariable Long id_conta) {
        contaRepository.deleteById(id_conta);
    }
}
