package br.com.bluebank.squad3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluebank.squad3.models.Transacoes;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {

}
