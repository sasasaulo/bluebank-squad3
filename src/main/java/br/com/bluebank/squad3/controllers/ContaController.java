package br.com.bluebank.squad3.controllers;

import br.com.bluebank.squad3.models.Conta;
import br.com.bluebank.squad3.services.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Api(value = "API Rest Contas")
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/contas")
public class ContaController {
	@Autowired
	private ContaService contaservice;

	@ApiOperation("Lista todas as contas")
	@GetMapping("/listar")
	public ResponseEntity<List<Conta>> listarContas() {

		return ResponseEntity.ok(contaservice.listar());
	}

	@ApiOperation("Lista uma conta através do seu ID")
	@GetMapping("/listar/{id_conta}")
	public ResponseEntity<Conta> listarContaPorId(@PathVariable Long id_conta) {

		return ResponseEntity.ok(contaservice.listarPorId(id_conta));
	}

	@ApiOperation("Cadastra uma conta")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaservice.salvar(conta));
	}

	@ApiOperation("Atualiza uma conta")
	@PutMapping("/atualizar/{id_conta}")
	public ResponseEntity<Conta> atualizarConta(@PathVariable Long id_conta, @RequestBody @Valid Conta conta)
			throws URISyntaxException {
		contaservice.alterar(id_conta, conta);
		return new ResponseEntity<>(conta, HttpStatus.CREATED);
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

//	@ApiOperation("Deleta uma Conta")
//	@DeleteMapping("/deletar/{id_conta}")
//	public void deletarConta(@PathVariable Long id_conta) {
//		contaservice.deletar(id_conta);
//	}
}
