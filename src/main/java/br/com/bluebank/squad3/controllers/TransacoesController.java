package br.com.bluebank.squad3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.squad3.models.Transacoes;
import br.com.bluebank.squad3.services.MovimentacaoService;
import br.com.bluebank.squad3.services.TransacoesService;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

	@Autowired
	private TransacoesService transacoesService;

	@Autowired
	private MovimentacaoService movimentacaoservice;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public void create(@RequestBody Transacoes transacoes) {
		transacoesService.salvar(transacoes);
		movimentacaoservice.Transferir(transacoes);
	}

	/*
	 * @RequestMapping(method=RequestMethod.POST, path="salvar" ) public
	 * ResponseEntity<?> depositar(@RequestBody Transacoes trans){
	 * 
	 * Transacoes transacao = this.transacoesService.salvar(trans); return new
	 * ResponseEntity<>(transacao, HttpStatus.OK); }
	 */

	@RequestMapping(method = RequestMethod.GET, path = "listar")
	public ResponseEntity<?> listar() {

		List<Transacoes> transacoes = this.transacoesService.listar();
		return new ResponseEntity<>(transacoes, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "buscar/{id}")
	public ResponseEntity<?> lisbuscarPorId(@PathVariable Long id) {
		transacoesService.listarporId(id);
		return new ResponseEntity<>(HttpStatus.OK);
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
