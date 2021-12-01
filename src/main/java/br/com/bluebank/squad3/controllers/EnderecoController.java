package br.com.bluebank.squad3.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.squad3.models.Endereco;
import br.com.bluebank.squad3.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API Rest Enderecos")
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;

	@ApiOperation("Cadastra um endereço")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco) {
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvar(endereco));
	}

	@ApiOperation("Lista todos os endereços")
	@GetMapping("/listar")
	public ResponseEntity<List<Endereco>> listarEnderecos() {

		return ResponseEntity.ok(enderecoService.listar());
	}

	@ApiOperation("Lista o endereço através do seu ID")
	@GetMapping("/listar/{id_endereco}")
	public ResponseEntity<Endereco> listarEnderecoPorId(@PathVariable Long id_endereco) {

		return ResponseEntity.ok(enderecoService.listarPorId(id_endereco));
	}

	@ApiOperation("Atualiza um endereço")
	@PutMapping("/atualizar/{id_endereco}")
	public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id_endereco,
			@RequestBody @Valid Endereco endereco) throws URISyntaxException {
		enderecoService.alterar(id_endereco, endereco);
		return new ResponseEntity<>(endereco, HttpStatus.CREATED);
	}

}
