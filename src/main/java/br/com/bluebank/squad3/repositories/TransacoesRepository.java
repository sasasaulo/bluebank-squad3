package br.com.bluebank.squad3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bluebank.squad3.models.Transacoes;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {

}
