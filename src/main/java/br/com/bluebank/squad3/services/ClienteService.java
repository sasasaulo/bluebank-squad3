package br.com.bluebank.squad3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluebank.squad3.models.Cliente;
import br.com.bluebank.squad3.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/*
	 * public ClienteService (ClienteRepository clienteRepository) {
	 * this.clienteRepository = clienteRepository; }
	 */

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente listarPorId(Long id_cliente) {
		Optional<Cliente> cliente = clienteRepository.findById(id_cliente);
		return cliente.get();
	}

	public void alterar(Long id_cliente, Cliente cliente) {
		clienteRepository.findById(id_cliente);
		cliente.setId_cliente(id_cliente);
		clienteRepository.save(cliente);
	}

	/*
	 * public ResponseEntity<Cliente> atualizarCliente(Long id_cliente, Cliente
	 * cliente) { clienteRepository.findById(id_cliente);
	 * cliente.setId_cliente(id_cliente); clienteRepository.save(cliente); return
	 * new ResponseEntity<>(cliente, HttpStatus.CREATED); }
	 */

	public void deletar(long id_cliente) {
		clienteRepository.deleteById(id_cliente);
	}

}
