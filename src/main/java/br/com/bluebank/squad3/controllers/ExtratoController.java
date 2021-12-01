package br.com.bluebank.squad3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.squad3.models.Transacoes;
import br.com.bluebank.squad3.services.ExtratoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API Rest Extrato")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/extrato")
public class ExtratoController {
	@Autowired
	private ExtratoService extratoService;

	@ApiOperation("Lista os débitos de uma conta")
	@GetMapping("/debito/{idconta}")
	public ResponseEntity<List<Transacoes>> listarDebitos(@PathVariable Long idconta) {

		return ResponseEntity.ok(extratoService.ExtratoDebito(idconta));
	}

	@ApiOperation("Lista os créditos de uma conta")
	@GetMapping("/credito/{idconta}")
	public ResponseEntity<List<Transacoes>> listarCreditos(@PathVariable Long idconta) {

		return ResponseEntity.ok(extratoService.ExtratoCredito(idconta));
	}
}
