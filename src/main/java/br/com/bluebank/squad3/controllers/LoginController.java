package br.com.bluebank.squad3.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

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

import br.com.bluebank.squad3.models.Login;
import br.com.bluebank.squad3.services.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API Rest Login")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	public void LoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@ApiOperation("Cadastra o login (cliente completo)")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Login> cadastrarLogin(@RequestBody Login login) {
		return ResponseEntity.status(HttpStatus.CREATED).body(loginService.cadastrar(login));
	}

	@ApiOperation("Lista todos os logins")
	@GetMapping("/listar")
	public ResponseEntity<List<Login>> listarLogins() {

		return ResponseEntity.ok(loginService.listar());
	}

	@ApiOperation("Lista o login através do seu ID")
	@GetMapping("/listar/{id_login}")
	public ResponseEntity<Login> listarLoginPorId(@PathVariable Long id_login) {

		return ResponseEntity.ok(loginService.listarPorId(id_login));
	}

	@ApiOperation("Verifica se senha e e-mail são válidos")
	@GetMapping("/listar/credenciais/{email}/{senha}")
	public ResponseEntity<Login> verificarCredenciais(@PathVariable String email, @PathVariable String senha) {

		return ResponseEntity.ok(loginService.verificaCredenciais(email, senha));
	}

	@ApiOperation("Atualiza o login")
	@PutMapping("/atualizar/{id_login}")
	public ResponseEntity<Login> atualizarLogin(@PathVariable Long id_login, @RequestBody @Valid Login login)
			throws URISyntaxException {
		loginService.alterar(id_login, login);
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}

	@ApiOperation("Deleta o login (cliente completo)")
	@DeleteMapping("/deletar/{id_login}")
	public void deletarLogin(@PathVariable Long id_login) {
		loginService.deletar(id_login);
	}
}
