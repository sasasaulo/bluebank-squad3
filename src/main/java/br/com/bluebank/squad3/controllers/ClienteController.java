package br.com.bluebank.squad3.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

//import org.springframework.beans.factory.annotation.Autowired;
import br.com.bluebank.squad3.services.ClienteService;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService clienteService;

	@Autowired
	public
	void ClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarClientes() {
		return this.clienteService.listarClientes();
	}
	//metodo de listar por id
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		return this.clienteService.cadastrarCliente(cliente);
	}

	@PutMapping("/atualizar/{id_cliente}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id_cliente, @RequestBody @Valid Cliente cliente) throws URISyntaxException {
        return this.clienteService.atualizarCliente(id_cliente, cliente);
    }
	
	@DeleteMapping("/deletar/{id_cliente}")
	public void deletarCliente(@PathVariable Long id_cliente) {
		this.clienteService.deletarCliente((id_cliente));
	}
}
