package br.com.bluebank.squad3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.squad3.models.Transacoes;
import br.com.bluebank.squad3.services.TransacoesService;
import br.com.bluebank.squad3.services.TransferenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API Rest Transações")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

	@Autowired
	private TransacoesService transacoesService;

	@Autowired
	private TransferenciaService transferenciaService;

	@ApiOperation("Efetua uma transação")
	@PostMapping("/efetuar")
	public void efetuarTransacao(@RequestBody Transacoes transacoes) {
		transacoesService.salvar(transacoes);
		transferenciaService.Transferir(transacoes);
	}

	@ApiOperation("Lista todas as transações")
	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public ResponseEntity<List<Transacoes>> listarTransacoes() {
		return ResponseEntity.ok(transacoesService.listar());
	}

	@ApiOperation("Lista uma transação através do seu ID")
	@GetMapping("buscar/{id_transacao}")
	public ResponseEntity<Transacoes> buscarTransacaoPorId(@PathVariable Long id_transacao) {
		return ResponseEntity.ok(transacoesService.listarporId(id_transacao));
	}

	/*
	 * @RequestMapping(method=RequestMethod.DELETE, path="deletar/{id}" ) public
	 * ResponseEntity<?> saldo( @PathVariable Long id){
	 * 
	 * this.transacoesService.delete(id);
	 * 
	 * return new ResponseEntity<>( HttpStatus.OK); }
	 */

	/*
	 * @RequestMapping(method=RequestMethod.POST, path="salvar" ) public
	 * ResponseEntity<?> depositar(@RequestBody Transacoes trans){
	 * 
	 * Transacoes transacao = this.transacoesService.salvar(trans); return new
	 * ResponseEntity<>(transacao, HttpStatus.OK); }
	 */
}
