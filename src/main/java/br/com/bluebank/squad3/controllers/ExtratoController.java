package br.com.bluebank.squad3.controllers;

import br.com.bluebank.squad3.models.Conta;
import br.com.bluebank.squad3.models.Transacoes;
import br.com.bluebank.squad3.services.ExtratoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/extrato")
public class ExtratoController {
    @Autowired
    private ExtratoService extratoService;

    @ApiOperation("Lista os debitos de uma conta")
    @GetMapping("/debito/{idconta}")
    public ResponseEntity <List<Transacoes>> Debitos(@PathVariable Long idconta) {

        return ResponseEntity.ok(extratoService.ExtratoDebito(idconta));
    }
    @ApiOperation("Lista os creditos de uma conta")
    @GetMapping("/credito/{idconta}")
    public ResponseEntity <List<Transacoes>> Creditos(@PathVariable Long idconta) {

        return ResponseEntity.ok(extratoService.ExtratoCredito(idconta));
    }
    //    @RequestMapping(method = RequestMethod.GET, value = "/debito/{idconta}")
//    public List<Transacoes> Debitos(@PathVariable Long idconta){
//        return extratoService.ExtratoDebito(idconta);
//    }
//    @RequestMapping(method = RequestMethod.GET, value = "/credito/{idconta}")
//    public List<Transacoes> Creditos(@PathVariable Long idconta){
//        return extratoService.ExtratoCredito(idconta);
//    }
}
