package br.com.bluebank.squad3.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;
import br.com.bluebank.squad3.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bluebank.squad3.models.Cliente;
import br.com.bluebank.squad3.models.Conta;


	@Api(value="API Rest Clientes")
	@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/listar")
	@ApiOperation("Lista Clientes")
	public ResponseEntity<List<Cliente>> listarClientes() {

		return ResponseEntity.ok(clienteService.listar());
	}

	@ApiOperation("Lista um Cliente")
	@GetMapping("/listar/{id_cliente}")
	public ResponseEntity<Cliente> listarClientePorId(@PathVariable Long id_cliente) {

		return ResponseEntity.ok(clienteService.listarPorId(id_cliente));
	}

	@ApiOperation("Cria um Cliente")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> cadastrarConta(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
	}

	@ApiOperation("Atualiza um Cliente")
	@PutMapping("/atualizar/{id_cliente}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id_cliente, @RequestBody @Valid Cliente cliente)
			throws URISyntaxException {
		clienteService.alterar(id_cliente, cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}

//	@ApiOperation("Deleta um Cliente")
//	@DeleteMapping("/deletar/{id_cliente}")
//	public void deletarCliente(@PathVariable Long id_cliente) {
//		clienteService.deletar((id_cliente));
//	}
}
