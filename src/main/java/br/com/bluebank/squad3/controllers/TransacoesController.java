package br.com.bluebank.squad3.controllers;

import java.util.List;

import br.com.bluebank.squad3.models.Conta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bluebank.squad3.models.Transacoes;
import br.com.bluebank.squad3.services.TransferenciaService;
import br.com.bluebank.squad3.services.TransacoesService;

@Api(value="API Rest Tramsações")
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

	@Autowired
	private TransacoesService transacoesService;

	@Autowired
	private TransferenciaService transferenciaService;

	@PostMapping("/")
	public void create(@RequestBody Transacoes transacoes) {
		transacoesService.salvar(transacoes);
		transferenciaService.Transferir(transacoes);
	}

	/*
	 * @RequestMapping(method=RequestMethod.POST, path="salvar" ) public
	 * ResponseEntity<?> depositar(@RequestBody Transacoes trans){
	 * 
	 * Transacoes transacao = this.transacoesService.salvar(trans); return new
	 * ResponseEntity<>(transacao, HttpStatus.OK); }
	 */

	@ApiOperation("Lista Transações")
	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public ResponseEntity<List<Transacoes>> listarTransacoes() {
		return  ResponseEntity.ok(transacoesService.listar());
	}

	@ApiOperation("Traz uma transação")
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
}
