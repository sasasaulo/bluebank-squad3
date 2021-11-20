package br.com.bluebank.squad3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}

	@PutMapping("{id_cliente}")
	public Optional<ResponseEntity<Cliente>> atualizarNome(@PathVariable(value = "id_cliente") Long id_cliente,
			@RequestBody Cliente nomeAtualizado) {
		return clienteRepository.findById(id_cliente).map(nomeExistente -> {
			nomeExistente.setNome(nomeAtualizado.getNome());
			return Optional
					.ofNullable(ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(nomeExistente)));

		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	@DeleteMapping("{id_cliente}")
	public void deletarCliente(@PathVariable Long id_cliente) {
		clienteRepository.deleteById(id_cliente);
	}

}
