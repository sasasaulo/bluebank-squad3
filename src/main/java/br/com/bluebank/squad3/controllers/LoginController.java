package br.com.bluebank.squad3.controllers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bluebank.squad3.models.Cliente;
import br.com.bluebank.squad3.models.Login;
import br.com.bluebank.squad3.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private LoginService loginService;

    public void LoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Login> cadastrarLogin(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.cadastrar(login));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Login>> listarLogins() {

        return ResponseEntity.ok(loginService.listar());
    }
    
    @GetMapping("/listar/{id_login}")
	public ResponseEntity<Login> listarLoginPorId(@PathVariable Long id_login) {

		return ResponseEntity.ok(loginService.listarPorId(id_login));
	}
    
    @GetMapping("/listar/credenciais/{email}/{senha}")
	public ResponseEntity<Login> verificaCredenciais(@PathVariable String email, @PathVariable String senha) {

		return ResponseEntity.ok(loginService.verificaCredenciais(email, senha));
	}

    @PutMapping("/atualizar/{id_login}")
    public ResponseEntity<Login> atualizarLogin(@PathVariable Long id_login, @RequestBody @Valid Login login) throws URISyntaxException {
        loginService.alterar(id_login, login);
        return new ResponseEntity<>(login, HttpStatus.CREATED);
    }
	@DeleteMapping("/deletar/{id_login}")
	public void deletarConta(@PathVariable Long id_login) {
        loginService.deletar(id_login);
	}

    }
