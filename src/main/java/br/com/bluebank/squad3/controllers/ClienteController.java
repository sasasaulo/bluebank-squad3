package br.com.bluebank.squad3.controllers;

import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.squad3.models.Cliente;
import br.com.bluebank.squad3.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

//	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	@GetMapping(value = "listar/{id_cliente}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id_cliente) {
		return ResponseEntity.ok(clienteRepository.findById(id_cliente).get());
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
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

	@PutMapping("/atualizar/{id_cliente}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id_cliente, @RequestBody @Valid Cliente cliente)
			throws URISyntaxException {
		clienteRepository.findById(id_cliente);
		cliente.setId_cliente(id_cliente);
		clienteRepository.save(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}

	@DeleteMapping("/deletar/{id_cliente}")
	public void deletarCliente(@PathVariable Long id_cliente) {
		clienteRepository.deleteById(id_cliente);
	}

}
