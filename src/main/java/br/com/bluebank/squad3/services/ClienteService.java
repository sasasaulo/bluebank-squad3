package br.com.bluebank.squad3.services;

import br.com.bluebank.squad3.models.Cliente;
import br.com.bluebank.squad3.repositories.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    public ResponseEntity<Cliente> cadastrarCliente(Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    public ResponseEntity<Cliente> atualizarCliente(Long id_cliente, Cliente cliente) {
        clienteRepository.findById(id_cliente);
        cliente.setId_cliente(id_cliente);
        clienteRepository.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    public void deletarCliente(Long id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }
}
